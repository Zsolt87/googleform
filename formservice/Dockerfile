FROM openjdk:17-oracle
COPY target/formservice-*.jar formservice.jar
ENV PROFILE=dev-integration
ENTRYPOINT java -jar -Dspring.profiles.active=${PROFILE} formservice.jar