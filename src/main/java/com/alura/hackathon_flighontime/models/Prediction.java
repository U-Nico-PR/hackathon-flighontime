package com.alura.hackathon_flighontime.models;

import com.alura.hackathon_flighontime.models.enums.PrevisionVuelo;

import java.time.LocalDateTime;

public class Prediction {
    private PrevisionVuelo prevision;
    private Double probabilidad;
    private LocalDateTime fecha;
}
