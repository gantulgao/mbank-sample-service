##M - ийн Sample сэрвис ажиллуулах. 

Доорхи сэрвисийг ажиллуулахад Spring-cloud-config сэрвэрийг ажлуулсан байх ёстой. 

####Config server  ажиллуулах
```bash
set CONFIG_PATH=./config-files
java -jar mbank-config-server-0.0.1.jar 
```

####Sample сэрвисийг ажиллуулах. 

Энэ сэрвис mbank-sample-service нь Maven Project юм. Иймээс эхлээд WAR file үүсгэх ёстой. Энэ файл
./mbank-sample-service/mbank-sample-service-service/target -дотор үүссэнэ. 

```bash
cd mbank-sample-service
mvn clean package
java -jar mbank-sample-service-service.war
```


