package com.jveventsplatform.Java_Events_Platform.repository;

import com.jveventsplatform.Java_Events_Platform.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
}
