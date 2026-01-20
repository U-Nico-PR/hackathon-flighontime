package com.alura.hackathon_flighontime.services.consumo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

// Esta clase permite convertir Objetos, pensados para formato JSON, en tipo String.
// También de String a un Objeto en particular que se quiera manejar como JSON.

public class ConvertirDatos implements IConvertirDatos {

    private static ObjectMapper mapper = new ObjectMapper();

    // Esta carga estatica sirve para manejar la conversión de fechas.
    static { // Registrar soporte para Java 8 Date/Time API
        mapper.registerModule(new JavaTimeModule());
        // Evitar que se serialice como timestamp (números)
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @Override
    public <T> T jsonAObjeto(String json, Class<T> clase) {
        try {
            return mapper.readValue(json, clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> String objetoAString(T object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
