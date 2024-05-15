FROM amazoncorretto:21
WORKDIR /usr/src/myapp
COPY target/user-profile-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT [ "java", "-jar", "app.jar" ]