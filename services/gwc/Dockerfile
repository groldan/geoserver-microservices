FROM org.geoserver.cloud/gs-cloud-docker-base-java:latest

ARG JAR_FILE=dummy

ADD target/${JAR_FILE} /opt/gwc-service.jar

ENTRYPOINT exec java $JAVA_OPTS -jar /opt/gwc-service.jar