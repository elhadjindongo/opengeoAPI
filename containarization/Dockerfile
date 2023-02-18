FROM openjdk:11
#LABEL Maintainer El Hadji M. NDONGO
RUN mkdir /app
COPY ../target/*.jar /app/
WORKDIR /app
EXPOSE 8080
CMD java OpenGeography