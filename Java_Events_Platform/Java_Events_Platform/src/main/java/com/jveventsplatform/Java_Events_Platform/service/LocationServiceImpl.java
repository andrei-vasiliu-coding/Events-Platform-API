package com.jveventsplatform.Java_Events_Platform.service;

import com.jveventsplatform.Java_Events_Platform.exception.ItemNotFoundException;
import com.jveventsplatform.Java_Events_Platform.model.Location;
import com.jveventsplatform.Java_Events_Platform.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    LocationRepository locationRepository;

    @Override
    @Transactional(readOnly = true)
    public Location getLocationById(Long id) {
        return locationRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Location with ID " + id + " not found"));
    }

    @Override
    public List<Location> getLocationsByName(String name) {
        return locationRepository.findByName(name);
    }

    @Override
    public List<Location> getLocationsByCity(String city) {
        return locationRepository.findByCity(city);
    }

    @Override
    public List<Location> getLocationsByPostcode(String postcode) {
        return locationRepository.findByPostcode(postcode);
    }
}
