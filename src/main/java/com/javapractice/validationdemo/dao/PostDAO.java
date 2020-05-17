package com.javapractice.validationdemo.dao;

import java.util.UUID;

import com.javapractice.validationdemo.entities.Post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDAO extends JpaRepository<Post, UUID> {
    
}