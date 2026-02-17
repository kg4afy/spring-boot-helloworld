# spring-boot-helloworld

A simple Spring Boot "Hello World" application with REST API endpoints, built with Java 25 and Spring Boot 4.0.

## Endpoints

### `GET /`

Returns a greeting with the client's IP address, operating system, and browser (parsed from the User-Agent header).

**Example response:**

```text
Hello, 192.168.1.100

Operating System: Linux
Browser: Chrome
```

### `GET /error`

Intentionally throws a `RuntimeException` for testing purposes (logging, distributed tracing, error handling, etc.).

## Tech Stack

- Java 25
- Spring Boot 4.0.0-M3
- Maven

## Building

```bash
mvn clean package
```

To build using the internal Nexus mirror:

```bash
mvn -s ./settings.xml clean package
```

## Running

```bash
java -jar target/spring-boot-helloworld-1.0.0-SNAPSHOT.jar
```

The application starts on port `8080` by default.

## CI/CD

A GitHub Actions workflow (`.github/workflows/spring-boot-helloworld.yml`) builds the application using self-hosted ARC runners on the okdlab OpenShift cluster with the `java25-builder` container image.

The workflow triggers on:

- Pushes to the `main` branch
- Manual dispatch (`workflow_dispatch`)
