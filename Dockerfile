FROM eclipse-temurin:17-jdk-alpine
LABEL authors="https-Luan-Fernandes"
WORKDIR /app
COPY target/family-cash-card-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]