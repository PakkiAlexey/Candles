FROM maven:3.8.3-openjdk-17 as builder

WORKDIR /workdir
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src


RUN mvn package -DskipTests


FROM openjdk:17.0-jdk-slim

COPY --from=builder /workdir/target/*.jar /app.jar


CMD ["java" , "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
