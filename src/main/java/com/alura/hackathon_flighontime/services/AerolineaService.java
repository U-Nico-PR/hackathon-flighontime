package com.alura.hackathon_flighontime.services;

import com.alura.hackathon_flighontime.models.Aerolinea;
import com.alura.hackathon_flighontime.models.adapter.AdapterFile;
import com.alura.hackathon_flighontime.models.adapter.IAdapter;
import com.alura.hackathon_flighontime.repository.IAerolineaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

@Service
public class AerolineaService {

    @Autowired
    private IAerolineaRepository repository;

    public void cargarAerolineasSiNoExisten(IAdapter<Aerolinea> adapter, String paht) throws Exception {
        if(repository.count() == 0) {
            InputStream inputStream = new FileInputStream(paht);
            AdapterFile<Aerolinea> adapterFile = new AdapterFile<>(adapter);
            List<Aerolinea> aerolineaList = adapterFile.readFile(inputStream);
            repository.saveAll(aerolineaList);
        } else {
            System.out.println("\nYa tiene elementos la tabla aerolineas...\n");
        }
    }

    public boolean existByIata(String iata) {
        return repository.existsByIata(iata);
    }

    public Aerolinea fineByIata(String iata) {
        return repository.findByIata(iata);
    }

}
