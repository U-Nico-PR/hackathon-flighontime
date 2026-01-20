package com.alura.hackathon_flighontime.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

// Data Transfer Object para la petición del usuario.

public record FlightPredictionRequestDTO(
        @NotBlank(message = "La aerolínea es obligatoria")
        @Size(min = 2, max = 3, message = "La aerolínea debe ser un código IATA válido")
        @JsonAlias("aerolinea")
        String airline_code,

        @NotBlank(message = "El aeropuerto de origen es obligatorio")
        @Size(min = 3, max = 3, message = "El origen debe ser un código IATA de 3 letras")
        @JsonAlias("origen")
        String origen,

        @NotBlank(message = "El aeropuerto de destino es obligatorio")
        @Size(min = 3, max = 3, message = "El destino debe ser un código IATA de 3 letras")
        @JsonAlias("destino")
        String dest,

        @Min(value = 0, message = "La hora de partida debe estar entre 0 y 23")
        @Max(value = 23, message = "La hora de partida debe estar entre 0 y 23")
        int hora_partida,

        @Min(value = 1, message = "Día de la semana mínimo 1 (Lunes)")
        @Max(value = 7, message = "Día de la semana mínimo 1 (Lunes)")
        int dia_semana

//        @NotNull(message = "La distancia es obligatoria")
//        @Min(value = 30, message = "La distancia mínima es 30 km")
//        @Max(value = 8000, message = "La distancia máxima es 8000 km")
//        Integer distancia_km
) {

}
