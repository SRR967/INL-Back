# Use the official Gradle image to create a build artifact.
FROM gradle:8.2-jdk17 AS build

# Copy local code to the container image.
WORKDIR /app
COPY build.gradle .
COPY src ./src

# Build a release artifact.
RUN gradle clean build -x test

# Use OpenJDK for runtime
FROM openjdk:17-jdk-slim

# Copy the jar to the production image from the builder stage.
COPY --from=build /app/build/libs/*.jar /app.jar

# Run the web service on container startup.
CMD ["java", "-jar", "/app.jar"]

# Expose the port
EXPOSE 8080