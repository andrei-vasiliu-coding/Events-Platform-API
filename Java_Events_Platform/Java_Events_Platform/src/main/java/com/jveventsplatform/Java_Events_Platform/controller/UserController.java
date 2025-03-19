package com.jveventsplatform.Java_Events_Platform.controller;

import com.jveventsplatform.Java_Events_Platform.model.Event;
import com.jveventsplatform.Java_Events_Platform.model.EventRegistrationId;
import com.jveventsplatform.Java_Events_Platform.model.User;
import com.jveventsplatform.Java_Events_Platform.service.EventService;
import com.jveventsplatform.Java_Events_Platform.service.LocationService;
import com.jveventsplatform.Java_Events_Platform.service.OrganiserService;
import com.jveventsplatform.Java_Events_Platform.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "User", description = "APIs for managing users within the platform")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users")
    public ResponseEntity<User> postUsers() {
        User user = new User();
        User createdUser = userService.insertUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

}
