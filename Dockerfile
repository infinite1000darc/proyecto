FROM tomcat:9.0-jdk11-adoptopenjdk-hotspot

# Copia el archivo WAR a la carpeta webapps de Tomcat
COPY target/ServicioCompras-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/

# Exponer el puerto 8080
EXPOSE 8080

# Iniciar Tomcat
CMD ["catalina.sh", "run"]
