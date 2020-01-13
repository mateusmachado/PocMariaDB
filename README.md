
# Overview
URI-PRICE


## Step 1 Run MariaDB
  - docker run -d -p 3306:3306 --name mcs37 -eMARIADB_ROOT_PASSWORD=test mariadb/columnstore:latest
  - docker exec -it mcs37 /bin/bash
  - mcsmysql -p
  - show databases;
  - create database test;





