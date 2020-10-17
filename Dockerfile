FROM maven:3.6.3-jdk-8
WORKDIR /
COPY . .
RUN mvn clean install -DskipTests
RUN ls -l
COPY ./target/Api-crowdlending-1.0.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
