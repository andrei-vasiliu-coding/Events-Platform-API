package com.jveventsplatform.Java_Events_Platform.repository;

import com.jveventsplatform.Java_Events_Platform.model.Event;
import com.jveventsplatform.Java_Events_Platform.model.Location;
import com.jveventsplatform.Java_Events_Platform.model.Organiser;
import com.jveventsplatform.Java_Events_Platform.model.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
    List<Event> findByTitle(String title);
    List<Event> findByDate(LocalDate eventDate);
    List<Event> findByStartTime(LocalTime startTime);
    List<Event> findByType(Type type);
    List<Event> findByPrice(String price);
    List<Event> findByLocation(Location location);
    List<Event> findByOrganiser(Organiser organiser);
}
