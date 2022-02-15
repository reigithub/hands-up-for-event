package com.rei.hue.repository;

import com.rei.hue.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}