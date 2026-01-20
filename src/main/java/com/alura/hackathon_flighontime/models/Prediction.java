package com.alura.hackathon_flighontime.models;

import com.alura.hackathon_flighontime.models.enums.PrevisionVuelo;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "predictions")
@Data
public class Prediction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PrevisionVuelo prevision;

    private double probabilidad;

    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "vuelo_id")
    private Vuelo vuelo;
}
