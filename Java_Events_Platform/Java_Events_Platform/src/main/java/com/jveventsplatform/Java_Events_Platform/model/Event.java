package com.jveventsplatform.Java_Events_Platform.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
    private Long id;

    @NotNull(message = "Event date is required")
    @FutureOrPresent(message = "Event date cannot be in the past")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Schema(description = "Date when the event takes place", example = "01-07-2025")
    private LocalDate eventDate;

    @NotBlank(message = "Title is required")
    @Size(min = 5, max = 100, message = "Title must be between 5 and 100 characters")
    @Schema(description = "Title of the event", example = "Lady Gaga concert at Manchester Arena", minLength = 5, maxLength = 100)
    private String title;

    @NotBlank(message = "Event description is required")
    @Size(max = 1000, message = "Event description must not exceed 1000 characters")
    @Schema(description = "Description of the event", example = "Lady Gaga is back in the UK with her recent album breaking the records on Spotify and returning to her most acclaimed era!", maxLength = 1000)
    private String description;

    @NotNull(message = "Event type is required")
    @Column
    @Schema(description = "Type of the event", example = "Concert")
    private Type type;

    @NotNull(message = "Location is required")
    @OneToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @NotNull(message = "Event price is required")
    @Column
    @Schema(description = "The price of an event")
    private int price;

}
