# auth-server
Spring-boot OAuth 2 server.

## Usage

### Gradle
`./gradlew bootRun`

### Docker
1. `./gradlew build`
2. `docker build --build-arg JAR_FILE="build/libs/*.jar" -t auth-server .`
3. `docker run --network host auth-server`

### Minikube
`kubectl apply -f deployment.yaml`
