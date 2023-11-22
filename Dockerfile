FROM bellsoft/liberica-openjdk-alpine:17
LABEL authors="Chetan.Sharma"
RUN mkdir -p /opt/urlshortener

COPY target/urlshortener-0.0.1.jar /opt/urlshortener/
EXPOSE 8080
WORKDIR /opt/urlshortener

CMD java -jar urlshortener-0.0.1.jar

