package com.rei.hue.service;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rei.hue.dto.UserRequest;
import com.rei.hue.dto.UserUpdateRequest;
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

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    /**
     * ユーザー情報 登録
     * @param user ユーザー情報
     */
    public void create(UserRequest userRequest) {
        Date now = new Date();
        User user = new User();
        user.setName(userRequest.getName());
        user.setAddress(userRequest.getAddress());
        user.setPhone(userRequest.getPhone());
        user.setCreate_date(now);
        user.setUpdate_date(now);
        userRepository.save(user);
    }

    /**
     * ユーザー情報 更新
     * @param user ユーザー情報
     */
    public void update(UserUpdateRequest userUpdateRequest) {
        User user = findById(userUpdateRequest.getId());
        user.setAddress(userUpdateRequest.getAddress());
        user.setName(userUpdateRequest.getName());
        user.setPhone(userUpdateRequest.getPhone());
        user.setUpdate_date(new Date());
        userRepository.save(user);
    }    
}
