package com.jveventsplatform.Java_Events_Platform.service;

import com.jveventsplatform.Java_Events_Platform.model.Organiser;

import java.util.List;

public interface OrganiserService {
    List<Organiser> getOrganiserByName(String name);
    List<Organiser> getOrganiserByEmail(String email);
    List<Organiser> getOrganiserByPhoneNumber(String phoneNumber);
}
