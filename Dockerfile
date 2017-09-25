FROM java:8
VOLUME /tmp
ADD mspoc-02-1.jar mspoc02.jar
RUN bash -c 'touch /mspoc02.jar'
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/mspoc02.jar"]
