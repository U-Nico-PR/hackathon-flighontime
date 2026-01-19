package com.alura.hackathon_flighontime.repository;

import com.alura.hackathon_flighontime.models.Aeropuerto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAeropuertoRepository extends JpaRepository<Aeropuerto, Long> {

}
