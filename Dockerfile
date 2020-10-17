FROM maven:3.6.3-jdk-8
WORKDIR /
COPY . .
RUN mvn clean install -DskipTests
RUN ls -l ./target
RUN cp ./target/Api-crowdlending-1.0.0.jar .
RUN ls -l
ENTRYPOINT ["java","-jar","./Api-crowdlending-1.0.0.jar"]
