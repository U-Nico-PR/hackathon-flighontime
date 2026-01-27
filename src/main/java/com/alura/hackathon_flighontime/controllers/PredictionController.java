package com.alura.hackathon_flighontime.controllers;

import com.alura.hackathon_flighontime.dtos.FlightPredictionRequestDTO;
import com.alura.hackathon_flighontime.dtos.FlightPredictionResponseDTO;
import com.alura.hackathon_flighontime.services.ModeloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

   @Operation(
            summary = "Genera la predicción de un vuelo",
            description = "Retorna información predictiva basada en los datos del vuelo"
   )
   @ApiResponses({

           // ---------- 200 OK ----------
           @ApiResponse(
                   responseCode = "200",
                   description = "Predicción generada correctamente",
                   content = @Content(
                           mediaType = "application/json",
                           examples = @ExampleObject(
                                   name = "Vuelo retrasado",
                                   value = """
                {
                  "prevision": "Puntual",
                  "probabilidad": 0.73
                }
                """
                           )
                   )
           ),

           // ---------- 400 - Validación de negocio (String) ----------
           @ApiResponse(
                   responseCode = "400",
                   description = "Datos inválidos (reglas de negocio)",
                   content = @Content(
                           mediaType = "text/plain",
                           examples = @ExampleObject(
                                   name = "Error de negocio",
                                   value = "La aerolínea no está soportada"
                           )
                   )
           ),

           // ---------- 400 - Bean Validation (array de errores) ----------
           @ApiResponse(
                   responseCode = "400",
                   description = "Errores de validación de campos",
                   content = @Content(
                           mediaType = "application/json",
                           examples = @ExampleObject(
                                   name = "Errores de validación",
                                   value = """
                [
                  {
                    "campo": "fecha_partida",
                    "mensaje": "no puede ser nula"
                  },
                  {
                    "campo": "distancia_km",
                    "mensaje": "debe ser mayor que 0"
                  }
                ]
                """
                           )
                   )
           ),

           // ---------- 404 ----------
           @ApiResponse(
                   responseCode = "404",
                   description = "Recurso no encontrado"
           ),

           // ---------- 500 ----------
           @ApiResponse(
                   responseCode = "500",
                   description = "Error interno del servidor",
                   content = @Content(
                           mediaType = "text/plain",
                           examples = @ExampleObject(
                                   name = "Error interno",
                                   value = "Error: No se pudo cargar el modelo predictivo"
                           )
                   )
           )
   })
    @PostMapping("/predict")
    public ResponseEntity prueba(@RequestBody @Valid FlightPredictionRequestDTO requestDTO) {
        FlightPredictionResponseDTO responseDTO = modeloService.enviarRequest(requestDTO);
        return ResponseEntity.ok(responseDTO);
    }
}
