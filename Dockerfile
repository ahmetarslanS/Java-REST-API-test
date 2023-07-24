#Stage 1 Paketlemek için JAVA JAR
FROM openjdk:11-jdk as builder

WORKDIR /MessengerApp

ENV JAVA_HOME="C:\Program Files\Java"

COPY .mvn .mvn
COPY mvnw pom.xml ./
RUN powershell -Command "$ErrorActionPreference = 'Stop'; $ProgressPreference = 'SilentlyContinue'; C:\Program Files (x86)\MessengerApp\MessengerApp\mvnw.cmd dependency:go-offline"


COPY src src
RUN ./mvnw package -DskipTests

#Stage 2 Çalıştırmak için  OpenJDK JRE
FROM openjdk:11-jre-slim

WORKDIR /app

COPY --from=builder /app/target/MessengerApp-*.jar /app/messenger-app.jar

#Uygulamayı çalıştır
CMD ["java", "-jar", "messenger-app.jar"]
