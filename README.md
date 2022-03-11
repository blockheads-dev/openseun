# SEUNswap
Initial Commit for SEUNswap branch

# Run Application

Run docker-file.yaml

```
version: '2'

services:
  app:
    image: 'kaspir/openseun:latest'
    build:
      context: .
    container_name: seunswap
    ports:
      - "8100:8100"
    depends_on:
      - db
    environment:
      - SPRING_DATASOURCE_URL=jdbc:postgresql://pg-server:5432/seunswap_db
      - SPRING_DATASOURCE_USERNAME=postgres
      - SPRING_DATASOURCE_PASSWORD=postgres
      - SPRING_JPA_HIBERNATE_DDL_AUTO=update

  db:
    image: 'postgres:14.0-alpine'
    container_name: pg-server
    environment:
      - POSTGRES_USER=postgres
      - POSTGRES_PASSWORD=postgres
      - POSTGRES_DB=seunswap_db
```

# Documentation

You can access the SwaggerUI docs here: http://localhost:8100/docs
