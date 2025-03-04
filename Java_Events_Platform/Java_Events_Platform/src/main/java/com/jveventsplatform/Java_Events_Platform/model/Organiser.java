package com.jveventsplatform.Java_Events_Platform.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Details of the event's organiser")
public class Organiser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @Schema(hidden = true)
    private Long id;

    @NotBlank(message = "Organiser name is required")
    @Size(min = 1, max = 50, message = "Name must be between 1 and 50 characters")
    @Column
    @Schema(description = "Name of the organiser", example = "Dynamite Events", minLength = 1, maxLength = 50)
    private String name;

    @NotBlank(message = "Organiser email is required")
    @Size(min = 5, max = 50, message = "Email must be between 5 and 50 characters")
    @Column
    @Schema(description = "Email of the organiser", example = "hello@dynamiteevents.co.uk", minLength = 5, maxLength = 50)
    private String email;

    @NotNull(message = "Organiser phone number is required")
    @Size(min = 9, max = 15, message = "Number must be between 9 and 15 digits")
    @Column
    @Schema(description = "Organiser's phone number", example = "01619505229", minLength = 9, maxLength = 15)
    private String phoneNumber;

    @OneToMany(mappedBy = "organiser", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    //@JsonManagedReference(value = "organiserReference")
    @Schema(hidden = true)
    private List<Event> events;
}
