FROM openjdk:17-oracle
COPY target/eventservice-*.jar eventservice.jar
ARG PROFILE=prod
ENTRYPOINT java -jar -Dspring.profiles.active=${PROFILE} eventservice.jar