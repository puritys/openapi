mvnGen:
	mvn clean generate-resources

mvnDep:
	mvn dependency:tree

mvnRun:
	mvn spring-boot:run

mvnRunDebug:
	mvn spring-boot:run  -Dspring-boot.run.jvmArguments="-Xdebug -Xnoagent -Djava.compiler=NONE  -Xrunjdwp:transport=dt_socket,address=9999,server=y,suspend=n"


mvnRunWithJar:
	mvn package
	java -jar target/test-0.0.1-SNAPSHOT.jar


gradleGen:
	./gradlew openApiGenerate -i

graldeGenHelp:
	./gradlew openApiGenerator -i

gradleRun:
	./gradlew bootRun -i
	#--continuous  -i
	#--args='--spring.profiles.active=dev'


gradleRunWithJar:
	./gradlew build -i
	java -jar build/libs/test-0.0.1-SNAPSHOT.jar
