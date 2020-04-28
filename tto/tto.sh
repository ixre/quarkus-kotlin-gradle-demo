#!/usr/bin/env bash

PKG_NAME="java/net/fze/mzl/board"
tto -conf tto.conf -tpl ./templates/quarkus -out ../src/main
# copy pojo objects
#mkdir -p ../src/${PKG_NAME}/pojo
#find ../src -path "*/pojo" |xargs cp output/$PKG_NAME/pojo/*

