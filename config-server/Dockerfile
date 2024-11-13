FROM openjdk:21-jdk
COPY ./target/*.jar app.jar
EXPOSE 8088
ENTRYPOINT ["java","-jar","/app.jar"]
