package com.rei.hue.service;

import java.util.List;

import javax.transaction.Transactional;

import com.rei.hue.entity.User;
import com.rei.hue.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional(rollbackOn = Exception.class)
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> searchAll() {
        return userRepository.findAll();
    }
}
