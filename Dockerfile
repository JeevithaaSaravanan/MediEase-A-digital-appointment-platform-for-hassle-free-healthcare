# ── Stage 1: build ───────────────────────────────────────────
FROM maven:3.9.7-eclipse-temurin-21 AS builder
WORKDIR /workspace
COPY pom.xml .
COPY src ./src
RUN mvn -B package -DskipTests

# ── Stage 2: runtime ─────────────────────────────────────────
FROM eclipse-temurin:21-jre-jammy
ENV TZ=Asia/Kolkata
WORKDIR /app
COPY --from=builder /workspace/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
