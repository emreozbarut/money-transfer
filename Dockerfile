FROM maven:3.8.5-jdk-11 AS maven

WORKDIR /build

ADD . .

RUN mvn clean package -Dmaven.test.skip=true

FROM openjdk:11

WORKDIR /app

COPY --from=maven /build/target/money-transfer-service*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]