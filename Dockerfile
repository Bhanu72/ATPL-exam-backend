# Stage 1: Build stage
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package

# Stage 2: Final stage
FROM openjdk:17-oracle
WORKDIR /app
COPY --from=build /app/target/aero-0.0.1-SNAPSHOT.jar /app/aero-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "aero-0.0.1-SNAPSHOT.jar"]

