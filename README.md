Dockerized springboot application with mongodb which includes unit and integration tests.

Steps:
1. Run mongodb in seprate docker container.

docker run -d --restart=unless-stopped --name mongo -p 27018:27017 -v /c/Users/anshul/dockerizedmongodata/:/data/db mongo

2. to build it and get docker image from it.

mvn clean install docker:build
