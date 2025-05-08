FROM eclipse-temurin:21
WORKDIR /app
COPY target/uniconnect_backend.jar uniconnect_backend.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "uniconnect_backend.jar"]
