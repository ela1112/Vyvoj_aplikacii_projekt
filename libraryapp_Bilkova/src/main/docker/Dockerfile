FROM gradle:7.6-jdk11 as builder
USER root
RUN mkdir /libraryapp
WORKDIR /libraryapp
COPY . .
RUN gradle :clean :bootJar
RUN mv build/libs/libraryapp-*.jar libraryapp.jar

FROM openjdk:11-jre-slim
USER root
WORKDIR /libraryapp
COPY --from=builder ./libraryapp/libraryapp.jar libraryapp.jar
CMD ["java", "-jar", "libraryapp.jar"]