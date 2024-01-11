package com.eviro.assessment.grad001.kennymafuna.repository;

import com.eviro.assessment.grad001.kennymafuna.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByName(String name);
}
