FROM openjdk:17-oracle
COPY ./target/Security-0.0.1-SNAPSHOT.jar Security.jar
CMD ["java","-jar","Security.jar"]

