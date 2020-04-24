# Java docker example
# Version 1.0
# Author : jarrysix(jarrysix@gmail.com)
# Date : 2018-04-13 14:40
# Uasge:
# docker run -it --name service -p 8080:8080 -v $(pwd)/data:/data service:latest

FROM adoptopenjdk/openjdk14-openj9:alpine-jre

MAINTAINER jarrysix
LABEL vendor="yq"
LABEL version="1.0.0"

WORKDIR /app
COPY build/*.jar build/*.conf ./
COPY build/lib ./lib

#RUN apt-get update && apt-get install -y libfontconfig1  && \
RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.ustc.edu.cn/g' /etc/apk/repositories && \
    apk add tzdata fontconfig ttf-dejavu && cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
    apk remove tzdata && \
    echo "if [ ! -f '/data/app.conf' ];then cp /app/app.conf /data/;fi;"\
    "java -Djava.security.egd=file:/dev/./urandom -jar *-runner.jar -Dconf /data/app.conf"> /docker-boot.sh

VOLUME ["/data","/app/upload"]
EXPOSE 8080

ENTRYPOINT ["sh","/docker-boot.sh"]