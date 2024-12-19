FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/watchMovie-0.0.1.war /app/watchMovie-0.0.1.war

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/watchMovie-0.0.1.war"]