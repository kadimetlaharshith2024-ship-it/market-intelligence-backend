import pandas as pd
import numpy as np
from sklearn.ensemble import RandomForestClassifier
import joblib

np.random.seed(42)

rows = []

for _ in range(500):

    temperature = np.random.randint(20, 40)
    humidity = np.random.randint(30, 100)
    pressure = np.random.randint(990, 1025)
    wind_speed = np.random.randint(0, 20)
    cloud_cover = np.random.randint(0, 100)
    visibility = np.random.randint(1000, 10000)
    month = np.random.randint(1, 13)

    rain = 0

    if (
        humidity > 75
        and cloud_cover > 60
        and pressure < 1008
    ):
        rain = 1

    if month in [6, 7, 8, 9]:
        if humidity > 65:
            rain = 1

    rows.append([
        temperature,
        humidity,
        pressure,
        wind_speed,
        cloud_cover,
        visibility,
        month,
        rain
    ])

df = pd.DataFrame(
    rows,
    columns=[
        "temperature",
        "humidity",
        "pressure",
        "wind_speed",
        "cloud_cover",
        "visibility",
        "month",
        "rain"
    ]
)

X = df[
    [
        "temperature",
        "humidity",
        "pressure",
        "wind_speed",
        "cloud_cover",
        "visibility",
        "month"
    ]
]

y = df["rain"]

model = RandomForestClassifier(
    n_estimators=100,
    random_state=42
)

model.fit(X, y)

joblib.dump(
    model,
    "scripts/rainfall_model.pkl"
)

print("Model trained successfully")