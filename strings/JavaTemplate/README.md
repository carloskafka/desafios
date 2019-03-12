# Run in Terminal

1. `mvn clean compile assembly:single` 
2. `java -jar target\StringFormatter-1.0-SNAPSHOT-jar-with-dependencies.jar`

**All parameters are optional, if there isn't any, all parameters are set to default.**

# Run tests

`mvn test`

# Run code coverage

`mvn prepare-package`

Path: target\site\jacoco\index.html
