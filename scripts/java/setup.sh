#!/bin/bash

cd /webapimock
sudo chown -R dev-user /webapimock

cd /webapimock/frontend
npm ci
