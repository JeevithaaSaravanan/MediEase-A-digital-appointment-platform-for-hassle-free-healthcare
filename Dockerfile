FROM maven:3.9.6-eclipse-temurin-17-alpine

WORKDIR /app

COPY . .

EXPOSE 8082

CMD ["mvn", "spring-boot:run"]
