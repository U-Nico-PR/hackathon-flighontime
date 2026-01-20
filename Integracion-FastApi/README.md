# ✈️ Sobre código de integración.
Esta carpeta contiene el códdigo necesario para levantar un **microservicio** que permite consumir un modelo de
*Machine Learnign* entrenado en Python.

El modelo, que se indica, está serializado en formato `.pkl` y debe estar ubicado dentro de la carpeta `app`.

---
## ⚙️Instalación y ejecución
1. Crear entorno virtual (opcional):
```bash
python -m venv venv
source venv/bin/activate    # Linux/Mac
venv\Scripts\activate       # Windows
```

2. Instalar Librerías (dentro del entorno)

 - Librerias necesarias para ejecutar el modelo.
```bash
`pip install xgboost imbalanced-learn fastapi uvicorn pandas scikit-learn==1.6.1 joblib`
```
- O en caso de que exista un archivo `requirements.txt` que contiene las librerías necesarias:
```bash
pip install -r requirements.txt
```

3. Levantar el Servidor
```bash
uvicorn app.main:app --reload
```