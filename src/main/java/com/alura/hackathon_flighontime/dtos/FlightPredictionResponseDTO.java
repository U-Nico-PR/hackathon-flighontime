package com.alura.hackathon_flighontime.dtos;
import com.alura.hackathon_flighontime.models.enums.PrevisionVuelo;
import jakarta.validation.constraints.*;

public record FlightPredictionResponseDTO(

        @NotBlank
        PrevisionVuelo prevision,

        @DecimalMin(value = "0.0", inclusive = true)
        @DecimalMax(value = "1.0", inclusive = true)
        Double probabilidad
) {
}
