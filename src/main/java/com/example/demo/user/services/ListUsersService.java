package com.example.demo.user.services;

import com.example.demo.user.model.UserModel;
import com.example.demo.user.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListUsersService {

    UserRepository userRepository;

    ListUsersService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UserModel> execute() {
        return this.userRepository.findAll();
    }

}
