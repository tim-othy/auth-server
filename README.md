# auth-server
Spring-boot auth-server

## Usage

### Gradle
`./gradlew bootRun`

### Docker
1. `./gradlew build`
2. `docker build --build-arg JAR_FILE="build/libs/*.jar" -t auth-server .`
3. `docker run --network host auth-server`
