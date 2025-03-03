package com.jveventsplatform.Java_Events_Platform.repository;

import com.jveventsplatform.Java_Events_Platform.model.Organiser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganiserRepository extends CrudRepository<Organiser, Long> {
    List<Organiser> findByName(String name);
    List<Organiser> findByEmail(String email);
    List<Organiser> findByPhoneNumber(String phoneNumber);
}
