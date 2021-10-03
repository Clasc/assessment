FROM openjdk:11
FROM maven:3.8.2-openjdk-11
WORKDIR /app
COPY . /app
RUN mvn -v
RUN mvn clean install -DskipTests
ENTRYPOINT ["java","-jar","target/query.service-0.0.1-SNAPSHOT.jar"]