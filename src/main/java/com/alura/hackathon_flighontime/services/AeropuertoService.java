package com.alura.hackathon_flighontime.services;

import com.alura.hackathon_flighontime.models.Aeropuerto;
import com.alura.hackathon_flighontime.models.adapter.AdapterFile;
import com.alura.hackathon_flighontime.models.adapter.IAdapter;
import com.alura.hackathon_flighontime.repository.IAeropuertoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

@Service
public class AeropuertoService {

    @Autowired
    private IAeropuertoRepository repository;

    public void cargarAeropuertosSiNoExisten(IAdapter<Aeropuerto> adapter, String paht) throws Exception {
        if(repository.count() == 0) {
            InputStream inputStream = new FileInputStream(paht);
            AdapterFile<Aeropuerto> adapterFile = new AdapterFile<>(adapter);
            List<Aeropuerto> aeropuertoList = adapterFile.readFile(inputStream);
            repository.saveAll(aeropuertoList);
        } else {
            System.out.println("\nYa tiene elementos la tabla aeropuertos...\n");
        }
    }

    public boolean existsByIata(String iata) {
        return repository.existsByIata(iata);
    }

    public Aeropuerto findByIata(String iata) {
        return repository.findByIata(iata);
    }

}
