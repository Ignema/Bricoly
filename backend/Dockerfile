FROM gradle:7.0.2-jdk11

VOLUME /tmp

RUN mkdir app
WORKDIR /app

COPY . .

RUN gradle assemble


EXPOSE 8080

ENTRYPOINT ["java","-jar","./build/libs/backend-0.0.1-SNAPSHOT.war"]