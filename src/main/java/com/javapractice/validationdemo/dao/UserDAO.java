package com.javapractice.validationdemo.dao;

import java.util.UUID;

import com.javapractice.validationdemo.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, UUID>{
    
}