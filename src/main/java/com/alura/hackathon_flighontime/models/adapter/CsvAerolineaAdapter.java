package com.alura.hackathon_flighontime.models.adapter;

import com.alura.hackathon_flighontime.models.Aerolinea;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class CsvAerolineaAdapter implements IAdapter<Aerolinea> {
    @Override
    public List<Aerolinea> readFile(InputStream inputStream) {
        Reader reader = new InputStreamReader(inputStream);
        ColumnPositionMappingStrategy<Aerolinea> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Aerolinea.class);
        strategy.setColumnMapping("nombre", "iata");

        CsvToBean<Aerolinea> csvToBean = new CsvToBeanBuilder<Aerolinea>(reader)
                .withMappingStrategy(strategy)
                .withType(Aerolinea.class)
                .withSeparator(',')
                .withSkipLines(1)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        List<Aerolinea> aerolineas = csvToBean.parse();
        aerolineas.forEach(a -> a.setIata(a.getIata().trim()));
        return aerolineas;
    }
}
