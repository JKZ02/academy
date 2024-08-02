FROM maven:3.8.6 as build1
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY . .
RUN mvn clean package -Dmaven.test.skip
RUN mvn dependency:go-offline

FROM amazoncorretto:17.0.10-alpine3.19
WORKDIR /deployments

COPY --from=build1 /app/target/quarkus-app/lib lib/
COPY --from=build1 /app/target/quarkus-app/app app/
COPY --from=build1 /app/target/quarkus-app/quarkus quarkus/

COPY --from=build1 /app/target/quarkus-app/*.jar .

CMD ["java","-jar","/deployments/quarkus-run.jar"]
