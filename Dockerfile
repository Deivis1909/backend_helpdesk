FROM maven:3.9.2-amazoncorretto-17 as build
WORKDIR /app
COPY . .
RUN mvn clean package -X -DskipTests

FROM openjdk:17-alpine
WORKDIR /app
COPY --from=build ./app/target/*.jar ./testes_basicos.jar
ENTRYPOINT java -jar testes_basicos.jar