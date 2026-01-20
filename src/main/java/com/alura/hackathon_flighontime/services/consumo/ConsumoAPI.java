package com.alura.hackathon_flighontime.services.consumo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

// Clase que permite consumir cualquier servicio por medio de una url y su petición.

public class ConsumoAPI {

    public static String getPrediction(String url, String request) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest reques = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(request, StandardCharsets.UTF_8))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(reques, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response.body();
    }
}
