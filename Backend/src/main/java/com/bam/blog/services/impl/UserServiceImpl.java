package com.bam.blog.services.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.bam.blog.domain.entities.User;
import com.bam.blog.repository.UserRepository;
import com.bam.blog.services.UserService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUserById(UUID userId) {

        return userRepository.findById(userId).orElseThrow(
                () -> new EntityNotFoundException("USer not found with Id " + userId));
    }

}
