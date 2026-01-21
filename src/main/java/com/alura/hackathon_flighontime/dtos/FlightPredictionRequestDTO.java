package com.alura.hackathon_flighontime.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

// Data Transfer Object para la petición del usuario.

@Schema(description = " Datos de Solicitud de predicción de vuelo")
public record FlightPredictionRequestDTO(
        @NotBlank(message = "La aerolínea es obligatoria")
        @Size(min = 2, max = 3, message = "La aerolínea debe ser un código IATA válido")
        @JsonAlias("aerolinea")
        @Schema(description = "Código IATA de la Aerolinea", example = "DL")
        String aerolinea,

        @NotBlank(message = "El aeropuerto de origen es obligatorio")
        @Size(min = 3, max = 3, message = "El origen debe ser un código IATA de 3 letras")
        @JsonAlias("origen")
        @Schema(description = "Código IATA del Aeropuerto de Origen", example = "ATL")
        String origen,

        @NotBlank(message = "El aeropuerto de destino es obligatorio")
        @Size(min = 3, max = 3, message = "El destino debe ser un código IATA de 3 letras")
        @JsonAlias("destino")
        @Schema(description = "Código IATA del Aeropuerto de Destino", example = "CLE")
        String destino,

        @Min(value = 0, message = "La hora de partida debe estar entre 0 y 23")
        @Max(value = 23, message = "La hora de partida debe estar entre 0 y 23")
        @Schema(description = "Número Entero (Formato 24 horas / Hora militar)", example = "4")
        int hora_partida,

        @Min(value = 0, message = "Día de la semana mínimo 0 (Lunes)")
        @Max(value = 6, message = "Día de la semana máximo 6 (Domingo)")
        @Schema(description = "Número Entero (Día de la semana 0 -> Lunes, 6 -> Domingo)", example = "5")
        int dia_semana
) {

}
