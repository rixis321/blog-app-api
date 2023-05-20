FROM eclipse-temurin:17

LABEL mentainer="admin"
WORKDIR /app

COPY target/blogApp-0.0.1-SNAPSHOT.jar /app/blog-app-docker.jar
ENTRYPOINT["java","-jar","blog-app-docker.jar"]