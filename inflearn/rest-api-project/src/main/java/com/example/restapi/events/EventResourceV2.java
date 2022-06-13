package com.example.restapi.events;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

public class EventResourceV2 extends EntityModel<Event> {
    protected EventResourceV2(Event event) {
        super(event);
//        add(new Link("http://localhost:8080/api/events/" + event.getId()));
        add(linkTo(EventController.class).slash(event.getId()).withSelfRel());
    }

    public void addUpdateEvent() {
        add(linkTo(EventController.class).withRel("update-event"));
    }

    public void addQueryEvents() {
        add(linkTo(EventController.class).withRel("query-events"));
    }
}
