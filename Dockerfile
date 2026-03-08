# build stage
FROM gradle:8-jdk17 AS builder
WORKDIR /app

COPY . .

RUN gradle build -x test

# runtime stage
FROM amazoncorretto:17
WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]