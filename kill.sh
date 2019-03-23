# app
docker kill app
docker rm app
docker rmi payara/app

# database
docker kill postgres
docker rm postgres
docker rmi payara/postgres