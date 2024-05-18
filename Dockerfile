# Использование базового образа с Java
FROM openjdk:17

# Указание рабочей директории в контейнере
WORKDIR /app

# Копирование исполняемого файла jar в рабочую директорию
COPY ./BankApplication-0.0.1-SNAPSHOT.jar BankApplication-0.0.1-SNAPSHOT.jar

COPY ./src/main/resources/logback-logstash.xml /app/src/main/resources/logback-logstash.xml
# Команда для запуска приложения
CMD ["java", "-jar", "BankApplication-0.0.1-SNAPSHOT.jar"]
