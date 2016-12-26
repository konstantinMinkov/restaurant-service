FROM jetty:9.3.12
ADD ./target/*.war /var/lib/jetty/webapps/ROOT.war