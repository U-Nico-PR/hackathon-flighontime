package com.alura.hackathon_flighontime.models.adapter;

import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public interface IAdapter<T> {
    List<T> readFile(InputStream inputStream);
}
