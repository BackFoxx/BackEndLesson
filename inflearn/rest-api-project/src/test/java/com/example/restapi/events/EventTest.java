package com.example.restapi.events;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class EventTest {

    @Test
    void builder() {
        Event event = Event.builder()
                .name("뭄무")
                .description("Rest 뭄무")
                .build();
        assertThat(event).isNotNull();
    }

    @Test
    void javaBean() {
        String name = "Event";
        String description = "뭄무";

        Event event = new Event();
        event.setName(name);
        event.setDescription(description);

        assertThat(event.getName()).isEqualTo(name);
        assertThat(event.getDescription()).isEqualTo(description);
    }

    private static Object[] paramsForTestFree() {
        return new Object[]{
                new Object[]{0, 0, true},
                new Object[]{100, 0, false},
                new Object[]{0, 100, false},
                new Object[]{100, 200, false}
        };
    }

    @ParameterizedTest(name = "{index}번 째 {displayName} : {0}, {1}, {2}")
    @MethodSource("paramsForTestFree")
    @DisplayName("경매가 설정에 따른 isFree 여부 체크")
    void testFree(int basePrice, int maxPrice, boolean isFree) {
        //given
        Event event = Event.builder()
                .basePrice(basePrice)
                .maxPrice(maxPrice)
                .build();

        //when
        event.update();

        assertThat(event.isFree()).isEqualTo(isFree);
    }

    private static Object[] paramsForTestOffline() {
        return new Object[]{
                new Object[]{"네이버 본사", true},
                new Object[]{null, false},
                new Object[]{"", false}
        };
    }

    @ParameterizedTest(name = "{index}번 째 {displayName} : {0}, {1}")
    @MethodSource("paramsForTestOffline")
    @DisplayName("경매가 설정에 따른 isOffline 여부 체크")
    void testOffline(String location, boolean isOffline) {
        //given
        Event event = Event.builder()
                .location(location)
                .build();

        //when
        event.update();

        //then
        assertThat(event.isOffline()).isEqualTo(isOffline);
    }
}