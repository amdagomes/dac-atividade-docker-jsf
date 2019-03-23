docker build -t payara/postgres ./postgres
docker run -p 5433:5432 -d --name postgres payara/postgres
mvn clean package
docker build -t payara/app .
docker run -p 4848:4848 -p 8082:8080 -d --name app --link postgres:host-banco payara/app