# Spring Boot Microservice Starter

A small Spring Boot project demonstrating:
- REST endpoints
- JPA + Postgres
- Flyway migrations
- Docker + docker-compose
- CI (GitHub Actions)

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
