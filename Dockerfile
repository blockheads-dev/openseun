FROM openjdk:17-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} suenswap-v1.jar
ENTRYPOINT ["java","-jar","/seunswap-v1.jar"]