# Java docker example
# Version 1.0
# Author : jarrysix(jarrysix@gmail.com)
# Date : 2018-04-13 14:40
# Uasge:
# docker run -it --name service -p 8080:8080 -v $(pwd)/data:/data service:latest

FROM adoptopenjdk:14-jre-openj9

MAINTAINER jarrysix
LABEL vendor="yq"
LABEL version="1.0.0"

WORKDIR /data
COPY build/*.conf build/config ./
WORKDIR /app
COPY build/*.jar ./
COPY build/lib ./lib

#RUN apt-get update && apt-get install -y libfontconfig1  && \
RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.ustc.edu.cn/g' /etc/apk/repositories && \
    apk add tzdata fontconfig ttf-dejavu && cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
    apk del tzdata && \
    echo "if [ ! -f '/app/config/application.properties' ];"\
         "then cp -r /data/application.properties /app/config;fi;"\
         "java -Djava.security.egd=file:/dev/./urandom -jar *-runner.jar"\
         " -Dconf /app/application.properties"> /docker-boot.sh

VOLUME ["/app/config","/app/upload"]
EXPOSE 8080

ENTRYPOINT ["sh","/docker-boot.sh"]