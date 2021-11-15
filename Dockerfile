FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} conway-service.jar
ENTRYPOINT ["java","-jar","-Ddb.url=${DBURL}","/conway-service.jar"]