package com.jveventsplatform.Java_Events_Platform.service;

import com.jveventsplatform.Java_Events_Platform.model.Event;
import com.jveventsplatform.Java_Events_Platform.model.Location;
import com.jveventsplatform.Java_Events_Platform.model.Organiser;
import com.jveventsplatform.Java_Events_Platform.model.Type;
import com.jveventsplatform.Java_Events_Platform.repository.EventRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
            throw new EntityNotFoundException("Event with id " + event.getId() + " not found");
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
            throw new EntityNotFoundException("Event with ID " + event.getId() + " not found.");
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
        return eventRepository.save(existingEvent);
    }

    @Override
    @Transactional
    public void deleteEventById(Long id) {
        if (!eventRepository.existsById(id)) {
            throw new EntityNotFoundException("Event with ID " + id + " not found");
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
    public List<Event> getEventsByDate(LocalDate eventDate) {
        return eventRepository.findByDate(eventDate);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Event> getEventsByStartTime(LocalTime startTime) {
        return eventRepository.findByStartTime(startTime);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Event> getEventsByType(Type type) {
        return eventRepository.findByType(type);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Event> getEventsByPrice(String price) {
        return eventRepository.findByPrice(price);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Event> getEventsByLocation(Location location) {
        return eventRepository.findByLocation(location);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Event> getEventsByOrganiser(Organiser organiser) {
        return eventRepository.findByOrganiser(organiser);
    }
}
