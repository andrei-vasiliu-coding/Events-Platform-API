package com.jveventsplatform.Java_Events_Platform.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Type {
    CONCERT("Concert"),
    SPORT("Sport"),
    CONFERENCE("Conference"),
    WORKSHOP("Workshop"),
    MEETUP("Meetup"),
    FESTIVAL("Festival"),
    EXHIBITION("Exhibition"),
    WEBINAR("Webinar");

    final String typeDescriptor;
    Type(String descriptor) { this.typeDescriptor = descriptor; }

    @JsonValue
    public String getTypeDescriptor() { return typeDescriptor; }

    @JsonCreator
    public static Type fromValue(String value) {
        for (Type type : Type.values()) {
            if (type.typeDescriptor.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid event type: " + value);
    }
}
