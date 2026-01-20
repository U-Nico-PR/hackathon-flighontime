package com.alura.hackathon_flighontime.repository;

import com.alura.hackathon_flighontime.models.Aerolinea;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAerolineaRepository extends JpaRepository<Aerolinea, Long> {

    boolean existsByIata(@NotBlank String iata);

    Aerolinea findByIata(@NotBlank String iata);

}
