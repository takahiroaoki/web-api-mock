#!/bin/bash

cd /webapimock/frontend
npm run dev

cd /webapimock
./gradlew bootRun
