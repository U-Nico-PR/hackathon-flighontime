package com.alura.hackathon_flighontime.services;

import com.alura.hackathon_flighontime.dtos.DatosVuelo;
import com.alura.hackathon_flighontime.dtos.FlightPredictionRequestDTO;
import com.alura.hackathon_flighontime.dtos.FlightPredictionResponseDTO;
import com.alura.hackathon_flighontime.exceptions.ValidarException;
import com.alura.hackathon_flighontime.models.Aerolinea;
import com.alura.hackathon_flighontime.models.Aeropuerto;
import com.alura.hackathon_flighontime.models.Vuelo;
import com.alura.hackathon_flighontime.services.consumo.ConsumoAPI;
import com.alura.hackathon_flighontime.services.consumo.ConvertirDatos;
import com.alura.hackathon_flighontime.services.consumo.IConvertirDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModeloService {

    private static final String FASTAPI_URL = "http://127.0.0.1:8000/predict";

    @Autowired
    private AeropuertoService aeropuertoService;

    @Autowired
    private AerolineaService aerolineaService;

    @Autowired
    private VueloService vueloService;

    @Autowired
    private PredictionService predictionService;

    public FlightPredictionResponseDTO enviarRequest(FlightPredictionRequestDTO requestDTO) {

        String iata_aerolinea = requestDTO.aerolinea();
        String iata_origen = requestDTO.origen();
        String iata_destino = requestDTO.destino();

        if(iata_origen.equalsIgnoreCase(iata_destino)){
            throw new ValidarException("Origen y Destino deben ser diferentes.");
        }

        // Se verifica que este en base de datos la aerolinea y el aeropuerto de origen y destino.
        boolean existeAerolinea = aerolineaService.existByIata(iata_aerolinea);
        boolean existeOrigen = aeropuertoService.existsByIata(iata_origen);
        boolean existeDestino = aeropuertoService.existsByIata(iata_destino);

        if (!existeAerolinea) {
            throw new ValidarException("La Aerolinea no está registrada.");
        }
        if (!existeDestino) {
            throw new ValidarException("El Aeropuerto de Destino no está registrado.");
        }
        if (!existeOrigen) {
            throw new ValidarException("El Aeropuerto de Origen no está registrado.");
        }

        // Se extraen la Aerolinea y Aeropuerto de origen y destino, de la base de datos
        Aerolinea aerolinea = aerolineaService.fineByIata(iata_aerolinea);
        Aeropuerto aeropuerto_origen = aeropuertoService.findByIata(iata_origen);
        Aeropuerto aeropuerto_destino = aeropuertoService.findByIata(iata_destino);

        // Se hace el objeto vuelo pasandole objetos y datos
        Vuelo vuelo = new Vuelo(
                aerolinea,
                aeropuerto_origen,
                aeropuerto_destino,
                requestDTO.hora_partida(),
                requestDTO.dia_semana()
        );

        // Se pasa el objeto vuelo para la request en el servicio.
        DatosVuelo vueloRequest = new DatosVuelo(vuelo);

        // Convertir los datos a un json de tipo string.
        IConvertirDatos conversion = new ConvertirDatos();
        String json = conversion.objetoAString(vueloRequest);
        String response = ConsumoAPI.getPrediction(FASTAPI_URL, json);

        return conversion.jsonAObjeto(response, FlightPredictionResponseDTO.class);
    }
}
