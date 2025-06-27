FROM maven:3.9.6-eclipse-temurin-17-alpine AS builder

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY --from=builder /app/target/notification-service-v1.jar app.jar

EXPOSE 6800

ENTRYPOINT ["java", "-jar", "app.jar"]

# use this to build the project on Mac
# docker build --platform=linux/amd64 -t notification-service-app .

# to run the image use this
# docker run -p 6800:6800 notification-service-app

