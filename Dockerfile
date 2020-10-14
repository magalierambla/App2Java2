FROM openjdk:8-jdk-alpine
WORKDIR /
COPY ./target/Api-crowdlending-1.0.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
