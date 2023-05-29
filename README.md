# web-api-mock

This project is for easy creation of web api mock.

## Tech stack
- Node.JS 16
- Spring Boot 3.0.1 (Java 17)
- MySQL 8

## Requiements
The environment is bellow.

- Windows 11
- Docker Desktop for Windows 4.2.0
- VSCode + Remote Development 0.21.0（VSCode extensions）

## Initial setup
```
# @project root
$ docker compose build
$ docker compose up -d

# Initialize the database. Type "password" when asked.
$ docker exec -it webapimock_db /bin/bash /scripts/setup.sh

# Initialize the application server.
$ docker exec -it webapimock_app /bin/bash /webapimock/scripts/setup.sh
```

## Development
```
# In webapimock_app container.
# Compile Node.js code in development mode by webpack.
$ cd /webapimock/frontend
$ npm run dev
```
Then, start debugging, the function of VSCode and its Extention.

## Boot
```
# Build and boot by Gradle. Get access to http://localhost:8080/list after the build is completed.
$ docker exec -it webapimock_app /bin/bash /webapimock/scripts/boot.sh
```

## Test
```
# Unit test for Java
$ docker exec -it webapimock_app /bin/bash /webapimock/scripts/test.sh
```
