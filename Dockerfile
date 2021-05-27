FROM tomcat:8-jre11
RUN rm -rf /usr/local/tomcat/webapps/*
COPY target/way2homeservices.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]
WORKDIR /usr/local/tomcat/webapps/
VOLUME /usr/local/tomcat
