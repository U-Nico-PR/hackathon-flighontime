package com.alura.hackathon_flighontime.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GestorDeErrores {

    @ExceptionHandler(ValidarException.class)
    public ResponseEntity errorValidacion(ValidarException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
