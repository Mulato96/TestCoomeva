CREATE TABLE `super_antojitos`.`test_cliente` (
id_cliente int not null auto_increment,
identificacion numeric not null,
nombres varchar(100) not null,
apellidos varchar(100) not null,
direccion varchar(100) not null,
telefono varchar(100),
email varchar(100),
PRIMARY KEY (id_cliente)
);


CREATE TABLE `super_antojitos`.`test_producto` (
id_producto int not null auto_increment,
codigo varchar(30) not null,
nombre varchar(100) not null,
valor_unidad numeric(18,3) not null,
stock int not null,
PRIMARY KEY (id_producto)
);


CREATE TABLE `super_antojitos`.`test_factura` (
id_factura int not null auto_increment,
id_cliente int not null,
fecha_venta datetime not null,
valor_total numeric(18,3) not null,
PRIMARY KEY (id_factura),
FOREIGN KEY (id_cliente) REFERENCES test_cliente(id_cliente)
);


CREATE TABLE `super_antojitos`.`test_factura_detalle` (
id_factura_detalle int not null auto_increment,
id_factura int not null,
id_producto int not null,
cantidad int not null,
valor_unidad numeric(18,3) not null,
valor_total numeric(18,3) not null,
PRIMARY KEY (id_factura_detalle),
FOREIGN KEY (id_factura) REFERENCES test_factura(id_factura),
FOREIGN KEY (id_producto) REFERENCES test_producto(id_producto)
);




INSERT INTO super_antojitos.test_cliente (identificacion, nombres, apellidos, direccion, telefono, email) VALUES('11223344','CLIENTE','BAJO','CALLE 1 # 2-1','3210099','CL01@YAHOO.ES');
INSERT INTO super_antojitos.test_cliente (identificacion, nombres, apellidos, direccion, telefono, email) VALUES('11223344','CLIENTE','BAJO','CALLE 1 # 2-1','3210099','CL01@YAHOO.ES');
INSERT INTO super_antojitos.test_cliente (identificacion, nombres, apellidos, direccion, telefono, email) VALUES('789456','PETER','ROJO','CALLE 11 # 21-11',NULL,NULL);
INSERT INTO super_antojitos.test_cliente (identificacion, nombres, apellidos, direccion, telefono, email) VALUES('66995522','JAIR','RUIZ','CALLE 63 # 55-1','3669955','JAIR@YAHOO.ES');
INSERT INTO super_antojitos.test_cliente (identificacion, nombres, apellidos, direccion, telefono, email) VALUES('2255448','VICTOR','BARCO','CALLE 19 # 21','7410022','VICTOR@YAHOO.ES');
INSERT INTO super_antojitos.test_cliente (identificacion, nombres, apellidos, direccion, telefono, email) VALUES('41000333','LUIS','CORREO','CALLE 45 # 32-11','4444444','LCORREO@YAHOO.ES');



INSERT INTO super_antojitos.test_producto(codigo, nombre, valor_unidad, stock) VALUES('0001','TOSTACOS',950,15);
INSERT INTO super_antojitos.test_producto(codigo, nombre, valor_unidad, stock) VALUES('0002','LECHE',2350,40);
INSERT INTO super_antojitos.test_producto(codigo, nombre, valor_unidad, stock) VALUES('0003','PLATANO',1500,20);
INSERT INTO super_antojitos.test_producto(codigo, nombre, valor_unidad, stock) VALUES('0004','PAÑALES',36500,4);
INSERT INTO super_antojitos.test_producto(codigo, nombre, valor_unidad, stock) VALUES('0005','BULTO DE MANDARINAS',156800,9);
INSERT INTO super_antojitos.test_producto(codigo, nombre, valor_unidad, stock) VALUES('0006','ARROZ',6450,60);
INSERT INTO super_antojitos.test_producto(codigo, nombre, valor_unidad, stock) VALUES('0007','PESCADO',99000,45);
INSERT INTO super_antojitos.test_producto(codigo, nombre, valor_unidad, stock) VALUES('0008','HUEVOS',11500,20);
INSERT INTO super_antojitos.test_producto(codigo, nombre, valor_unidad, stock) VALUES('0009','PAPAS JAJAJAJA',6600,1);
INSERT INTO super_antojitos.test_producto(codigo, nombre, valor_unidad, stock) VALUES('0010','DETERGENTE',5001000,3);

