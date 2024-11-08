CREACIÓN DE LA BASE DE DATOS Y SU USUARIO:

CREATE DATABASE antivirusdb;

CREATE USER 'nodo_antivirus'@'localhost' IDENTIFIED BY 'equipo4backend';
GRANT ALL PRIVILEGES ON antivirusdb.* TO 'nodoantivirus'@'localhost';
FLUSH PRIVILEGES;
