create database banco;


CREATE TABLE cliente (
    id_usuario SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(100) UNIQUE NOT NULL,
    clave VARCHAR(100) NOT NULL
);

CREATE TABLE cuenta (
    id_cuenta SERIAL PRIMARY KEY,
    saldo NUMERIC(10,2) NOT NULL DEFAULT 0,
    id_usuario INT NOT NULL,
    CONSTRAINT fk_usuario
        FOREIGN KEY (id_usuario)
        REFERENCES cliente(id_usuario)
        ON DELETE CASCADE
);

CREATE OR REPLACE FUNCTION crear_cuenta_por_defecto()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO cuenta (saldo, id_usuario)
    VALUES (0, NEW.id_usuario);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_crear_cuenta
AFTER INSERT ON cliente
FOR EACH ROW
EXECUTE FUNCTION crear_cuenta_por_defecto();

INSERT INTO cliente (nombre, correo, clave)
VALUES ('Ana', 'ana@test.com', '1234');

SELECT * FROM cliente,cuenta where cuenta.id_usuario = cliente.id_usuario;
delete from cliente where id_usuario = 4;











