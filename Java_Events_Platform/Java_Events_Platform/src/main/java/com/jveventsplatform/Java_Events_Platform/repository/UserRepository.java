package com.jveventsplatform.Java_Events_Platform.repository;

import com.jveventsplatform.Java_Events_Platform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
