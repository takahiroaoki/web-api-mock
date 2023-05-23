# web-api-mock

This project is for easy creation of web api mock using Spring Boot 3.0.1.

## Environment
The environment is bellow.

- Windows 11
- Docker Desktop for Windows 4.2.0
- VSCode + Remote Development 0.21.0（VSCode extensions）

## Initial setup
```
# Initialize the database. Type "password" when asked.
$ docker exec -it webapimock_db /bin/bash /scripts/setup.sh
```

## Boot
```
# Build the frontend-src.
$ docker exec -it webapimock_frontdev /bin/bash /frontend/scripts/build.sh

# Build and boot by Gradle. Get access to http://localhost:8080/list after the build is completed.
$ docker exec -it webapimock_app /bin/bash /webapimock/scripts/boot.sh
```

## Test
```
# Unit test for Java
$ docker exec -it webapimock_app /bin/bash /webapimock/scripts/test.sh
```