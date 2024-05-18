# Использование базового образа с Java
FROM openjdk:17

# Указание рабочей директории в контейнере
WORKDIR /app

# Копирование исполняемого файла jar в рабочую директорию
COPY ./*.jar app.jar

# Команда для запуска приложения
CMD ["java", "-jar", "app.jar"]