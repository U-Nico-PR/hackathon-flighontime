package com.alura.hackathon_flighontime.services.consumo;

public interface IConvertirDatos {

    public <T> T jsonAObjeto(String json, Class<T> clase);

    <T> String objetoAString(T object);
}
