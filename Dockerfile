FROM openjdk:17-oracle

WORKDIR /app

COPY target/aero-0.0.1-SNAPSHOT.jar /app/aero-0.0.1-SNAPSHOT.jar

COPY src/main/resources/application.properties /app/application.properties

COPY src/main/resources/data.db /app/data.db

EXPOSE 8080

CMD ["java", "-jar", "aero-0.0.1-SNAPSHOT.jar"]
