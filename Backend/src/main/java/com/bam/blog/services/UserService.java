package com.bam.blog.services;

import java.util.UUID;

import com.bam.blog.domain.entities.User;

public interface UserService {

    User getUserById(UUID userId);
    
}
