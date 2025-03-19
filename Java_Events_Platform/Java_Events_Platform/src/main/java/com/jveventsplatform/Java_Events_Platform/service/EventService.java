package com.jveventsplatform.Java_Events_Platform.service;

import com.jveventsplatform.Java_Events_Platform.model.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface EventService {
    List<Event> getAllEvents();
    Event postEvent(Event event);
    Event putEvent(Event event);
    Event patchEvent(Event event);
    void deleteEventById(Long id);

    List<Event> getEventsByTitle(String title);
    List<Event> getEventsByEventDate(LocalDate eventDate);
    List<Event> getEventsByStartTime(LocalTime startTime);
    List<Event> getEventsByType(String type);
    List<Event> getEventsByPrice(String price);
    List<Event> getEventsByLocationName(String locationName);
    List<Event> getEventsByOrganiserName(String organiser);

    EventRegistrationId registerUserForEvent(Long userId, Long eventId);
}
