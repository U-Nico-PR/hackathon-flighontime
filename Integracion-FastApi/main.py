import joblib
import pandas as pd

from fastapi import FastAPI
from pydantic import BaseModel

# Cargar el modelo app ya que esta dentro de la carpeta app por motivos de ejecución.
modelo = joblib.load('app/modelo_flightontime_xgboost_final.pkl')

# Definir la aplicación FastAPI
app = FastAPI()

# Esquema de entrada
class FlightData(BaseModel):
    airline_code: str
    origin: str
    dest: str
    distance: int
    hora_partida: int
    dia_semana: int
    es_hora_pico: int

@app.post("/predict")
def predict(data: FlightData):
    try:
        # Convertir la entrada a DataFram
        df = pd.DataFrame([{
            "AIRLINE_CODE": data.airline_code,
            "ORIGIN": data.origin,
            "DEST": data.dest,
            "DISTANCE": data.distance,
            "HORA_PARTIDA": data.hora_partida,
            "DIA_SEMANA": data.dia_semana,
            "ES_HORA_PICO": data.es_hora_pico
        }])
        # Pasar por el modelo
        resultado = modelo.predict(df)[0]
        arrayProbabilidad = modelo.predict_proba(df)[0]
        prob = float(f"{arrayProbabilidad[0]:.2f}")
        
        # Retorna tipo entero y float en respuesta al modelo
        return {"resultado": int(resultado), "probabilidad": prob}
    except Exception as e:
        return {"error": str(e)}
