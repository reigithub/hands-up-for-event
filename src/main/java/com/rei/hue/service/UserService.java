package com.rei.hue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rei.hue.model.User;
import com.rei.hue.repository.UserRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
