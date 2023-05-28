#!/bin/bash

cd /webapimock/frontend
npm run build

cd /webapimock
./gradlew bootRun
