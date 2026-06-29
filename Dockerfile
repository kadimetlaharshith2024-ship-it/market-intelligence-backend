FROM eclipse-temurin:21-jdk

WORKDIR /app

# Install Python
RUN apt-get update && \
    apt-get install -y python3 python3-pip && \
    ln -s /usr/bin/python3 /usr/bin/python && \
    apt-get clean

COPY . .

# Install Python libraries
RUN pip3 install --break-system-packages pandas joblib scikit-learn yfinance

RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

EXPOSE 8082

CMD ["java", "-jar", "target/market-intelligence-0.0.1-SNAPSHOT.jar"]