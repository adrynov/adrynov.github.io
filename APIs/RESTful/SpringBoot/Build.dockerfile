FROM maven:3-eclipse-temurin-19

WORKDIR /usr/src
COPY . /usr/src

RUN mvn clean package

WORKDIR /usr/src/app
RUN cp /usr/src/target/*.jar ./app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]