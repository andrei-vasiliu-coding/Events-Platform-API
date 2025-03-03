package com.jveventsplatform.Java_Events_Platform.service;

import com.jveventsplatform.Java_Events_Platform.model.Location;
import com.jveventsplatform.Java_Events_Platform.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    LocationRepository locationRepository;

    @Override
    public List<Location> findByName(String name) {
        return List.of();
    }

    @Override
    public List<Location> findByCity(String city) {
        return List.of();
    }

    @Override
    public List<Location> findByPostcode(String postcode) {
        return List.of();
    }
}
