package com.alura.hackathon_flighontime.services;

import com.alura.hackathon_flighontime.repository.IVueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VueloService {

    @Autowired
    private IVueloRepository repository;

}
