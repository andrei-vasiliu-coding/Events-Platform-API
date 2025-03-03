package com.jveventsplatform.Java_Events_Platform.repository;

import com.jveventsplatform.Java_Events_Platform.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
    List<Event> findByName(String name);
}
