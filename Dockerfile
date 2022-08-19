FROM openjdk:17-jdk-alpine
COPY build/libs/declaration-event-service-0.0.1.jar myApp.jar
ENTRYPOINT ["java","-jar","/myApp.jar"]
