# simple-rpc-demo

### old

```shell
rm -rf src/main/resources/META-INF/native-image/

mvn clean package

java -agentlib:native-image-agent=config-output-dir=src/main/resources/META-INF/native-image/ -jar target/simple-rpc-demo-3.2.0-SNAPSHOT.jar

mvn -Pnative clean package

java -Dspring.aot.enabled=true -Dorg.graalvm.nativeimage.imagecode=runtime -jar target/simple-rpc-demo-3.2.0-SNAPSHOT.jar
```

### new

```shell
mvn spring-boot:process-aot


mvn -Pnative native:compile


./target/simple-rpc-demo
```
