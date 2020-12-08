FROM maven:3.6.3-jdk-11 AS maven

WORKDIR maven

COPY demo/demo .

RUN mvn package -DskipTests


FROM openjdk:8

EXPOSE 8081

COPY --from=maven /maven/target/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]