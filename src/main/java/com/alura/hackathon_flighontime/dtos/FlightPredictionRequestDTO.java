package com.alura.hackathon_flighontime.dtos;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record FlightPredictionRequestDTO(
        @NotBlank(message = "La aerolínea es obligatoria")
        @Size(min = 2, max = 3, message = "La aerolínea debe ser un código IATA válido")
        String aerolinea,

        @NotBlank(message = "El aeropuerto de origen es obligatorio")
        @Size(min = 3, max = 3, message = "El origen debe ser un código IATA de 3 letras")
        String origen,

        @NotBlank(message = "El aeropuerto de destino es obligatorio")
        @Size(min = 3, max = 3, message = "El destino debe ser un código IATA de 3 letras")
        String destino,

        @NotNull(message = "La fecha de partida es obligatoria")
        LocalDateTime fecha_partida,

        @NotNull(message = "La distancia es obligatoria")
        @Min(value = 30, message = "La distancia mínima es 30 km")
        @Max(value = 8000, message = "La distancia máxima es 8000 km")
        Integer distancia_km
) {

}
