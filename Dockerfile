# Use OpenJDK 17 base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the built JAR file from target
COPY target/*.jar app.jar

# Expose application port (Render will set $PORT)
EXPOSE 8080

# Run Spring Boot app
CMD ["java", "-jar", "app.jar"]
