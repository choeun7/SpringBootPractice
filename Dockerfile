FROM amazoncorretto:17-alpine
COPY build/libs/mjublog-1.3.jar /app/
CMD ["java", "-jar", "/app/mjublog-1.3.jar"]