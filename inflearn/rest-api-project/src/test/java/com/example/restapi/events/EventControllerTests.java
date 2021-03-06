package com.example.restapi.events;

import com.example.restapi.common.RestDocsConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.stream.IntStream;

import static org.springframework.restdocs.headers.HeaderDocumentation.*;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
@Import(RestDocsConfiguration.class)
@ActiveProfiles("test")
public class EventControllerTests {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    EventRepository eventRepository;

    MockMvc mockMvc;
    ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        mockMvc = webApplicationContext.getBean(MockMvc.class);
        objectMapper = webApplicationContext.getBean(ObjectMapper.class);
    }

    @Test
    @DisplayName("EventController ?????? ?????? ??????")
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
                .location("?????????")
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
                                fieldWithPath("name").description("????????? ??????"),
                                fieldWithPath("description").description("????????? ??????"),
                                fieldWithPath("beginEnrollmentDateTime").description("?????? ?????? ??????"),
                                fieldWithPath("closeEnrollmentDateTime").description("?????? ?????? ??????"),
                                fieldWithPath("beginEventDateTime").description("????????? ?????? ??????"),
                                fieldWithPath("endEventDateTime").description("????????? ?????? ??????"),
                                fieldWithPath("location").description("?????? ??????"),
                                fieldWithPath("basePrice").description("?????????"),
                                fieldWithPath("maxPrice").description("?????????"),
                                fieldWithPath("limitOfEnrollment").description("?????? ?????? ???")
                        ),
                        responseHeaders(
                                headerWithName(HttpHeaders.LOCATION).description("location header"),
                                headerWithName(HttpHeaders.CONTENT_TYPE).description("content type header??")
                        ),
//                        relaxedResponseFields( // ????????? ???????????? ???????????? ????????? ????????? ????????? ????????? ????????????.
                        responseFields( // ????????? ???????????? ???????????? ????????? ????????? ????????? ????????? ????????????.
                                fieldWithPath("id").description("?????????"),
                                fieldWithPath("name").description("????????? ??????"),
                                fieldWithPath("description").description("????????? ??????"),
                                fieldWithPath("beginEnrollmentDateTime").description("?????? ?????? ??????"),
                                fieldWithPath("closeEnrollmentDateTime").description("?????? ?????? ??????"),
                                fieldWithPath("beginEventDateTime").description("????????? ?????? ??????"),
                                fieldWithPath("endEventDateTime").description("????????? ?????? ??????"),
                                fieldWithPath("location").description("?????? ??????"),
                                fieldWithPath("basePrice").description("?????????"),
                                fieldWithPath("maxPrice").description("?????????"),
                                fieldWithPath("limitOfEnrollment").description("?????? ?????? ???"),
                                fieldWithPath("free").description("?????? ??????"),
                                fieldWithPath("offline").description("???????????? ??????"),
                                fieldWithPath("eventStatus").description("????????? ??????"),
                                fieldWithPath("_links.self.href").description("self link"),
                                fieldWithPath("_links.query-events.href").description("query-events link"),
                                fieldWithPath("_links.update-event.href").description("update-event link"),
                                fieldWithPath("_links.profile.href").description("profile link")
//                                fieldWithPath("_links.*").ignored(),
//                                fieldWithPath("_links.self.*").ignored(),
//                                fieldWithPath("_links.query-events.*").ignored(),
//                                fieldWithPath("_links.update-event.*").ignored() // ??? ????????? ??????
                        )
                ));
    }

    @Test
    @DisplayName("????????? ????????? ?????? ???????????? ??????")
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
                .location("?????????")
                .build();

        mockMvc.perform(post("/api/events/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaTypes.HAL_JSON)
                        .content(objectMapper.writeValueAsString(eventDto)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaTypes.HAL_JSON_VALUE + ";charset=UTF-8"))
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
                .location("?????????")
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
    @DisplayName("??? ???????????? ?????? 400 ??????")
    void createEvent_400_Empty_Input() throws Exception {
        EventDto eventDto = EventDto.builder().build();

        mockMvc.perform(post("/api/events")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(eventDto)))
                .andExpect(status().isBadRequest());
    }


    @Test
    @DisplayName("????????? ???????????? ?????? 400 ??????")
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
                .location("?????????")
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

    @Test
    @DisplayName("30?????? ???????????? 10?????? ????????? ????????? ????????????")
    public void getEvents() throws Exception {
        // given
        IntStream.range(0, 30).forEach(this::generateEvent);

        //when
        this.mockMvc.perform(get("/api/events")
                        .param("page", "1")
                        .param("size", "10")
                        .param("sort", "name,DESC"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("page").exists())

                .andExpect(jsonPath("_embedded.eventList[0]._links.self").exists())
                .andExpect(jsonPath("_links.self").exists())
                .andExpect(jsonPath("_links.profile").exists())
                .andDo(document("query-events"));
    }

    @Test
    @DisplayName("????????? ???????????? ?????? ????????????")
    void getEvent() throws Exception {
        // given
        Event event = this.generateEvent(100);

        //when&then
        this.mockMvc.perform(get("/api/events/{id}", event.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").exists())
                .andExpect(jsonPath("id").exists())
                .andExpect(jsonPath("_links.self").exists())
                .andExpect(jsonPath("_links.profile").exists())
                // ?????????
                .andDo(document("get-events"));
    }

    @Test
    @DisplayName("?????? ???????????? ???????????? ??? 404 ????????????")
    void getEvent404() throws Exception {
        //when&then
        this.mockMvc.perform(get("/api/events/{id}", -99))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("????????? ?????? ?????? ?????????")
    void updateEvent() throws Exception {
        //given
        Event event = Event.builder()
                .name("????????? 1")
                .description("????????? ?????? 1")
                .beginEnrollmentDateTime(LocalDateTime.of(2022, Month.JUNE, 9, 9, 54))
                .closeEnrollmentDateTime(LocalDateTime.of(2022, Month.JUNE, 10, 9, 54))
                .beginEventDateTime(LocalDateTime.of(2022, Month.JUNE, 11, 9, 54))
                .endEventDateTime(LocalDateTime.of(2022, Month.JUNE, 12, 9, 54))
                .basePrice(100)
                .maxPrice(200)
                .limitOfEnrollment(100)
                .location("?????????")
                .build();

        Event savedEvent = this.eventRepository.save(event);

        //when & then
        EventDto eventDto = this.modelMapper.map(savedEvent, EventDto.class);

        String updateName = "??????????????? ????????? 1";
        eventDto.setName(updateName);
        String updateDescription = "??????????????? ????????? ?????? 1";
        eventDto.setDescription(updateDescription);

        this.mockMvc.perform(put("/api/events/{id}", savedEvent.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaTypes.HAL_JSON)
                        .content(this.objectMapper.writeValueAsString(eventDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value(updateName))
                .andExpect(jsonPath("description").value(updateDescription))
                .andExpect(jsonPath("_links.self").exists())
                .andExpect(jsonPath("_links.profile").exists());
    }

    @Test
    @DisplayName("??????????????? ???????????? ?????? ?????? 404")
    void updateEvent_404() throws Exception {
        EventDto eventDto = EventDto.builder()
                .name("????????? 1")
                .description("????????? ?????? 1")
                .beginEnrollmentDateTime(LocalDateTime.of(2022, Month.JUNE, 9, 9, 54))
                .closeEnrollmentDateTime(LocalDateTime.of(2022, Month.JUNE, 10, 9, 54))
                .beginEventDateTime(LocalDateTime.of(2022, Month.JUNE, 11, 9, 54))
                .endEventDateTime(LocalDateTime.of(2022, Month.JUNE, 12, 9, 54))
                .basePrice(100)
                .maxPrice(200)
                .limitOfEnrollment(100)
                .location("?????????")
                .build();

        this.mockMvc.perform(put("/api/events/{id}", -88)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaTypes.HAL_JSON)
                        .content(this.objectMapper.writeValueAsString(eventDto)))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("??????????????? ????????? ????????? ????????? ?????? 400")
    void updateEvent_400() throws Exception {
        //given
        Event event = Event.builder()
                .name("????????? 1")
                .description("????????? ?????? 1")
                .build();

        Event savedEvent = this.eventRepository.save(event);

        //when & then
        EventDto eventDto = new EventDto();

        String updateName = ""; // ?????? ??????
        eventDto.setName(updateName);
        String updateDescription = "??????????????? ????????? ?????? 1";
        eventDto.setDescription(updateDescription);

        this.mockMvc.perform(put("/api/events/{id}", savedEvent.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaTypes.HAL_JSON)
                        .content(this.objectMapper.writeValueAsString(eventDto)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    private Event generateEvent(int i) {
        Event event = Event.builder()
                .name("event " + i)
                .description("test event")
                .build();
        return this.eventRepository.save(event);
    }
}
