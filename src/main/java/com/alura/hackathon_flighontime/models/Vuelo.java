package com.alura.hackathon_flighontime.models;

import com.alura.hackathon_flighontime.dtos.FlightPredictionRequestDTO;
import lombok.Getter;

@Getter
public class Vuelo {
//    private Aerolinea airline_code;
//    private Aeropuerto origin;
//    private Aeropuerto dest;
    private String airline_code;
    private String origin;
    private String dest;
    private int hora_partida;
    private int dia_semana;
    private int distance;
    private int es_hora_pico;

    public Vuelo(FlightPredictionRequestDTO requestDTO) {
        this.airline_code = requestDTO.airline_code();
        this.origin = requestDTO.origen();
        this.dest = requestDTO.dest();
        this.hora_partida = requestDTO.hora_partida();
        this.dia_semana = requestDTO.dia_semana();
        this.es_hora_pico = hora_partida >= 15 ? 1 : 0;
    }

    public void setDistancia(int distancia) {
        this.distance = distancia;
    }
}
