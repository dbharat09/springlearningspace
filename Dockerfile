FROM openjdk:21-ea-11-slim
WORKDIR /app
COPY target/springlearningspace-1.0.jar /app/
#COPY pom.xml .
#COPY src .
#RUN #mvn clean install
EXPOSE 8080
#ENTRYPOINT ["mvn", "clean", "install"]
CMD ["java" , "-jar" , "springlearningspace-1.0.jar"]
