# FlightOnTime
Predicción de Retrasos de Vuelos

## Descripción del proyecto
FlightOnTime es un proyecto de **Data Science con Back-End** cuyo objetivo es predecir si un vuelo será
**Puntula** o **Retrasado**, junto con la probabilidad asociada a dicha predicción.

La solución se base en un modelo de *Machine Learning* entrenado con datos históricos de vuelos y expuesto
a través de una **API REST** desarrollada en **Java con Spring Boot**, permitiendo la consulta de predicciones. 

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
- Entrenamiento de un modelo
- Evaluación del modelo
- Exportación del modelo entrenado a .pkl

### Back-End
- API REST desarrollada en Java con Spring Boot
- Endpoint `/predict` para realizar predicciones
- Integración con el modelo de Data Science
- Validación de entradas y respuestas en formato JSON
- Manejo de errores y respuestas HTTP

## Contrato de integración
Esta parte representa un acuerdo entre Back-End y Data Scient para exitosa transferencia de datos.
Tanto el **request** y **response** para la integración con el *Modelo Predictivo* es en el formato JSON.
 - **Variables de entrada al modelo**

| Nombre       | Tipo            | Ejemplo | Descripción                               | Observación                            | Preprocesamiento |
|--------------|-----------------|---------|-------------------------------------------|----------------------------------------|------------------|
| AIRLINE_CODE | Cadena de texto | `DL`    | Código IATA                               | Código disponible en `aerolineas.csv`  | No               |
| ORIGIN       | Cadena de texto | `ATL`   | Código IATA                               | Código disponible en `aeropuertos.csv` | No               |
| DEST         | Cadena de texto | `CLE`   | Código IATA                               | Código disponible en `aeropuertos.csv` | No               |
| DISTANCE     | Entero          | 750     | Distancia entre aeropuertos en millas     | Obtenida de la fórmula de Haversine    | Sí               |
| HORA_PARTIDA | Entero          | 17      | Formato 24 horas / Hora militar           | Obtenida de la petición                | Sí               |
| DIA_SEMANA   | Entero          | 5       | Día de la semana 0 -> Lunes, 6 -> Domingo | Obtenida de la petición                | Sí               |
| ES_HORA_PICO | Entero          | 1       | 1 si hora >= 15                           | Obtenida de la petición                | Sí               |

- **Variables de salida del modelo**

| Nombre       | Tipo   | Ejemplo | Descripción                  | Observación                    | Preprocesamiento |
|--------------|--------|---------|------------------------------|--------------------------------|------------------|
| resultado    | Entero | 1       | 0 -> Puntual, 1 -> Retrasado | Obtenido del modelo entrenado  | Sí               |
| probabilidad | Float  | 0.78    | Valor de probabilidad [0, 1] | Obtenido del modelo entrenado  | Sí               |

## Tecnologías utilizadas

### Data Science
| Categoría              | Herramientas / Lenguajes        |
|-------------------------|---------------------------------|
| Lenguaje               | Python                          |
| Análisis de datos      | Pandas, NumPy                   |
| Machine Learning       | Scikit-learn, XGBoost           |
| Visualización          | Matplotlib, Seaborn             |
| Desarrollo             | Jupyter Notebook                |
| Control de versiones   | Git, GitHub                     |


### Back-End
| Categoría                 | Herramientas / Dependencias |
|---------------------------|-----------------------------|
| Lenguaje de programación  | Java 21                     |
| Framework                 | Spring Boot                 |
| Gestor de dependencias    | Maven                       |
| Serialización JSON        | Jackson                     |
| Testing                   | No se utilizaron librerías  |
| Seguridad                 | No implementada             |
| Integración con DS        | Consumo de microservicio    |
| Persistencia              | JPA                         |
| Base de datos             | MySQL                       |
| Exportación de datos      | OpenCSV                     |
| Utilidades                | Lombok                      |

### Herramientas de desarrollo
| Categoría                  | Herramientas utilizadas         |
|-----------------------------|---------------------------------|
| Pruebas de API              | Postman                         |
| Control de versiones        | Git, GitHub                     |
| IDE / Editor                | IntelliJ IDEA                   |
| Documentación de API        | En desarrollo                   |
| Entorno de ejecución        | JDK 21, Spring Boot CLI         |
| Gestión de BD               | MySQL CLI (interfaz de comandos |
---
## Estructura del proyecto en Back-End
```
📦hackathon-flighontime                          # Proyecto
├──📂src
|  └──📂main
|     ├──📂java
|     ├──📦com.alura.hackathon_flighontime       # Paquete raíz
|     |  ├──⚙️config                             # Configuración general
|     |  ├──📂controllers                        # Endpoints REST
|     |  ├──📂dtos                               # Data Transfer Objects
|     |  ├──📂exceptions                         # Manejo de Excepciones
|     |  ├──📂models                             # Clases de dominio
|     |     ├──📂adapter                         # Lectura CSV y conversión
|     |     └──📂enums                           # Enumeraciones descriptivas
|     |  ├──📂repository                         # Interfaces JPA (acceso a datos)
|     |  └──📂services                           # Lógica de negocio
|     |     └──📂cosumo                          # Consumo de API externa (modelo DS)
|     └──📂resources
|        ├──📂files
|        |  ├──📄aerolineas.csv                  # Archivo CSV con las aerolineas
|        |  └──📄aeropuertos.csv                 # Archivo CSV con los aeropuertos
|        ├──📂static
|        ├──📂templates
|        └──⚙️application.properties             # Parámetros de configuración
├──⚙️pom.xml                                     # Gestor de dependencias
└──📄README.md                                   # Información general del proyecto
```


## Endpoint principal

### POST /predict

### Entrada (JSON)
```json
{
    "aerolinea": "AZ",
    "origen": "GIG",
    "destino": "GRU",
    "hora_partida": 4,
    "dia_semana": "14"
}
```
### Salida (JSON)
```json
{
  "prevision": "PUNTUAL",
  "probabilidad": 0.73
}
```
### Datos eviados al modelo
El campo **distance** y **es_hora_pico** se calculan internamente en el Vuelo.
Para **distance** se utiliza la fórmula de Haversine que es un método trigonométrico para calcular la distancia más
corta entre dos puntos en una esfera (como la Tierra) usando sus coordenadas de latitud y longitud.
Para **es_hora_pico** se hace una condición *hora_partida >= 15*, en caso verdadero se asigna 1, en caso contrario 0.
**Respetando el contrato de integración**.

### JSON
```json
{
  "airline_code": "AZ",
  "origin": "GIG",
  "dest": "GRU",
  "hora_partida": 4,
  "dia_semana": 14,
  "distance": 1000,
  "es_hora_pico": 0
}
```
### Salida (JSON)
```json
{
  "prevision": 1,
  "probabilidad": 0.73
}
```