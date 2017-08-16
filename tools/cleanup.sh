#!/bin/sh

docker-compose down

echo "Removing all containers..."
docker rm $(docker ps -a -q)

echo "Removing images..."
docker rmi cd-course/jenkins
docker rmi cd-course/gitlab
docker rmi cd-course/nexus

echo "Remove mapped volumes..."
rm -rf *-data

echo "Remove obsolete known hosts..."
sed '/:522/ d' ~/.ssh/known_hosts > ~/.ssh/known_hosts.new
mv ~/.ssh/known_hosts.new ~/.ssh/known_hosts

