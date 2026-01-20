package com.alura.hackathon_flighontime.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.*;

// Data Transfer Object para la petición del usuario.

public record FlightPredictionRequestDTO(
        @NotBlank(message = "La aerolínea es obligatoria")
        @Size(min = 2, max = 3, message = "La aerolínea debe ser un código IATA válido")
        @JsonAlias("aerolinea")
        String aerolinea,

        @NotBlank(message = "El aeropuerto de origen es obligatorio")
        @Size(min = 3, max = 3, message = "El origen debe ser un código IATA de 3 letras")
        @JsonAlias("origen")
        String origen,

        @NotBlank(message = "El aeropuerto de destino es obligatorio")
        @Size(min = 3, max = 3, message = "El destino debe ser un código IATA de 3 letras")
        @JsonAlias("destino")
        String destino,

        @Min(value = 0, message = "La hora de partida debe estar entre 0 y 23")
        @Max(value = 23, message = "La hora de partida debe estar entre 0 y 23")
        int hora_partida,

        @Min(value = 0, message = "Día de la semana mínimo 0 (Lunes)")
        @Max(value = 6, message = "Día de la semana máximo 6 (Domingo)")
        int dia_semana
) {

}
