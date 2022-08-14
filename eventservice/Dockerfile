FROM openjdk:17-oracle
COPY target/eventservice-*.jar eventservice.jar
ENV PROFILE=dev-integration
ENTRYPOINT java -jar -Dspring.profiles.active=${PROFILE} eventservice.jar