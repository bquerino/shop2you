FROM adoptopenjdk:11-jre-hotspot
ADD build/libs/shop2you-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]