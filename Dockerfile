FROM openjdk:14-alpine
COPY ./build/libs/k8s-test-app.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8091
ENTRYPOINT ["java", "-jar", "k8s-test-app.jar"]
