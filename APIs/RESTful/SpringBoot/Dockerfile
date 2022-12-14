#FROM openjdk:19-alpine
FROM eclipse-temurin:19-jdk-focal

WORKDIR /app

#COPY .mvn/ ./mvn
#COPY mvnw pom.xml ./

# resolves all project dependencies including plugins and reports and their dependencies
RUN #./mvnw dependency:go-offline

#COPY . /app
#WORKDIR /app
#RUN ./mvnw package  -DskipTests

#RUN cp /app/target/*.war /usr/local/tomcat/webapps/ROOT.war
COPY ./target/SpringBoot-0.0.1-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "SpringBoot-0.0.1-SNAPSHOT.jar"]
#CMD ["catalina.sh", "run"]
