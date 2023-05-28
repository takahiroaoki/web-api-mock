#!/bin/bash

sudo chown -R $(whoami) /webapimock

cd /webapimock/frontend
npm ci
