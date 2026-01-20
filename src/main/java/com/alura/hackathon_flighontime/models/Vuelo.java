package com.alura.hackathon_flighontime.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "vuelos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_aerolinea")
    private Aerolinea aerolinea;

    @ManyToOne
    @JoinColumn(name = "id_origen")
    private Aeropuerto origen;

    @ManyToOne
    @JoinColumn(name = "id_destino")
    private Aeropuerto destino;

    private int hora_partida;
    private int dia_semana;
    private int distancia;
    private int es_hora_pico;

    @OneToMany(mappedBy = "vuelo", cascade = CascadeType.ALL)
    private List<Prediction> predictiones;

    public Vuelo(Aerolinea aerolinea, Aeropuerto origen, Aeropuerto destino, int hora, int dia) {
        this.aerolinea = aerolinea;
        this.origen = origen;
        this.destino = destino;
        this.hora_partida = hora;
        this.dia_semana = dia;
        this.es_hora_pico = hora >= 15 ? 1 : 0;
        this.distancia = calcularDistancia();
        System.out.println(distancia);
    }

    // Método que calcula la distancia entre Aeropuerto de origen y destino con la fórmula de Haversine
    private int calcularDistancia() {
        // Radio de la Tierra
        double radioTierra = 6371.0;

        double latOrigen = Math.toRadians(origen.getLatitud());
        double lonOrigen = Math.toRadians(origen.getLongitud());
        double latDestino = Math.toRadians(destino.getLatitud());
        double lonDestino = Math.toRadians(destino.getLongitud());

        double dLat = latDestino - latOrigen;
        double dLon = lonDestino - lonOrigen;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(latOrigen) * Math.cos(latDestino)
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return kmAMillas(Math.round(radioTierra * c));
    }

    // Método para pasar de Km a Millas
    private int kmAMillas(double km) {
        // 1 Kilometro = 0.621371 millas
        return (int) (km * 0.621371);
    }
}
