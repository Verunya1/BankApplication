# Использование базового образа с Java
FROM openjdk:17

# Указание рабочей директории в контейнере
WORKDIR /app

# Копирование исполняемого файла jar в рабочую директорию
COPY ./*.jar app.jar

# Копирование файла logback-logstash.xml в папку /app/src/main/resources/
COPY ./src/main/resources/logback-logstash.xml /app/src/main/resources/

# Команда для запуска приложения
CMD ["java", "-jar", "app.jar"]
