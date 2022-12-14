FROM openjdk:19-alpine

WORKDIR /usr/app

#COPY . /app
#WORKDIR /app
#RUN ./mvnw package  -DskipTests

#RUN cp /app/target/*.war /usr/local/tomcat/webapps/ROOT.war
COPY ./target/SpringBoot-0.0.1-SNAPSHOT.jar /usr/app

EXPOSE 8080

CMD ["java", "-jar", "SpringBoot-0.0.1-SNAPSHOT.jar"]
#CMD ["catalina.sh", "run"]
