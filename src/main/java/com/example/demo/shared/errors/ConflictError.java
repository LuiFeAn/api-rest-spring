package com.example.demo.shared.errors;

public class ConflictError extends RuntimeException{
    public ConflictError(String message) {
        super(message);
    }
}
