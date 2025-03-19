package com.jveventsplatform.Java_Events_Platform.service;

import com.jveventsplatform.Java_Events_Platform.model.User;
import com.jveventsplatform.Java_Events_Platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User insertUser(User user) {
        return userRepository.save(user);
    }
}
