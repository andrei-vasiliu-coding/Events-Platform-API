package com.jveventsplatform.Java_Events_Platform.controller;

import com.jveventsplatform.Java_Events_Platform.exception.ItemNotFoundException;
import com.jveventsplatform.Java_Events_Platform.model.Event;
import com.jveventsplatform.Java_Events_Platform.model.Location;
import com.jveventsplatform.Java_Events_Platform.model.Organiser;
import com.jveventsplatform.Java_Events_Platform.model.Type;
import com.jveventsplatform.Java_Events_Platform.service.EventService;
import com.jveventsplatform.Java_Events_Platform.service.LocationService;
import com.jveventsplatform.Java_Events_Platform.service.OrganiserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Event", description = "APIs for managing events within the platform")
public class EventController {

    @Autowired
    EventService eventService;

    @Autowired
    LocationService locationService;

    @Autowired
    OrganiserService organiserService;

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

    @GetMapping("/events/title/{title}")
    public ResponseEntity<List<Event>> getEventsByTitle(@PathVariable String title) {
        List<Event> events = eventService.getEventsByTitle(title);
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @GetMapping("/events/date")
    public ResponseEntity<List<Event>> getEventsByDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate eventDate) {
        List<Event> events = eventService.getEventsByDate(eventDate);
        return ResponseEntity.ok(events);
    }

    @GetMapping("/events/startTime")
    public ResponseEntity<List<Event>> getEventsByStartTime(@RequestParam("startTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime startTime) {
        List<Event> events = eventService.getEventsByStartTime(startTime);
        return ResponseEntity.ok(events);
    }

    @GetMapping("/events/type/{type}")
    public ResponseEntity<List<Event>> getEventsByType(@PathVariable("type") Type type) {
        List<Event> events = eventService.getEventsByType(type);
        return ResponseEntity.ok(events);
    }

    @GetMapping("/events/price")
    public ResponseEntity<List<Event>> getEventsByPrice(@RequestParam("price") String price) {
        List<Event> events = eventService.getEventsByPrice(price);
        return ResponseEntity.ok(events);
    }

    @GetMapping("/events/location/{id}")
    public ResponseEntity<List<Event>> getEventsByLocation(@PathVariable("id") Long locationId) {
        Location location = locationService.getLocationById(locationId);
        List<Event> events = eventService.getEventsByLocation(location);
        return ResponseEntity.ok(events);
    }

    @GetMapping("/events/organiser/{id}")
    public ResponseEntity<List<Event>> getEventsByOrganiser(@PathVariable("id") Long organiserId) {
        Organiser organiser = organiserService.getOrganiserById(organiserId);
        List<Event> events = eventService.getEventsByOrganiser(organiser);
        return ResponseEntity.ok(events);
    }
}
