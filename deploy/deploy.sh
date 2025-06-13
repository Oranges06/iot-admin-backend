mv ../maku-cloud-gateway/target/*.jar ./maku-cloud-gateway.jar
mv ../maku-cloud-screen/target/*.jar ./maku-cloud-screen.jar
mv ../maku-cloud-new/target/*.jar ./maku-cloud-new.jar
mv ../maku-cloud-system/target/*.jar ./maku-cloud-system.jar

docker-compose down
docker-compose build
docker-compose up -d