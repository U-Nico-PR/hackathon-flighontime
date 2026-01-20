package com.alura.hackathon_flighontime.dtos;
import com.alura.hackathon_flighontime.models.enums.PrevisionVuelo;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.*;

// Data Transfer Object para la respuesta a la predicción.

public record FlightPredictionResponseDTO(

        // El modelo regresa una clave resultado. Se ajusto para almacenarla en prevision que es un Enum.
        @NotBlank
        @JsonAlias("resultado")
        PrevisionVuelo prevision,

        @DecimalMin(value = "0.0", inclusive = true)
        @DecimalMax(value = "1.0", inclusive = true)
        Double probabilidad
) {
}
