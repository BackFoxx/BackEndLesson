package com.example.restapi.events;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.time.Month;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
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
                .andExpect(jsonPath("_links.update-event").exists());
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
                .andExpect(jsonPath("$[0].objectName").exists())
//                .andExpect(jsonPath("$[0].field").exists())
                .andExpect(jsonPath("$[0].defaultMessage").exists())
                .andExpect(jsonPath("$[0].code").exists());
//                .andExpect(jsonPath("$[0].rejectedValue").exists());
    }
}
