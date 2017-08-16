FROM "jenkins/jenkins:2.60.2"
USER root
RUN apt-get update && apt-get install -y maven
COPY settings.xml /etc/maven/

# drop back to the regular jenkins user - good practice
USER jenkins


