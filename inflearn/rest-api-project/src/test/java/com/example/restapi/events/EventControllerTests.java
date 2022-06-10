package com.example.restapi.events;

import com.example.restapi.common.RestDocsConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.time.Month;

import static org.springframework.restdocs.headers.HeaderDocumentation.*;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
@Import(RestDocsConfiguration.class)
@ActiveProfiles("test")
public class EventControllerTests {

    @Autowired
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;
    ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        mockMvc = webApplicationContext.getBean(MockMvc.class);
        objectMapper = webApplicationContext.getBean(ObjectMapper.class);
    }

    @Test
    @DisplayName("EventController 정상 작동 확인")
    void createEvent() throws Exception {
        EventDto eventDto = EventDto.builder()
                .name("spring")
                .description("REST api")
                .beginEnrollmentDateTime(LocalDateTime.of(2022, Month.JUNE, 9, 9, 54))
                .closeEnrollmentDateTime(LocalDateTime.of(2022, Month.JUNE, 10, 9, 54))
                .beginEventDateTime(LocalDateTime.of(2022, Month.JUNE, 11, 9, 54))
                .endEventDateTime(LocalDateTime.of(2022, Month.JUNE, 12, 9, 54))
                .basePrice(100)
                .maxPrice(200)
                .limitOfEnrollment(100)
                .location("강남역")
                .build();

        mockMvc.perform(post("/api/events/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaTypes.HAL_JSON)
                        .content(objectMapper.writeValueAsString(eventDto)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaTypes.HAL_JSON_VALUE + ";charset=UTF-8"))
                .andExpect(jsonPath("id").exists())
                .andExpect(jsonPath("free").value(false))
                .andExpect(jsonPath("offline").value(true))
                .andExpect(jsonPath("eventStatus").value(EventStatus.DRAFT.name()))
                .andExpect(jsonPath("_links.self").exists())
                .andExpect(jsonPath("_links.query-events").exists())
                .andExpect(jsonPath("_links.update-event").exists())
                .andDo(document("create-event",
                        links(
                                linkWithRel("self").description("link to self"),
                                linkWithRel("query-events").description("link to query events"),
                                linkWithRel("update-event").description("link to update an existing event"),
                                linkWithRel("profile").description("link to profile")
                        ),
                        requestHeaders(
                                headerWithName(HttpHeaders.ACCEPT).description("accept header"),
                                headerWithName(HttpHeaders.CONTENT_TYPE).description("content type")
                        ),
                        requestFields(
                                fieldWithPath("name").description("이벤트 이름"),
                                fieldWithPath("description").description("이벤트 설명"),
                                fieldWithPath("beginEnrollmentDateTime").description("경매 시작 시간"),
                                fieldWithPath("closeEnrollmentDateTime").description("경매 종료 시간"),
                                fieldWithPath("beginEventDateTime").description("이벤트 시작 시간"),
                                fieldWithPath("endEventDateTime").description("이벤트 종료 시간"),
                                fieldWithPath("location").description("개최 장소"),
                                fieldWithPath("basePrice").description("시작가"),
                                fieldWithPath("maxPrice").description("최대가"),
                                fieldWithPath("limitOfEnrollment").description("최대 경매 수")
                        ),
                        responseHeaders(
                                headerWithName(HttpHeaders.LOCATION).description("location header"),
                                headerWithName(HttpHeaders.CONTENT_TYPE).description("content type header®")
                        ),
//                        relaxedResponseFields( // 문서의 일부분만 확인하기 때문에 누락된 요소가 있어도 허용된다.
                        responseFields( // 문서의 일부분만 확인하기 때문에 누락된 요소가 있어도 허용된다.
                                fieldWithPath("id").description("아이디"),
                                fieldWithPath("name").description("이벤트 이름"),
                                fieldWithPath("description").description("이벤트 설명"),
                                fieldWithPath("beginEnrollmentDateTime").description("경매 시작 시간"),
                                fieldWithPath("closeEnrollmentDateTime").description("경매 종료 시간"),
                                fieldWithPath("beginEventDateTime").description("이벤트 시작 시간"),
                                fieldWithPath("endEventDateTime").description("이벤트 종료 시간"),
                                fieldWithPath("location").description("개최 장소"),
                                fieldWithPath("basePrice").description("시작가"),
                                fieldWithPath("maxPrice").description("최대가"),
                                fieldWithPath("limitOfEnrollment").description("최대 경매 수"),
                                fieldWithPath("free").description("무료 여부"),
                                fieldWithPath("offline").description("오프라인 여부"),
                                fieldWithPath("eventStatus").description("이벤트 상태"),
                                fieldWithPath("_links.self.href").description("self link"),
                                fieldWithPath("_links.query-events.href").description("query-events link"),
                                fieldWithPath("_links.update-event.href").description("update-event link"),
                                fieldWithPath("_links.profile.href").description("profile link")
//                                fieldWithPath("_links.*").ignored(),
//                                fieldWithPath("_links.self.*").ignored(),
//                                fieldWithPath("_links.query-events.*").ignored(),
//                                fieldWithPath("_links.update-event.*").ignored() // 각 항목을 무시
                        )
                ));
    }

    @Test
    @DisplayName("입력값 이외의 값이 들어오면 에러")
    void createEvent_400() throws Exception {
        EventDto eventDto = EventDto.builder()
                .name("spring")
                .description("REST api")
                .beginEnrollmentDateTime(LocalDateTime.of(2022, Month.JUNE, 9, 9, 54))
                .closeEnrollmentDateTime(LocalDateTime.of(2022, Month.JUNE, 10, 9, 54))
                .beginEventDateTime(LocalDateTime.of(2022, Month.JUNE, 11, 9, 54))
                .endEventDateTime(LocalDateTime.of(2022, Month.JUNE, 12, 9, 54))
                .basePrice(100)
                .maxPrice(200)
                .limitOfEnrollment(100)
                .location("강남역")
                .build();

        mockMvc.perform(post("/api/events/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaTypes.HAL_JSON)
                        .content(objectMapper.writeValueAsString(eventDto)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaTypes.HAL_JSON_VALUE+";charset=UTF-8"))
                .andExpect(jsonPath("id").value(Matchers.not(100)))
                .andExpect(jsonPath("free").value(Matchers.not(true)))
                .andExpect(jsonPath("eventStatus").value(EventStatus.DRAFT.name()));

        Event event = Event.builder()
                .name("spring")
                .description("REST api")
                .beginEnrollmentDateTime(LocalDateTime.of(2022, Month.JUNE, 9, 9, 54))
                .closeEnrollmentDateTime(LocalDateTime.of(2022, Month.JUNE, 10, 9, 54))
                .beginEventDateTime(LocalDateTime.of(2022, Month.JUNE, 11, 9, 54))
                .endEventDateTime(LocalDateTime.of(2022, Month.JUNE, 12, 9, 54))
                .basePrice(100)
                .maxPrice(200)
                .limitOfEnrollment(100)
                .location("강남역")
                .free(true)
                .build();

        mockMvc.perform(post("/api/events/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaTypes.HAL_JSON)
                        .content(objectMapper.writeValueAsString(event)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("빈 입력값에 대한 400 에러")
    void createEvent_400_Empty_Input() throws Exception {
        EventDto eventDto = EventDto.builder().build();

        mockMvc.perform(post("/api/events")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(eventDto)))
                .andExpect(status().isBadRequest());
    }


    @Test
    @DisplayName("이상한 입력값에 대한 400 에러")
    void createEvent_400_Wrong_Input() throws Exception {
        EventDto eventDto = EventDto.builder()
                .name("spring")
                .description("REST api")
                .beginEnrollmentDateTime(LocalDateTime.of(2022, Month.JUNE, 12, 9, 54))
                .closeEnrollmentDateTime(LocalDateTime.of(2022, Month.JUNE, 11, 9, 54))
                .beginEventDateTime(LocalDateTime.of(2022, Month.JUNE, 10, 9, 54))
                .endEventDateTime(LocalDateTime.of(2022, Month.JUNE, 9, 9, 54))
                .basePrice(10000)
                .maxPrice(200)
                .limitOfEnrollment(100)
                .location("강남역")
                .build();

        mockMvc.perform(post("/api/events")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(eventDto)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("errors[0].objectName").exists())
//                .andExpect(jsonPath("$[0].field").exists())
                .andExpect(jsonPath("errors[0].defaultMessage").exists())
                .andExpect(jsonPath("errors[0].code").exists())
                .andExpect(jsonPath("_links.index").exists());
//                .andExpect(jsonPath("$[0].rejectedValue").exists());
    }
}
