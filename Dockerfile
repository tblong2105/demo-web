FROM openjdk:17-jdk-alpine

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} something-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/something-SNAPSHOT.jar"]

# Expose port cho ứng dụng (mặc định là 8080)
EXPOSE 8080