package com.jveventsplatform.Java_Events_Platform.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Location and address of the event")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @Schema(hidden = true)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 1, max = 50, message = "Name must be between 1 and 50 characters")
    @Column
    @Schema(description = "Name of the location", example = "Manchester Arena", minLength = 1, maxLength = 50)
    private String name;

    @NotBlank(message = "Address is required")
    @Size(min = 1, max = 200, message = "Address must be between 1 and 200 characters")
    @Column
    @Schema(description = "Address of the event", example = "Victoria Station Approach, Hunts Bank, Cheetham Hill", minLength = 1, maxLength = 200)
    private String address;

    @NotBlank(message = "City is required")
    @Size(min = 1, max = 50, message = "City must be between 1 and 50 characters")
    @Column
    @Schema(description = "City of the event", example = "Manchester", minLength = 1, maxLength = 50)
    private String city;

    @NotBlank(message = "Postcode is required")
    @Size(min = 1, max = 7, message = "Postcode must be between 1 and 7 characters")
    @Column
    @Schema(description = "Postcode of the event", example = "M3 1AR", minLength = 1, maxLength = 7)
    private String postcode;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    @JsonManagedReference
    @Schema(hidden = true)
    private Event event;
}
