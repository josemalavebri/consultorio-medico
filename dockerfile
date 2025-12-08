# ===============================================
# ETAPA 1: BUILD (Compilación)
# Usamos Eclipse Temurin 21 con Maven
# ===============================================
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
COPY lib ./lib
RUN mvn package -DskipTests

# ===============================================
# ETAPA 2: RUN (Con soporte gráfico X11)
# Usamos una imagen Temurin 21 más completa (ej. basada en Jammy)
# ===============================================
FROM eclipse-temurin:21-jre-jammy AS run

WORKDIR /usr/app

# Instala las utilidades mínimas de X11 necesarias para la GUI
# Las imágenes 'jammy' están basadas en Ubuntu/Debian, por lo que apt funciona
RUN apt-get update && apt-get install -y \
    x11-utils \
    libxext6 \
    libxrender1 \
    && rm -rf /var/lib/apt/lists/*

# Copia el JAR ejecutable (Uber JAR)
COPY --from=build /app/target/ConsultorioMedico-1.0-SNAPSHOT-jar-with-dependencies.jar /usr/app/app.jar

# Copia los archivos de base de datos o recursos estáticos
COPY bd /usr/app/bd/

# Comando de inicio para ejecutar la aplicación JAR
CMD ["java", "-jar", "app.jar"]