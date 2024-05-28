# Maven Build Stage
FROM maven:3.9.6-eclipse-temurin-21 AS build-stage

MAINTAINER fapethedev https://github.com/fapethedev mpetrivlin@gmail.com

WORKDIR /usr/src/

#Ajout du code source
COPY ./src/main/java ./src/main/java
COPY ./src/main/resources ./src/main/resources
COPY ./pom.xml ./pom.xml
COPY ./build.sh ./build.sh

# Build du code
RUN chmod +x ./build.sh \
    && ./build.sh \
    && mv ./tendance.jar ./bot.jar

# Runtime Build Stage
FROM eclipse-temurin:21.0.2_13-jre AS build-stage

RUN mkdir /home/tendance \
    && groupadd tendance \
    && useradd -d /home/tendance -g tendance tendance \
    && chmod 755 -R /home/tendance \
    && chown tendance:tendance /home/tendance

WORKDIR /home/tendance

COPY ./entrypoint.sh ./entrypoint.sh
COPY ./postgresql-ca.crt ./postgresql-ca.crt
COPY --from=build-stage /usr/src/tendance.jar ./
RUN chmod +x ./entrypoint.sh

USER tendance

ENTRYPOINT ["./entrypoint.sh"]

EXPOSE 8099