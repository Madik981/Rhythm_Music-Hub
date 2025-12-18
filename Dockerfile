FROM eclipse-temurin:21-jdk
LABEL maintainer="madik"
COPY target/Rhythm_Music-Hub-0.0.1-SNAPSHOT.jar my-backend-rhythm-spring.jar
ENTRYPOINT ["java", "-jar", "my-backend-rhythm-spring.jar"]