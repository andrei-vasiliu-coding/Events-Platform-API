package com.jveventsplatform.Java_Events_Platform.repository;

import com.jveventsplatform.Java_Events_Platform.model.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {
}
