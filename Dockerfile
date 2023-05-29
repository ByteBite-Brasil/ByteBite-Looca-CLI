FROM openjdk:17
COPY loginByteBiteCLI-1.0-SNAPSHOT-jar-with-dependencies.jar /app/
WORKDIR /app/
ENTRYPOINT  ["java", "-jar", "loginByteBiteCLI-1.0-SNAPSHOT-jar-with-dependencies.jar"]
EXPOSE 8080



