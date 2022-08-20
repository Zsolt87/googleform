FROM openjdk:17-oracle
COPY target/formservice-*.jar formservice.jar
ARG PROFILE=prod
ENTRYPOINT java -jar -Dspring.profiles.active=${PROFILE} formservice.jar