FROM eclipse-temurin:21-jdk AS build
WORKDIR /workspace

COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
COPY src/ src/

# Build a Spring Boot fat jar
RUN chmod +x mvnw \
  && ./mvnw -DskipTests package

# ---- runtime stage (small JRE image) ----
FROM eclipse-temurin:21-jre
WORKDIR /app

# Create non-root user
RUN useradd -r -u 10001 appuser
USER 10001

# Copy the built jar (your artifact name ends with -SNAPSHOT.jar)
COPY --from=build /workspace/target/*-SNAPSHOT.jar /app/app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]