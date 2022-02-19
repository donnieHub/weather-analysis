#
# Build stage
#
FROM gradle:7.4.0-jdk11-alpine AS build
COPY src /home/app/src
COPY build.gradle /home/app
RUN mvn -f /home/app/pom.xml clean package
RUN gradle --project-dir /home/app/build.gradle clean build jar


#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/weather-analysis-0.0.1-SNAPSHOT.jar /usr/local/lib/weather-analysis.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/demo.weather-analysis"]