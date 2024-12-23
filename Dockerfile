# Step 1: Use a base image with Java
FROM openjdk:17-jdk-slim as build

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the JAR file into the container
COPY target/Find-iT-0.0.1-SNAPSHOT.jar /app/myapp.jar

# Step 4: Expose the port that your Spring Boot app will run on
EXPOSE 8080

# Step 5: Specify the command to run the JAR file
ENTRYPOINT ["java", "-jar", "/app/myapp.jar"]
