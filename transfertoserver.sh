#!/bin/bash
rm build/libs/api-0.0.1-SNAPSHOT.jar
./gradlew build
scp build/libs/api-0.0.1-SNAPSHOT.jar jacob@45.33.39.105:/home/jacob
