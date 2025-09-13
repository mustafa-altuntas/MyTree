FROM eclipse-temurin:21-jdk-jammy AS build

WORKDIR /app

COPY src/ ./src/
COPY sozluk.txt ./

RUN javac -d ./out src/*.java
RUN echo "Main-Class: MyTree" > manifest.txt
RUN jar cfm mytree.jar manifest.txt -C out/ .

# Runtime stage
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

COPY --from=build /app/mytree.jar ./
COPY --from=build /app/sozluk.txt ./

# Container başlatıldığında çalışacak komut
CMD ["java", "-jar", "mytree.jar", "sozluk.txt"]