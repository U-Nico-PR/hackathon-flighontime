package com.alura.hackathon_flighontime.models.adapter;

import java.io.InputStream;
import java.util.List;

// Clase que permite leer archivos de cualquier tipo.

public class AdapterFile<T> {

    private IAdapter<T> adapter;

    public AdapterFile(IAdapter<T> adapter) {
        this.adapter = adapter;
    }

    public List<T> readFile(InputStream inputStream) {
        return this.adapter.readFile(inputStream);
    }
}
