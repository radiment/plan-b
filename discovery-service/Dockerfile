FROM openjdk:8u131-jdk-alpine
COPY build/libs/*.jar /usr/local/app/discovery-service.jar
ENTRYPOINT ["java", "-jar", "/usr/local/app/discovery-service.jar"]
