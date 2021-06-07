#!/bin/zsh
BASE_DIR=$(pwd)
cd ${BASE_DIR}/dbdoc-web/
npm run build
cd ${BASE_DIR}/dbdoc-server/
mvn clean package
cd ${BASE_DIR}
docker build -t duqian/dbdoc:latest .
