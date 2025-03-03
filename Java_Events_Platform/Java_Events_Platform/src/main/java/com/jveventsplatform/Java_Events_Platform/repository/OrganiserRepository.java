package com.jveventsplatform.Java_Events_Platform.repository;

import com.jveventsplatform.Java_Events_Platform.model.Organiser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrganiserRepository extends CrudRepository<Organiser, Long> {
    List<Organiser> findByName(String name);
    List<Organiser> findByEmail(String email);
    List<Organiser> findByPhoneNumber(String phoneNumber);
}
