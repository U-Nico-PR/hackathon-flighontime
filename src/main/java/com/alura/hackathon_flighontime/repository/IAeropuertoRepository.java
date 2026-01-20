package com.alura.hackathon_flighontime.repository;

import com.alura.hackathon_flighontime.models.Aeropuerto;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAeropuertoRepository extends JpaRepository<Aeropuerto, Long> {

    boolean existsByIata(@NotBlank String iata);

    Aeropuerto findByIata(@NotBlank String iata);

}
