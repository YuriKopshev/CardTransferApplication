FROM openjdk:11
EXPOSE 5500
ADD build/libs/MoneyTransferService-0.0.1-SNAPSHOT.jar app.jar
CMD ["java","-jar","app.jar"]