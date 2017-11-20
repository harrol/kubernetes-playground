FROM openjdk:8-alpine
EXPOSE 8080
COPY target/time-server-swarm.jar .
CMD ["java", "-jar", "time-server-swarm.jar", "-Djava.net.preferIPv4Stack=true"]