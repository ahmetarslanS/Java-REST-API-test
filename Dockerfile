# Use an official OpenJDK runtime as the base image
FROM adoptopenjdk:11-jre-hotspot

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file and pom.xml to the working directory
COPY target/*.jar /app/app.jar
COPY pom.xml /app/pom.xml

# Expose the port that your Spring Boot application listens on
EXPOSE 8080

# Run the Java application when the container starts
CMD ["java", "-jar", "app.jar"]
