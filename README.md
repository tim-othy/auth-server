# auth-server
Spring-boot auth-server

## Usage

### Gradle
`./gradlew bootRun`

### Docker
`./gradlew build`
`docker build --build-arg JAR_FILE="build/libs/*.jar" -t auth-client .`
`docker run -p 8081:8081 auth-server"
