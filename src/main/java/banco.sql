create table cliente(
id serial primary key,
nombre varchar(100),
correo varchar(100),
clave varchar(50),
dinero decimal(10,2)
);

insert into cliente(nombre,correo,clave,dinero)
values('cliente123','cliente123@gmail.com','clave123', 1000);

select * from cliente; 