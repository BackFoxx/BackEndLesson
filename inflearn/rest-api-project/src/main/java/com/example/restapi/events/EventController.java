package com.example.restapi.events;

import com.example.restapi.common.ErrorsResource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.*;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/api/events", produces = MediaTypes.HAL_JSON_VALUE)
public class EventController {
    private final EventRepository eventRepository;
    private final ModelMapper modelMapper;
    private final EventValidator eventValidator;

    @GetMapping
    public ResponseEntity queryEvents(Pageable pageable, PagedResourcesAssembler<Event> assembler) {
        Page<Event> page = this.eventRepository.findAll(pageable);
        var resource = assembler.toModel(page,
                (RepresentationModelAssembler<Event, RepresentationModel<?>>) entity -> new EventResourceV2(entity));
        resource.add(Link.of("/docs/index.html#resources-events-list").withRel("profile"));
        return ResponseEntity.ok(resource);
    }

    @GetMapping("/{id}")
    public ResponseEntity getEvent(@PathVariable Integer id) {
        Optional<Event> optionalEvent = this.eventRepository.findById(id);
        if (optionalEvent.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Event event = optionalEvent.get();
        EventResourceV2 eventResource = new EventResourceV2(event);
        eventResource.add(Link.of("/docs/index.html#resources-events-get").withRel("profile"));
        return ResponseEntity.ok(eventResource);
    }

    @PostMapping
    public ResponseEntity createEvent(@RequestBody @Validated EventDto eventDto,
                                      Errors errors) {
        if (errors.hasErrors()) {
            return badRequest(errors);
        }

        eventValidator.validate(eventDto, errors);

        if (errors.hasErrors()) {
            return badRequest(errors);
        }

        Event event = modelMapper.map(eventDto, Event.class);
        event.update();

        Event newEvent = eventRepository.save(event);

        WebMvcLinkBuilder selfLinkBuilder = linkTo(EventController.class).slash(newEvent.getId());
        URI createdUri = selfLinkBuilder.toUri();

//        EventResource eventResource = new EventResource(event);
//        eventResource.add(linkTo(EventController.class).withRel("query-events"));
//        eventResource.add(selfLinkBuilder.withSelfRel());
//        eventResource.add(selfLinkBuilder.withRel("update-event"));
        // ==
        EntityModel<Event> eventEntityModel = EntityModel.of(newEvent,
                selfLinkBuilder.slash(event.getId()).withSelfRel(),
                selfLinkBuilder.withRel("query-events"),
                selfLinkBuilder.withRel("update-event"),
                Link.of("/docs/index.html#resource-events-create").withRel("profile"));
        // ==
//        EventResourceV2 eventResourceV2 = new EventResourceV2(event);
//        eventResourceV2.addQueryEvents();
//        eventResourceV2.addUpdateEvent();

        return ResponseEntity.created(createdUri).body(eventEntityModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateEvent(@PathVariable Integer id,
                                      @Validated @RequestBody EventDto updateEvent,
                                      Errors errors) {
        // 수정할 이벤트 항목이 이상하면 400
        if (errors.hasErrors()) {
            return this.badRequest(errors);
        }

        this.eventValidator.validate(updateEvent, errors);

        if (errors.hasErrors()) {
            return this.badRequest(errors);
        }

        Optional<Event> optionalEvent = this.eventRepository.findById(id);
        // 수정할 이벤트가 없으면 404
        if (optionalEvent.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Event event = optionalEvent.get();
        this.modelMapper.map(updateEvent, event);
        Event updatedEvent = this.eventRepository.save(event);

        EventResourceV2 eventResource = new EventResourceV2(updatedEvent);
        eventResource.add(Link.of("/docs/index.html#resources-events-update").withRel("profile"));

        return ResponseEntity.ok(eventResource);
    }

    private ResponseEntity<ErrorsResource> badRequest(Errors errors) {
        return ResponseEntity.badRequest().body(new ErrorsResource(errors));
    }
}
