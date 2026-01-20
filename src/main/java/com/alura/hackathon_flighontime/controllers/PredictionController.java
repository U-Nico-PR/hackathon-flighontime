package com.alura.hackathon_flighontime.controllers;

import com.alura.hackathon_flighontime.dtos.FlightPredictionRequestDTO;
import com.alura.hackathon_flighontime.dtos.FlightPredictionResponseDTO;
import com.alura.hackathon_flighontime.services.ModeloService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// Clase controladora para las peticiones del usuario.

@RestController
public class PredictionController {

    @Autowired
    private ModeloService modeloService;

    @PostMapping("/predict")
    public ResponseEntity prueba(@RequestBody @Valid FlightPredictionRequestDTO requestDTO) {
        FlightPredictionResponseDTO responseDTO = modeloService.enviarRequest(requestDTO);
        return ResponseEntity.ok(responseDTO);
    }
}
