package com.eviro.assessment.grad001.kennymafuna.service;

import com.eviro.assessment.grad001.kennymafuna.entity.UserEntity;
import com.eviro.assessment.grad001.kennymafuna.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity getUserById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }


}
