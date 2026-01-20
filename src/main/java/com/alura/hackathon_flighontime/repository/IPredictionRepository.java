package com.alura.hackathon_flighontime.repository;

import com.alura.hackathon_flighontime.models.Prediction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPredictionRepository extends JpaRepository<Prediction, Long> {
}
