# Использование базового образа с Java
FROM openjdk:17

# Указание рабочей директории в контейнере
WORKDIR /app

# Копирование исполняемого файла jar в рабочую директорию
COPY ./*.jar app.jar
COPY ./src/main/resources/logback-logstash.xml app/src/main/resources/logback-logstash.xml

# Команда для запуска приложения
CMD ["java", "-jar", "app.jar"]