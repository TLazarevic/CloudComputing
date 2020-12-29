FROM maven:3.6.3-jdk-11-slim AS maven

WORKDIR maven

COPY demo/demo .

RUN mvn package -DskipTests


FROM adoptopenjdk/openjdk11:jdk-11.0.9_11.1-alpine-slim

EXPOSE 8081

COPY --from=maven /maven/target/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]