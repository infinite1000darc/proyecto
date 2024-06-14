CREATE TABLE compra (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre_cliente VARCHAR(255),
    email VARCHAR(255),
    direccion VARCHAR(255),
    rfc VARCHAR(255),
    nombre_producto VARCHAR(255),
    cantidad_producto INT,
    precio_producto DOUBLE
);