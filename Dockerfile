FROM ubuntu:latest as build

RUN apt-get update
RUN apt-get install open-jdk-17 -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:17-jdk-slim

EXPOSE 8090

COPY --from=build /target/helpdesk-back-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]


