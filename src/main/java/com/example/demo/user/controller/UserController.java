package com.example.demo.user.controller;

import com.example.demo.user.model.UserModel;

import com.example.demo.user.services.DeleteUserService;
import com.example.demo.user.services.DetailUserService;
import com.example.demo.user.services.ListUsersService;
import com.example.demo.user.services.RegisterUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    RegisterUserService registerUserService;
    ListUsersService listUsersService;
    DetailUserService detailUserService;
    DeleteUserService deleteUserService;

    @Autowired
    public UserController(
            RegisterUserService registerUserService,
            ListUsersService listUsersService,
            DetailUserService detailUserService,
            DeleteUserService deleteUserService
    ){
        this.registerUserService = registerUserService;
        this.listUsersService = listUsersService;
        this.detailUserService = detailUserService;
    }

    @GetMapping()
    List<UserModel> findAll(){
        return this.listUsersService.execute();
    }

    @GetMapping("/{id}")
    UserModel findById(@PathVariable long id){
        return this.detailUserService.execute(id);
    }

    @PostMapping
    void createUser(@Valid @RequestBody UserModel dto) {
        this.registerUserService.execute(dto);
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable long id) {
        this.detailUserService.execute(id);
    }
}
