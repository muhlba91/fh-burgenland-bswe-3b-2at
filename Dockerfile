# Use an OpenJDK 21 base image
FROM adoptopenjdk/openjdk11:alpine-jre

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled JAR file into the container at /app
COPY build/libs/*.jar /app/application.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the application when the container starts
CMD ["java", "-jar", "application.jar"]
