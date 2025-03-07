package com.jveventsplatform.Java_Events_Platform.service;

import com.jveventsplatform.Java_Events_Platform.exception.ItemNotFoundException;
import com.jveventsplatform.Java_Events_Platform.model.Event;
import com.jveventsplatform.Java_Events_Platform.model.Location;
import com.jveventsplatform.Java_Events_Platform.model.Organiser;
import com.jveventsplatform.Java_Events_Platform.model.Type;
import com.jveventsplatform.Java_Events_Platform.repository.EventRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepository eventRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Event> getAllEvents() {
        ArrayList<Event> allEvents = new ArrayList<>();
        eventRepository.findAll().forEach(allEvents::add);
        return allEvents;
    }

    @Override
    @Transactional
    public Event postEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    @Transactional
    public Event putEvent(Event event) {
        if (!eventRepository.existsById(event.getId())) {
            throw new ItemNotFoundException("Event with id " + event.getId() + " not found");
        }
        return eventRepository.save(event);
    }

    @Override
    @Transactional
    public Event patchEvent(Event event) {
        if (event.getId() == null) {
            throw new IllegalArgumentException("Event ID cannot be null for patching");
        }

        Optional<Event> existingOpt = eventRepository.findById(event.getId());
        if (existingOpt.isEmpty()) {
            throw new ItemNotFoundException("Event with ID " + event.getId() + " not found.");
        }
        Event existingEvent = existingOpt.get();

        if (event.getTitle() != null) {
            existingEvent.setTitle(event.getTitle());
        }
        if (event.getEventDate() != null) {
            existingEvent.setEventDate(event.getEventDate());
        }
        if (event.getStartTime() != null) {
            existingEvent.setStartTime(event.getStartTime());
        }
        if (event.getType() != null) {
            existingEvent.setType(event.getType());
        }
        if (event.getPrice() != null) {
            existingEvent.setPrice(event.getPrice());
        }
        if (event.getLocation() != null) {
            existingEvent.setLocation(event.getLocation());
        }
        if (event.getOrganiser() != null) {
            existingEvent.setOrganiser(event.getOrganiser());
        }
        if (event.getDescription() != null) {
            existingEvent.setDescription(event.getDescription());
        }
        if (event.getEndTime() != null) {
            existingEvent.setEndTime(event.getEndTime());
        }
        return eventRepository.save(existingEvent);
    }

    @Override
    @Transactional
    public void deleteEventById(Long id) {
        if (!eventRepository.existsById(id)) {
            throw new ItemNotFoundException("Event with ID " + id + " not found");
        }
        eventRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Event> getEventsByTitle(String title) {
        return eventRepository.findByTitle(title);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Event> getEventsByEventDate(LocalDate eventDate) {
        return eventRepository.findByEventDate(eventDate);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Event> getEventsByStartTime(LocalTime startTime) {
        return eventRepository.findByStartTime(startTime);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Event> getEventsByType(String type) {
        Type eventType;
        try {
            eventType = Type.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ItemNotFoundException("Invalid event type: " + type);
        }
        return eventRepository.findByType(eventType);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Event> getEventsByPrice(String price) {
        return eventRepository.findByPrice(price);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Event> getEventsByLocationName(String locationName) {
        return eventRepository.findByLocationName(locationName);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Event> getEventsByOrganiserName(String organiserName) {
        return eventRepository.findByOrganiserName(organiserName);
    }
}