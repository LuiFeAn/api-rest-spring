package com.example.demo.user.services;

import com.example.demo.shared.errors.NotFoundError;
import com.example.demo.user.model.UserModel;
import com.example.demo.user.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DetailUserService {

    UserRepository userRepository;

    public DetailUserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserModel execute(long id){
        Optional<UserModel> user = userRepository.findById(id);

        if(user.isEmpty()){
            throw new NotFoundError("User not found");
        }

       return user.get();
    }

}
