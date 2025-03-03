package com.jveventsplatform.Java_Events_Platform.service;

import com.jveventsplatform.Java_Events_Platform.model.Location;

import java.util.List;

public interface LocationService {
    List<Location> findByName(String name);
    List<Location> findByCity(String city);
    List<Location> findByPostcode(String postcode);
}
