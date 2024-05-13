FROM openjdk:11-jre-slim
WORKDIR /app
COPY ./application/target/application-0.0.1-SNAPSHOT.jar /app/application.jar
EXPOSE 8080
CMD ["java", "-jar", "application.jar"]
