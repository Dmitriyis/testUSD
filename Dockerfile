FROM openjdk:11
COPY ./build/libs/testUSD.jar ./app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]