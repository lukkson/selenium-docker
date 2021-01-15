FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

#WORKSPACE
WORKDIR /usr/share/udemy

# ADD.jar under targe from hist
# into this image
ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs

# Add suite files
ADD search-flight-module.xml search-flight-module.xml
ADD search-module.xml search-module.xml

# ADD halth check script
ADD healthcheck.sh healthcheck.sh
# BROWSER
# HUB_HOST
# MODULE

ENTRYPOINT sh healthcheck.sh