FROM public.ecr.aws/amazoncorretto/amazoncorretto:17.0.7-al2 as builder

COPY . /src
WORKDIR /src

RUN ./gradlew build --no-daemon

FROM public.ecr.aws/amazoncorretto/amazoncorretto:17.0.7-al2

COPY --from=builder /src/main/build/libs/*.jar /app.jar

ENTRYPOINT ["java", "-Xms512m", "-Xmx1024m", "-jar", "/app.jar"]