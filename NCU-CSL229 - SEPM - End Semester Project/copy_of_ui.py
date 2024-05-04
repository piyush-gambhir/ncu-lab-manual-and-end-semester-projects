
import numpy as np
import pandas as pd
from sklearn.preprocessing import MinMaxScaler
from keras.models import model_from_json
import gradio as gr


def predict_prices(start_date, n_days):
    # Load model architecture from JSON file
    with open("model.json", "r") as json_file:
        loaded_model_json = json_file.read()
    # Load the model
    model = model_from_json(loaded_model_json)
    # Load model weights
    model.load_weights("model.h5")

    # Load your preprocessed data
    df = pd.read_csv('/content/BTC-USD.csv')
    df['Date'] = pd.to_datetime(df['Date'])
    df.dropna(inplace=True)
    df['Volume'] = pd.to_numeric(df['Volume'], errors='coerce')
    # Assuming you've already defined look_back
    look_back = 15
    # Preprocess the start date
    start_date = pd.to_datetime(start_date)
    # Find the index corresponding to the provided start date
    start_index = df[df['Date'] == start_date].index.tolist()[0]
    # Extract the relevant portion of the data for prediction
    data = df['Close'].values[start_index-look_back:start_index].reshape(-1, 1)
    # Scale the data
    min_max_scaler = MinMaxScaler(feature_range=(0, 1))
    scaled_data = min_max_scaler.fit_transform(data)
    # Prepare input sequences for prediction
    x_input = scaled_data.reshape(1, -1)
    temp_input = list(x_input[0])
    lst_output = []
    n = n_days  # next number of days for which we are predicting
    i = 0
    predicted_prices = []
    while (i < n):
        if (len(temp_input) > look_back):
            x_input = np.array(temp_input[1:])
            x_input = x_input.reshape(1, -1)
            x_input = x_input.reshape((1, look_back, 1))
            yhat = model.predict(x_input, verbose=0)
            temp_input.extend(yhat[0].tolist())
            temp_input = temp_input[1:]
            lst_output.extend(yhat.tolist())
            predicted_price = min_max_scaler.inverse_transform(
                np.array(yhat).reshape(-1, 1))[0][0]
            predicted_prices.append(
                f"Predicted price for Day {i+1} is {predicted_price:.2f}")
            i += 1
        else:
            x_input = x_input.reshape((1, look_back, 1))
            yhat = model.predict(x_input, verbose=0)
            temp_input.extend(yhat[0].tolist())
            lst_output.extend(yhat.tolist())
            predicted_price = min_max_scaler.inverse_transform(
                np.array(yhat).reshape(-1, 1))[0][0]
            predicted_prices.append(
                f"Predicted price for Day {i+1} is {predicted_price:.2f}")
            i += 1
    return predicted_prices


date_input = gr.Textbox(label="Enter Starting date")
days_input = gr.Number(label="Enter the number of days")
output = gr.Textbox(label="Predicted prices")

# Create Gradio interface
interface = gr.Interface(
    fn=predict_prices,
    inputs=[date_input, days_input],
    outputs=output,
    title="Bitcoin Price Prediction",
    description="Enter the starting date and the number of days to predict Bitcoin prices."
)

# Launch the Gradio interface
interface.launch(debug=True)
