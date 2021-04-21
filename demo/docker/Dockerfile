#
# MAINTAINER       sakoo.jiang <sakoo.jiang@dbappsecurity.com.cn>
# DOCKER-VERSION    1.12
#
# Dockerizing quartz-all-task: Dockerfile for building quartz-all-task images
#
FROM       registry.storm.io/library/jdk_cn:1.8.0
MAINTAINER sakoo.jiang <sakoo.jiang@dbappsecurity.com.cn>

ADD init.sh /init.sh
ADD application-produce.yml /usr/local/app/application-produce.yml

RUN dos2unix /init.sh && chmod +x /init.sh
ADD *.war /usr/local/app/app.war
WORKDIR /usr/local/app
ENTRYPOINT ["/init.sh", "java", "-jar","-Dfile.encoding=UTF-8", "-Dspring.profiles.active=produce", "app.war"]