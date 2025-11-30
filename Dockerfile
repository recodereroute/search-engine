# 1. 빌드 단계
FROM gradle:8.5-jdk17 AS builder
WORKDIR /app
COPY build.gradle settings.gradle ./
COPY src ./src
RUN gradle bootJar -x test --no-daemon

# [추가] 빌드된 jar 안에 SearchController가 진짜 있는지 목록을 출력해라!
#RUN jar tf build/libs/*.jar | grep SearchController || echo "❌ 컨트롤러가 없습니다!!!!"

# 2. 실행 단계 (여기를 바꿨습니다!)
# openjdk:17-slim 대신 eclipse-temurin:17-jre 이미지를 사용합니다.
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
