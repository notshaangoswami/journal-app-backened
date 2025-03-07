# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

RUN chmod +x ./mvnw

# Package the application
RUN ./mvnw package -DskipTests

# Make port 8081 available to the world outside this container
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "target/journalApp-0.0.1-SNAPSHOT.jar"]