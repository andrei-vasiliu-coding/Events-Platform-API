package com.jveventsplatform.Java_Events_Platform.service;

import com.jveventsplatform.Java_Events_Platform.model.Location;

import java.util.List;

public interface LocationService {
    Location getLocationById(Long id);
    List<Location> getLocationsByName(String name);
    List<Location> getLocationsByCity(String city);
    List<Location> getLocationsByPostcode(String postcode);
}
