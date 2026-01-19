package com.alura.hackathon_flighontime.services;

import com.alura.hackathon_flighontime.dtos.FlightPredictionResponseDTO;
import com.alura.hackathon_flighontime.models.Vuelo;
import com.alura.hackathon_flighontime.services.aux.ConsumoAPI;
import com.alura.hackathon_flighontime.services.aux.ConvertirDatos;
import com.alura.hackathon_flighontime.services.aux.IConvertirDatos;
import org.springframework.stereotype.Service;

@Service
public class ModeloService {

    private static final String FASTAPI_URL = "http://127.0.0.1:8000/predict";

    public static FlightPredictionResponseDTO enviarRequest(Vuelo vuelo) {
        IConvertirDatos conversion = new ConvertirDatos();
        String json = conversion.objetoAString(vuelo);
        String response = ConsumoAPI.getPrediction(FASTAPI_URL, json);
        return conversion.jsonAObjeto(response, FlightPredictionResponseDTO.class);
    }
}
