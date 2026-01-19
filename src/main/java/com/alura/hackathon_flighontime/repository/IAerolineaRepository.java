package com.alura.hackathon_flighontime.repository;

import com.alura.hackathon_flighontime.models.Aerolinea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAerolineaRepository extends JpaRepository<Aerolinea, Long> {
}
