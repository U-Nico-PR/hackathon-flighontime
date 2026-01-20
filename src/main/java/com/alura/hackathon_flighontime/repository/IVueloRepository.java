package com.alura.hackathon_flighontime.repository;

import com.alura.hackathon_flighontime.models.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVueloRepository extends JpaRepository<Vuelo, Long> {
}
