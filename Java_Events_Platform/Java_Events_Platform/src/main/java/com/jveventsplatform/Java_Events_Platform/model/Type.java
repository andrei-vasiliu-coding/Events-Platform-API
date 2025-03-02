package com.jveventsplatform.Java_Events_Platform.model;

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
}
