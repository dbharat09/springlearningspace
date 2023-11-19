FROM openjdk:21-ea-11-slim
WORKDIR /app
COPY target/springlearningspace-1.0.jar /app/
EXPOSE 8080
CMD ["java" , "-jar" , "springlearningspace-1.0.jar"]