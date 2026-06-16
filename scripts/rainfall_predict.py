import sys
import pandas as pd
import joblib

model = joblib.load(
    "scripts/rainfall_model.pkl"
)

temperature = float(sys.argv[1])
humidity = float(sys.argv[2])
pressure = float(sys.argv[3])
wind_speed = float(sys.argv[4])
cloud_cover = float(sys.argv[5])
visibility = float(sys.argv[6])
month = int(sys.argv[7])

input_data = pd.DataFrame({
    "temperature": [temperature],
    "humidity": [humidity],
    "pressure": [pressure],
    "wind_speed": [wind_speed],
    "cloud_cover": [cloud_cover],
    "visibility": [visibility],
    "month": [month]
})

prediction = model.predict(input_data)

if prediction[0] == 1:
    print("Rain Expected")
else:
    print("No Rain Expected")