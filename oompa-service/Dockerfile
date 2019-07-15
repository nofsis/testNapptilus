FROM openjdk:8-nanoserver

LABEL maintainer="nofsis00@gmail.com"

COPY target/get-full-oompa-service-0.0.1-SNAPSHOT.jar /demo.jar
EXPOSE 8080

CMD ["java", "-jar", "demo.jar"]