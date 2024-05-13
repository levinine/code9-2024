build-eureka-jar:
	cd eureka && \
		mvn clean package

build-library-jar:
	cd library && \
		mvn clean package

build-user-profile-jar:
	cd user-profile-service && \
		mvn clean package

build-jars: build-eureka-jar build-library-jar build-user-profile-jar

dev:
	docker-compose up -d --remove-orphans

stop:
	docker-compose stop

down:
	docker-compose down

destroy:
	docker-compose down -v

destroy-images:
	docker images | grep levinine/codenine | awk '{print $3}' | xargs docker rmi -f
