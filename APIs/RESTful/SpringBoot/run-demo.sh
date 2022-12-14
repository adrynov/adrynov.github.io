docker build -t webapi .
docker run --name web-app -p 8080:8080 -it --rm webapi
