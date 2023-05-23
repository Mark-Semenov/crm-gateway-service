FROM gradle:latest as builder
WORKDIR /app
COPY src ./src
COPY build.gradle ./
COPY settings.gradle ./
RUN gradle clean build


FROM eclipse-temurin:latest
RUN mkdir /app
WORKDIR app
COPY --from=builder /app/build/libs/*.jar /app/gateway-service.jar
CMD  ["java", "-jar",  "gateway-service.jar"]

