FROM openjdk:8-jdk-alpine
COPY dbdoc-server/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
CMD [""]
