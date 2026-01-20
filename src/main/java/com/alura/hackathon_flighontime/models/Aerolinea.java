package com.alura.hackathon_flighontime.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "aerolineas")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aerolinea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String iata;

}
