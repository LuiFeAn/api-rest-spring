package com.example.demo.user.services;

import com.example.demo.user.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserService {

    UserRepository userRepository;

    public DeleteUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(Long id){
        this.userRepository.deleteById(id);
    }

}
