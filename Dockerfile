FROM amazoncorretto:17

COPY /build/libs/jpop-karaoke-server-1.0.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]