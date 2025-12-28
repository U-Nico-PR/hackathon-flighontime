# FlightOnTime
Predicción de Retrasos de Vuelos

## Descripción del proyecto
FlightOnTime es un proyecto de **Data Science con Back-End** cuyo objetivo es predecir si un vuelo será
**Puntula** o **Retrasado**, junto con la probabilidad asociada a dicha predicción.

La solución se base en un modelo de *Machine Learning* entrenado con datos históricos de vuelos y expuesto
a través de una **API REST**, permitiendo la consulta. 

Este proyecto es desarrollado como un **MVP (Producto Mínimo Viable)** en el contexto de un
hackathon educativo.

---

## Sector de negocio
- Aviación Civil
- Logística
- Transporte Aéreo

Los principales beneficiarios del sistema son **aerolíneas, aeropuesrtos y pasajeros**,
quienes dependen de la puntualidad de los vuelos.

---

## Problema a resolver
Los retrasos de vuelos generan:
- Insatisfacción en los pasajeros
- Costos adicionales para las aerolíneas
- Problemas operativos y de logística en aeropuertos

FlightOnTime busca anticipar estos retrasos para permitir una mejor planificación y
toma de decisiones.

---

## Objetivo del MVP
Desarrollar un servicio que:
- Reciba información básica de un vuelo
- Devuelva si el vuelo probablemente será **Puntual** o **Retrasado**
- Indique la **probabilidad** asociada a la predicción

Clasificación binaria:
- `0` -> Puntual
- `1` -> Retrasado

---

## Arquitectura general
El proyecto está compuesto por dos partes principales:

### Data Science
- Análisis exploratorio de datos (EDA)
- Limpieza y preparación de datos
- Creación de variables (*feature engineering*)
- Entrenamiento de un modelo de clasificación
- Evaluación del modelo
- Exportación del modelo entrenado

### Back-End
- API REST desarrollada en Java con Spring Boot
- Endpoint `/predict` para realizar predicciones
- Integración con el modelo de Data Science
- Validación de entradas y respuestas en formato JSON

## Tecnologías utilizadas

### Data Science
- Python
- pandas

### Back-End
- Java
- Spring Boot
- API REST

### Otras herramientas
- Postman

## Dataset
- Datos históricos de vuelos
- Variables utilizadas:
    - Aerolinea
    - Aeropuerto de origen y destino
    - Fecha y hora de vuelo
    - Día de la semana
    - Distancia de vuelo

---

## Endpoint principal

### POST /predict

### Entrada (JSON)
```json
{
    "aerolinea": "AZ",
    "origen": "GIG",
    "destino": "GRU",
    "fecha_partida": "2025-11-10T14:30:00",
    "dia": "14"
    "distancia_km": 350
}
