#!/usr/bin/env sh

cd views && yarn build &&\
  mv dist/* ../src/main/resources/app