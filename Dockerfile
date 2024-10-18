FROM openjdk:17-jdk-alpine

COPY target/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/demo-0.0.1-SNAPSHOT.jar"]

# Expose port cho ứng dụng (mặc định là 8080)
EXPOSE 8080