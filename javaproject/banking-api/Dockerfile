FROM jelastic/maven:3.9.16-zulujdk-21.0.11-almalinux-9 AS build
WORKDIR /
COPY src src
COPY pom.xml pom.xml
RUN mvn clean install -Dmaven.test.skip=true

FROM azul/zulu-openjdk:21
#LABEL "com.boa.customerapidocker"="customer-api"
LABEL version=1.0-SNAPSHOT
COPY --from=build target/banking-app-0.0.1-SNAPSHOT.jar banking-app-0.0.1-SNAPSHOT.jar
EXPOSE 8080
#ENTRYPOINT ["java","-jar","customerapi-0.0.1-SNAPSHOT.jar"]
ENTRYPOINT java -Dspring.profiles.active=dev -jar banking-app-0.0.1-SNAPSHOT.jar