FROM eclipse-temurin:21-jre-alpine

ARG JAR_FILE=target/*.jar

COPY target/Spring-AOP-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]