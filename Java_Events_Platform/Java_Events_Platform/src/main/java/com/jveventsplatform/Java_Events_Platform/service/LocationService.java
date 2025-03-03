package com.jveventsplatform.Java_Events_Platform.service;

import com.jveventsplatform.Java_Events_Platform.model.Location;

import java.util.List;

public interface LocationService {
    List<Location> getLocationsByName(String name);
    List<Location> getLocationsByCity(String city);
    List<Location> getLocationsByPostcode(String postcode);
}
