#
# Build stage
#
FROM gradle:7.4.0-jdk11-alpine AS build
COPY src /home/app/src
COPY build/libs /home/app/libs
COPY build.gradle /home/app
RUN gradle --project-dir /home/app clean build jar

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/libs/weather-analysis-0.0.1-SNAPSHOT.jar /usr/local/lib/weather-analysis.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/weather-analysis.jar"]