package com.example.demo.user.repositories;

import com.example.demo.user.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel,Long> {
    Optional<UserModel> findByEmail(String email);
}
