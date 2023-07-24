FROM openjdk:17 as builder

ADD ../doublev-partners-api-rest/target/doublev-partners-api-rest-0.0.1-SNAPSHOT.jar doublev-partners-api-rest-0.0.1-SNAPSHOT.jar

EXPOSE 9520

ENTRYPOINT ["java","-jar", "doublev-partners-api-rest-0.0.1-SNAPSHOT.jar"]

#ubicarse en el directorio raiz -> doublev-partners-selection
#mvn clean install
#docker build -t dp-api-rest . -f .\doublev-partners-api-rest\Dockerfile
#docker run -p 9520:9520 -d --rm --name container-dp-api-rest --network doublev dp-api-rest