package com.jveventsplatform.Java_Events_Platform.repository;

import com.jveventsplatform.Java_Events_Platform.model.EventRegistration;
import com.jveventsplatform.Java_Events_Platform.model.EventRegistrationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRegistrationRepository extends JpaRepository<EventRegistration, EventRegistrationId> {
}
