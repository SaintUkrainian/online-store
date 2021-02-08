FROM maven:3.6.3-jdk-11

WORKDIR /app

COPY . .

RUN mvn package

EXPOSE 8080

CMD ["mvn", "spring-boot:run"]