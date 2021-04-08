ARG TAG
FROM geoservercloud/docker-base-java:${TAG}

ARG JAR_FILE=dummy
ADD target/${JAR_FILE} /opt/app/geofence-service.jar

CMD exec java $JAVA_OPTS -jar /opt/app/geofence-service.jar
