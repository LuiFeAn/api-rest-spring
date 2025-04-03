package com.example.demo.shared.exceptions;

import com.example.demo.shared.errors.ApiErrorResponse;
import com.example.demo.shared.errors.ConflictError;
import com.example.demo.shared.errors.NotFoundError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalValidationException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        List<String> errors = new ArrayList<>() {
        };
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String errorMessage = error.getDefaultMessage();
            errors.add(errorMessage);
        });
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(400,"Erro de Validação",errors);
        return ResponseEntity.badRequest().body(apiErrorResponse);
    }

    @ExceptionHandler(ConflictError.class)
    public ResponseEntity<ApiErrorResponse> handleConflictError(ConflictError e) {
        List<String> errors = new ArrayList<>();
        errors.add(e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiErrorResponse(409,"Recurso já registrado",errors));
    }

    @ExceptionHandler(NotFoundError.class)
    public ResponseEntity<ApiErrorResponse> handleNotFoundError(NotFoundError e) {
        List<String> errors = new ArrayList<>();
        errors.add(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiErrorResponse(404,"Entidade não encontrada",errors));
    }

}
