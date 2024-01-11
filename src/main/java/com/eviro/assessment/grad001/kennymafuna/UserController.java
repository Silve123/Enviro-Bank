package com.eviro.assessment.grad001.kennymafuna;

import com.eviro.assessment.grad001.kennymafuna.entity.UserEntity;
import com.eviro.assessment.grad001.kennymafuna.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{userName}")
    public ResponseEntity<UserEntity> findByName(@PathVariable String userName) {
        UserEntity user = userRepository.findByName(userName);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user);
    }
}
