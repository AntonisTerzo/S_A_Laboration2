FROM quay.io/wildfly/wildfly:33.0.2.Final-jdk21
LABEL authors="rodop"
COPY target/S_A_Laboration2-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments
EXPOSE 8080
ENTRYPOINT ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]