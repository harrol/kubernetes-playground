FROM openjdk:8-alpine
EXPOSE 8080
COPY target/hello-server-swarm.jar .
CMD ["java", "-jar", "hello-server-swarm.jar", "-Djava.net.preferIPv4Stack=true"]