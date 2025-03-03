package com.jveventsplatform.Java_Events_Platform.controller;

import com.jveventsplatform.Java_Events_Platform.model.Event;
import com.jveventsplatform.Java_Events_Platform.service.EventService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Event", description = "APIs for managing events within the platform")
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping("/events")
    public ResponseEntity<List<Event>> getAllEvents() {
        return new ResponseEntity<>(eventService.getAllEvents(), HttpStatus.OK);
    }

    @PostMapping("/event")
    public ResponseEntity<Event> postEvent(@RequestBody Event event) {
        Event postEvent = eventService.postEvent(event);
        return new ResponseEntity<>(postEvent, HttpStatus.CREATED);
    }

    @PutMapping("/event")
    public ResponseEntity<Event> putEvent(@RequestBody Event event) {
        Event putEvent = eventService.putEvent(event);
        return new ResponseEntity<>(putEvent, HttpStatus.OK);
    }

    @PatchMapping("/event")
    public ResponseEntity<Event> patchEvent(@RequestBody Event event) {
        Event patchedEvent = eventService.patchEvent(event);
        return new ResponseEntity<>(patchedEvent, HttpStatus.OK);
    }

    @DeleteMapping("/event/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEventById(id);
        return ResponseEntity.noContent().build();
    }
}
