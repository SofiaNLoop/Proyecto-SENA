DROP DATABASE IF EXISTS gestion_servicios;

CREATE DATABASE IF NOT EXISTS gestion_servicios;

USE gestion_servicios;

SELECT `administrador`.`id`,
    `administrador`.`contraseña`,
    `administrador`.`correo`,
    `administrador`.`nombre`
FROM `gestion_servicios`.`administrador`;

/*
 -- Crear tabla Administrador
CREATE TABLE IF NOT EXISTS administrador (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    correo VARCHAR(255) NOT NULL,
    contraseña VARCHAR(255) NOT NULL
);

-- Crear tabla Cliente
CREATE TABLE IF NOT EXISTS cliente (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    correo VARCHAR(255) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    id_administrador INT,
    FOREIGN KEY (id_administrador) REFERENCES administrador(id)
);

-- Crear tabla Servicio
CREATE TABLE IF NOT EXISTS servicio (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10, 2) NOT NULL,
    id_administrador INT,
    FOREIGN KEY (id_administrador) REFERENCES administrador(id)
);

-- Crear tabla Factura
CREATE TABLE IF NOT EXISTS factura (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_cliente INT NOT NULL,
    id_servicio INT NOT NULL,
    fecha DATE NOT NULL,
    total DECIMAL(10, 2) NOT NULL,
    id_administrador INT,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id),
    FOREIGN KEY (id_servicio) REFERENCES servicio(id),
    FOREIGN KEY (id_administrador) REFERENCES administrador(id)
); -*/