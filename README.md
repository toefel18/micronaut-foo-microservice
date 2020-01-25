# Micronaut quick trail


Build source + container
```bash
git clone https://github.com/toefel18/micronaut-foo-microservice.git
cd micronaut-foo-microservice
./gradlew clean build
docker build . -t micronaut-foo-microservice
```

Test with specific memory settings
```bash
# start container with max 500mb mem
docker run -m 500m --cpus="1" -p 8080:8080 micronaut-foo-microservice:latest

# in other terminal
docker stats

# internal endpoint that maps kotlin data class as json
curl "localhost:8080/loyalty"

# users is call forwarded to https://jsonplaceholder.typicode.com/users
curl "localhost:8080/loyalty/users"

# openapi docs
curl "http://localhost:8080/swagger/micronaut-foo-microservice-0.0.yml" # swagger docs
```

Retry with resource restrictions 
```bash
docker run -m 100m --cpus="1" -p 8080:8080 micronaut-foo-microservice:latest
 - repeat tests above
docker run -m 50m --cpus="1" -p 8080:8080 micronaut-foo-microservice:latest
- repeat tests above
docker run -m 100m --cpus=".5" -p 8080:8080 micronaut-foo-microservice:latest
- repeat tests above
```

TODO run gatling test, for now, just try:

for i in {1..100} 
do
    curl "localhost:8080/loyalty" & 
done