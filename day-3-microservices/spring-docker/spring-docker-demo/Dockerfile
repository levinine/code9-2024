FROM amazoncorretto:21
WORKDIR src/app
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]