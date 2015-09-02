#!/bin/sh

rm log.txt

java -jar tools/PlayGame-1.2.jar maps/map53.txt 1000 1000 log.txt "java -jar framework.jar" "java -jar RandomBot.jar" | java -jar tools/ShowGame-1.2.jar

