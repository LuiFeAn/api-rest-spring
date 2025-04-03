package com.example.demo.user.services;

import com.example.demo.shared.errors.ConflictError;
import com.example.demo.user.model.UserModel;
import com.example.demo.user.repositories.UserRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterUserService {

    UserRepository userRepository;

    public RegisterUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(UserModel dto){

        Optional<UserModel> emailAlreadyExists = userRepository.findByEmail(dto.getEmail());

        if(emailAlreadyExists.isPresent()){
            throw new ConflictError("Email already exists");
        }

        UserModel user = new UserModel(dto.getUsername(),dto.getEmail(),dto.getPassword());

        user.hashPassword();

        this.userRepository.save(user);
    }

}
