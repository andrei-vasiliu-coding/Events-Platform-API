package com.jveventsplatform.Java_Events_Platform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventRegistration {

    @EmbeddedId
    private EventRegistrationId id; // Composite Primary Key

    @ManyToOne
    @MapsId("userId") // Maps 'userId' from composite key
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @MapsId("eventId") // Maps 'eventId' from composite key
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;

    public EventRegistration(Long userId, Long eventId, User user, Event event) {
        this.id = new EventRegistrationId(userId, eventId);
        this.event = event;
        this.user = user;
    }
}
