FROM amazoncorretto:21
WORKDIR /usr/src/myapp
COPY target/*.jar app.jar
ENTRYPOINT [ "java", "-jar", "app.jar" ]