package com.alura.hackathon_flighontime.dtos;

import com.alura.hackathon_flighontime.models.Vuelo;

public record DatosVuelo(
        String airline_code,
        String origin,
        String dest,
        int hora_partida,
        int dia_semana,
        int distance,
        int es_hora_pico
) {
    public DatosVuelo(Vuelo vuelo) {
        this(
                vuelo.getAerolinea().getIata(),
                vuelo.getOrigen().getIata(),
                vuelo.getDestino().getIata(),
                vuelo.getHora_partida(),
                vuelo.getDia_semana(),
                vuelo.getDistancia(),
                vuelo.getEs_hora_pico()
        );
    }
}
