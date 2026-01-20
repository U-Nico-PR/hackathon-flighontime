package com.alura.hackathon_flighontime.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "aeropuertos")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aeropuerto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String iata;

    private double latitud;

    private double longitud;
}
