package com.alura.hackathon_flighontime.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("FlightOnTime")
                        .version("1.0.0")
                        .description("FlightOnTime es un proyecto de Data Science con Back-End cuyo objetivo es predecir si un vuelo será Puntula o Retrasado, " +
                        "junto con la probabilidad asociada a dicha predicción.\n" +
                        "\n" +
                        "La solución se base en un modelo de Machine Learning entrenado con datos históricos de vuelos y expuesto a través de una API REST " +
                        "desarrollada en Java con Spring Boot, permitiendo la consulta de predicciones.")
                );
    }


}
