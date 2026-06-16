import yfinance as yf

indices = {
    "India": "^NSEI",
    "USA (S&P500)": "^GSPC",
    "USA (NASDAQ)": "^IXIC",
    "Japan": "^N225",
    "UK": "^FTSE",
    "Germany": "^GDAXI",
    "France": "^FCHI",
    "Hong Kong": "^HSI",
    "Canada": "^GSPTSE",
    "China": "000001.SS"
}

for country, symbol in indices.items():
    try:
        ticker = yf.Ticker(symbol)
        price = ticker.history(period="1d")["Close"].iloc[-1]
        print(f"{country}: {price}")
    except Exception as e:
        print(f"{country}: Error -> {e}")