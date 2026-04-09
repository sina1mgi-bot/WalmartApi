FROM maven:3.9-eclipse-temurin-21-alpine
#nos ayuda a crear la aplicacion y correr las dependeciar y pruebas.
# Usa una imagen base que ya incluye Maven y Java 21 (ligera por ser Alpine)

WORKDIR /app
# Define el directorio de trabajo dentro del contenedor como /app

COPY pom.xml .
# Copia el achivo pom.xml desde tu máquina al contenedor (ruta actual/app)

COPY src ./src
#Copia el código fuente (carpeta src) al contenedor dentro de /app/src

RUN mvn clean package -DskipTests
#Ejecuta maven para compilar el proyecto y generar el JAR, omitiendo pruebas

ENTRYPOINT ["java", "-jar", "target/WalmartApi-0.0.1-SNAPSHOT.jar"]
# Define el comando que se ejecutará al iniciar el contenedor (ejecuta el JAR)