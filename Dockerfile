#
# Build stage
#
FROM gradle:7.4.0-jdk11-alpine AS build
COPY src /home/app/src
COPY build.gradle /home/app
WORKDIR /home/app
RUN gradle clean build jar --no-daemon

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/build/libs/weather-analysis-0.0.1-SNAPSHOT.jar /usr/local/lib/weather-analysis.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/weather-analysis.jar"]