FROM maven:3.8.4-openjdk-17

WORKDIR /root
COPY . ./
RUN mvn clean package
RUN mv $(find /root/application/target/ -type f -name '*.jar' -a ! -name '*-javadoc.jar' -a ! -name '*-sources.jar' -a ! -name '*-tests.jar') /root/app.jar

FROM openjdk:17
WORKDIR /var/app
COPY --from=0 /root/app.jar /var/app/app.jar

CMD ["java", "-jar", "app.jar"]