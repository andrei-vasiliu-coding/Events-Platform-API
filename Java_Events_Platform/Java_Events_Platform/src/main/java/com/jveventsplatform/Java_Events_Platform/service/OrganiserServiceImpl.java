package com.jveventsplatform.Java_Events_Platform.service;

import com.jveventsplatform.Java_Events_Platform.exception.ItemNotFoundException;
import com.jveventsplatform.Java_Events_Platform.model.Organiser;
import com.jveventsplatform.Java_Events_Platform.repository.OrganiserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrganiserServiceImpl implements OrganiserService {

    @Autowired
    OrganiserRepository organiserRepository;

    @Override
    @Transactional(readOnly = true)
    public Organiser getOrganiserById(Long id) {
        return organiserRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Organiser with ID " + id + " not found"));
    }

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
