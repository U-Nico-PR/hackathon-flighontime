package com.alura.hackathon_flighontime.models.adapter;

import com.alura.hackathon_flighontime.models.Aeropuerto;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class CsvAeropuertoAdapter implements IAdapter<Aeropuerto>{
    @Override
    public List<Aeropuerto> readFile(InputStream inputStream) {
        Reader reader = new InputStreamReader(inputStream);
        ColumnPositionMappingStrategy<Aeropuerto> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Aeropuerto.class);
        // Los atributos de la clase deben de estar ordenados como el archivo csv.
        strategy.setColumnMapping("latitud", "longitud", "iata", "nombre");

        CsvToBean<Aeropuerto> csvToBean = new CsvToBeanBuilder<Aeropuerto>(reader)
                .withMappingStrategy(strategy)
                .withType(Aeropuerto.class)
                .withSeparator(',')
                .withSkipLines(1)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        return csvToBean.parse();
    }
}
