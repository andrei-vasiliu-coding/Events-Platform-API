package com.jveventsplatform.Java_Events_Platform.model;

import com.fasterxml.jackson.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@Schema(description = "Information for an event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @Schema(hidden = true)
    @Getter
    private Long id;

    @NotNull(message = "Event date is required")
    @FutureOrPresent(message = "Event date cannot be in the past")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Schema(description = "Date when the event takes place", example = "01-07-2025")
    @Getter
    private LocalDate eventDate;

    @NotNull(message = "Start time is required")
    @JsonFormat(pattern = "HH:mm")
    @Schema(description = "Start time of the event", example = "19:00")
    @Getter
    private LocalTime startTime;

    @NotNull(message = "End time is required")
    @JsonFormat(pattern = "HH:mm")
    @Schema(description = "End time of the event", example = "23:00")
    @Getter
    private LocalTime endTime;

    @NotBlank(message = "Title is required")
    @Size(min = 5, max = 100, message = "Title must be between 5 and 100 characters")
    @Schema(description = "Title of the event", example = "Lady Gaga concert at Manchester Arena", minLength = 5, maxLength = 100)
    @Getter
    private String title;

    @NotBlank(message = "Event description is required")
    @Size(max = 1000, message = "Event description must not exceed 1000 characters")
    @Schema(description = "Description of the event", example = "Lady Gaga is back in the UK with her recent album breaking the records on Spotify and returning to her most acclaimed era!", maxLength = 1000)
    @Getter
    private String description;

    @NotNull(message = "Event type is required")
    @Column
    @Schema(description = "Type of the event", example = "Concert")
    @Getter
    private Type type;

    @NotNull(message = "Event price is required")
    @Column
    @Schema(description = "The price of an event")
    @Getter
    private String price;

    @NotNull(message = "Location is required")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    //@JsonBackReference(value = "locationReference")
    @Getter
    private Location location;

    @NotNull(message = "Organiser information required")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "organiser_id", referencedColumnName = "id")
    //@JsonBackReference(value = "organiserReference")
    @Getter
    private Organiser organiser;
}
