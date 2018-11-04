FROM openjdk:8-jre-alpine
EXPOSE 8080
COPY /target/employeeDtls-0.1.war employeeDtls-0.1.war
ENTRYPOINT ["java","-jar","employeeDtls-0.1.war"]