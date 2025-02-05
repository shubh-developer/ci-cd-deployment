FROM openjdk:21
WORKDIR /app
COPY ./target/starter.restapi.jar /app
EXPOSE 8080
CMD["java", "jar", "starter.restapi.jar"]