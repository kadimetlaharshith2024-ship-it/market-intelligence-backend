import yfinance as yf
import json

indices = [
    {"country": "India", "indexName": "NIFTY 50", "symbol": "^NSEI"},
    {"country": "India", "indexName": "SENSEX", "symbol": "^BSESN"},
    {"country": "USA", "indexName": "S&P 500", "symbol": "^GSPC"},
    {"country": "USA", "indexName": "NASDAQ Composite", "symbol": "^IXIC"},
    {"country": "USA", "indexName": "Dow Jones", "symbol": "^DJI"},
    {"country": "Japan", "indexName": "Nikkei 225", "symbol": "^N225"},
    {"country": "UK", "indexName": "FTSE 100", "symbol": "^FTSE"},
    {"country": "Germany", "indexName": "DAX", "symbol": "^GDAXI"},
    {"country": "France", "indexName": "CAC 40", "symbol": "^FCHI"},
    {"country": "Hong Kong", "indexName": "Hang Seng", "symbol": "^HSI"},
    {"country": "Canada", "indexName": "S&P/TSX", "symbol": "^GSPTSE"},
    {"country": "China", "indexName": "Shanghai Composite", "symbol": "000001.SS"}
]

result = []

for item in indices:
    try:

        ticker = yf.Ticker(item["symbol"])

        history = ticker.history(
            period="5d",
            auto_adjust=True
        )

        if history.empty:
            continue

        closes = history["Close"].dropna()

        if len(closes) == 0:
            continue

        price = float(closes.iloc[-1])

        change_percent = 0

        if len(closes) >= 2:

            previous = float(closes.iloc[-2])

            if previous != 0:
                change_percent = (
                    (price - previous) / previous
                ) * 100

        result.append({
            "country": item["country"],
            "indexName": item["indexName"],
            "symbol": item["symbol"],
            "price": round(price, 2),
            "changePercent": round(change_percent, 2)
        })

    except Exception as e:
        print(f"Error fetching {item['symbol']}: {e}", flush=True)

print(json.dumps(result))