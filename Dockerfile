FROM openjdk:11
#LABEL Maintainer El Hadji M. NDONGO
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
