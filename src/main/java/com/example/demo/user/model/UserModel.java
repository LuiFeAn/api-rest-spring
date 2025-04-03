package com.example.demo.user.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Entity(name = "usuario")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(unique = false, nullable = false, name = "username")
    @NotEmpty(message = "O nome não pode estar vazio")
    @Size(min = 10, max = 255, message = "O nome deve possuir no mínimo 15 caracteres e no máximo 255")
    private String username;

    @Column(unique = true, nullable = false, name = "email")
    @NotEmpty(message = "Email não pode estar vazio")
    @Email(message = "Email inválido")
    private String email;

    @Column(name = "password")
    @NotEmpty(message = "Senha não pode estar vazia")
    @Size(min = 5, max = 8, message = "A senha deve possuir no mínimo 5 caracteres e no máximo 8")
    private String password;

    public UserModel() {}

    public UserModel(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public void hashPassword(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.password = encoder.encode(this.password);
    }

    public long getId() {
        return id;
    }

    public String getUsername(){
        return username;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

