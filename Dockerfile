# Maven Build Stage
FROM maven:3.9.6-eclipse-temurin-21 AS build-stage

MAINTAINER fapethedev https://github.com/fapethedev mpetrivlin@gmail.com

WORKDIR /usr/src/

# Ajout du code source
COPY ./src/main/java ./src/main/java
COPY ./src/main/resources ./src/main/resources
COPY ./pom.xml ./pom.xml

# Build du code
RUN mvn clean compile package -DskipTests && mv ./target/tendance-1.0.0.jar ./tendance-1.0.0.jar

# Runtime Build Stage
FROM eclipse-temurin:21.0.2_13-jre

# Add Env
ENV REDIS_USE_SSL fakeurl
ENV REDIS_TIMEOUT fakeurl
ENV REDIS_USERNAME fakeurl
ENV REDIS_PASSWORD fakeurl
ENV REDIS_URL fakeurl

ENV MONGO_INITDB_ROOT_USERNAME fakeurl
ENV MONGO_INITDB_ROOT_PASSWORD fakeurl
ENV MONGO_INITDB_DATABASE fakeurl
ENV MONGO_URI fakeurl

ENV DATASOURCE_USERNAME fakeurl
ENV DATASOURCE_PASSWORD fakeurl
ENV DATASOURCE_URL fakeurl

ENV MAIL_HOST fakeurl
ENV MAIL_PORT fakeurl
ENV MAIL_USERNAME fakeurl
ENV MAIL_PASSWORD fakeurl

ENV GITHUB_CLIENT_ID fakeurl
ENV GITHUB_CLIENT_SECRET fakeurl

ENV GOOGLE_CLIENT_ID fakeurl
ENV GOOGLE_CLIENT_SECRET fakeurl

ENV CLOUDINARY_CDN_KEY fakeurl
ENV CLOUDINARY_CDN_SECRET fakeurl
ENV CLOUDINARY_CDN_CLOUDNAME fakeurl

ENV CDN_NAME fakeurl
ENV CDN_FOLDER fakeurl

RUN mkdir /home/tendance \
    && groupadd tendance \
    && useradd -d /home/tendance -g tendance tendance \
    && chmod 755 -R /home/tendance \
    && chown tendance:tendance /home/tendance

WORKDIR /home/tendance

ADD ./entrypoint.sh ./entrypoint.sh
ADD ./target/tendance-1.0.0.jar ./tendance-1.0.0.jar
RUN chmod +x ./entrypoint.sh

USER tendance

ENTRYPOINT ["./entrypoint.sh"]

EXPOSE 8099