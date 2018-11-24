FROM java:8-alpine

COPY target/uberjar/testweb.jar /testweb/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/testweb/app.jar"]
