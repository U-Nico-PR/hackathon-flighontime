package com.alura.hackathon_flighontime.dtos;
import com.alura.hackathon_flighontime.models.enums.PrevisionVuelo;
import com.fasterxml.jackson.annotation.JsonAlias;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

// Data Transfer Object para la respuesta a la predicción.

@Schema(description = " Datos de Respuesta de predicción de vuelo")
public record FlightPredictionResponseDTO(

        // El modelo regresa una clave resultado. Se ajusto para almacenarla en prevision que es un Enum.
        @NotBlank
        @JsonAlias("resultado")
        @Schema(description = "Clave resultado (PUNTUAL/RETRASADO)", example = "PUNTUAL")
        PrevisionVuelo prevision,

        @DecimalMin(value = "0.0", inclusive = true)
        @DecimalMax(value = "1.0", inclusive = true)
        @Schema(description = "Valor decimal de probabilidad [0, 1]", example = "0.78")
        Double probabilidad
) {
}
