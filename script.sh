./mvnw clean install
docker rm -f $(docker ps -aq)
docker rmi -f $(docker images -aq)
yes Y | docker volume prune
docker-compose up