package com.jveventsplatform.Java_Events_Platform.service;

import com.jveventsplatform.Java_Events_Platform.model.Event;
import com.jveventsplatform.Java_Events_Platform.model.Location;
import com.jveventsplatform.Java_Events_Platform.model.Organiser;
import com.jveventsplatform.Java_Events_Platform.model.Type;

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
    List<Event> getEventsByDate(LocalDate eventDate);
    List<Event> getEventsByStartTime(LocalTime startTime);
    List<Event> getEventsByType(Type type);
    List<Event> getEventsByPrice(String price);
    List<Event> getEventsByLocation(Location location);
    List<Event> getEventsByOrganiser(Organiser organiser);
}
