package com.alura.hackathon_flighontime.controllers;

import com.alura.hackathon_flighontime.dtos.FlightPredictionRequestDTO;
import com.alura.hackathon_flighontime.dtos.FlightPredictionResponseDTO;
import com.alura.hackathon_flighontime.models.Vuelo;
import com.alura.hackathon_flighontime.services.ModeloService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

// Clase controladora para las peticiones del usuario.

@RestController
public class PredictionController {

    @PostMapping("/predict")
    public ResponseEntity prueba(@RequestBody @Valid FlightPredictionRequestDTO requestDTO) {
        Vuelo vuelo = new Vuelo(requestDTO);
        vuelo.setDistancia(1112);

        // var uri = uriComponentsBuilder.path("/predict").toUri();
        FlightPredictionResponseDTO responseDTO = ModeloService.enviarRequest(vuelo);

        return ResponseEntity.ok(responseDTO);
    }
}
