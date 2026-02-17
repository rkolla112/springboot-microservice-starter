# Spring Boot Microservice Starter

A small Spring Boot project demonstrating:
- REST endpoints
- validation (Jakarta Validation)
- JPA + Postgres
- Flyway migrations
- Docker + docker-compose
- tests + CI (GitHub Actions)

## Endpoints

- `GET /health` → `{ "ok": true }`
- `POST /v1/users` → create a user (name + email)
- `GET /v1/users` → list users

## Run locally

Start Postgres:

```bash
docker compose up -d
```

Run the app:

```bash
mvn spring-boot:run
```

Health:
- http://localhost:8080/health

Create a user:

```bash
curl -s http://localhost:8080/v1/users \
  -H 'content-type: application/json' \
  -d '{"name":"Rahul","email":"rkolla112@gmail.com"}'
```

## Tests

```bash
mvn test
```

Note: controller tests use Spring MVC slice tests (`@WebMvcTest`) so they don’t require Postgres to be running.
