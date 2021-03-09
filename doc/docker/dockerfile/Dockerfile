FROM adoptopenjdk/openjdk8-openj9:alpine-slim

RUN mkdir -p /blade

WORKDIR /blade

ENV TZ=Asia/Shanghai
ADD ./target/blog.jar ./app.jar
#ADD ./target/fonts/* /usr/share/fonts
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]
