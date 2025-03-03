package com.jveventsplatform.Java_Events_Platform.service;

import com.jveventsplatform.Java_Events_Platform.model.Organiser;
import com.jveventsplatform.Java_Events_Platform.repository.OrganiserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrganiserServiceImpl implements OrganiserService {

    @Autowired
    OrganiserRepository organiserRepository;

    @Override
    public List<Organiser> getOrganiserByName(String name) {
        return organiserRepository.findByName(name);
    }

    @Override
    public List<Organiser> getOrganiserByEmail(String email) {
        return organiserRepository.findByEmail(email);
    }

    @Override
    public List<Organiser> getOrganiserByPhoneNumber(String phoneNumber) {
        return organiserRepository.findByPhoneNumber(phoneNumber);
    }
}
