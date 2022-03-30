FROM maven:3.6.3-openjdk-14-slim AS build
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY . .
RUN mvn package -DskipTests

FROM openjdk:12-alpine as runnable
VOLUME /tmp
VOLUME /logs

ARG JAR_FOLDER=/build/target

COPY --from=build ${JAR_FOLDER}/Visit-App.jar Visit-App.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/Visit-App"]




