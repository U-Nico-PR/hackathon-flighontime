package com.alura.hackathon_flighontime.exceptions;

// Clase que permite manejar errores en tiempo de ejecución para excepciones personalizadas.

public class ValidarException extends RuntimeException {
    public ValidarException(String mensaje) {
        super(mensaje);
    }
}
