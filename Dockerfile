FROM openjdk:11
EXPOSE 8080
ADD target/bankma.jar bankma.jar
ENTRYPOINT ["java", "-jar", "/bankma.jar"]