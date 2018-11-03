
CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `AltaCliente` (IN `apellido` VARCHAR(50), IN `nombres` VARCHAR(100), IN `fecha_fallecimiento` DATE, IN `dni` VARCHAR(12), IN `dirección` VARCHAR(200), IN `nombre_familiar` VARCHAR(200), IN `telefono_familiar` VARCHAR(20), IN `cocheria` TEXT, IN `tipo_fallecimiento` TINYINT(1), IN `email_familiar` VARCHAR(200), IN `dni_ocupante` VARCHAR(200))  BEGIN 
INSERT INTO 
  `Clientes` (`apellido`, `nombres`, `fecha_fallecimiento`, `dni`, `direccion`, `nombre_familiar`, `telefono_familiar`, `cocheria`, `tipo_fallecimiento`, `email_familiar`, `dni_ocupante`) 
 VALUES 
 (apellido, nombres, fecha_fallecimiento, dni, dirección, nombre_familiar, telefono_familiar, cocheria, tipo_fallecimiento, email_familiar,  dni_ocupante);
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `buscarBovedaporUbi` (IN `value1` VARCHAR(10), IN `value2` VARCHAR(10), IN `value3` VARCHAR(10), IN `value4` VARCHAR(10), IN `value5` VARCHAR(10), IN `value6` VARCHAR(10))  NO SQL
BEGIN

select * from Clientes inner join ubicacionesPorCliente on Clientes.dni = ubicacionesPorCliente.dni where Circ = value1 and  seccion = value2 and  macizo = value3 and parcela = value4 and  bis = value5 and  unidad=value6;

END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `buscarCenizarioporUbi` (IN `value1` VARCHAR(10), IN `value2` VARCHAR(10))  NO SQL
BEGIN

select * from Clientes inner join ubicacionesPorCliente on Clientes.dni = ubicacionesPorCliente.dni where mueble = value1  and nicho = value2;

END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `buscarClienteIndigentesporUbi` (IN `value1` VARCHAR(10), IN `value2` VARCHAR(10), IN `value3` VARCHAR(10), IN `value4` VARCHAR(10))  NO SQL
BEGIN

select * from Clientes inner join ubicacionesPorCliente on Clientes.dni = ubicacionesPorCliente.dni where seccion = value1 and  macizo = value2 and  sepultura = value3 and  inhumacion = value4;

END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `buscarClientesPalmerasS` (IN `value1` VARCHAR(10))  NO SQL
BEGIN

select * from Clientes inner join ubicacionesPorCliente on Clientes.dni = ubicacionesPorCliente.dni where sepultura = value1;

END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `BuscarCodigo` (IN `value1` INT(11), IN `value2` VARCHAR(50))  NO SQL
BEGIN

select * from codigos where codigos.id = value1 or codigos.descripcion LIKE value2;

end$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `buscarDNI` (IN `value` VARCHAR(10))  NO SQL
BEGIN

select Clientes.dni from Clientes WHERE Clientes.dni = value;

END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `buscarNewClientes` (IN `value1` VARCHAR(100), IN `value2` VARCHAR(100), IN `value3` VARCHAR(100), IN `value4` VARCHAR(100), IN `value5` VARCHAR(100), IN `fecha` DATE)  NO SQL
BEGIN

if  (value1 is not null) then 
SELECT * from `Clientes` WHERE `apellido` = value1;

elseif (value1 is not null and value2 is not null ) then 
SELECT * from `Clientes` WHERE `apellido` = value1 and `nombres`= value2 ;

elseif  (value3 is not null) then 
select * from Clientes where Clientes.dni = value3;

elseif  (fecha is not null) then 
select * from Clientes where fecha_fallecimiento = fecha;

elseIF (value4 is not null)  then 
(SELECT * from `Clientes` WHERE  `direccion`= value4 );
elseIF (value5 is not null)  then 
(SELECT * from `Clientes` WHERE `telefono_familiar` = value5);
else            
SET @err_message =  ' no existe el cliente';
    
END IF;
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `buscarNicheraporUbi` (IN `value1` VARCHAR(10), IN `value2` VARCHAR(10), IN `value3` VARCHAR(10), IN `value4` VARCHAR(10), IN `value5` VARCHAR(10), IN `value6` VARCHAR(10))  NO SQL
BEGIN

select * from Clientes inner join ubicacionesPorCliente on Clientes.dni = ubicacionesPorCliente.dni where Circ = value1 and  seccion = value2 and  macizo = value3 and  parcela = value4 and  fila = value5 and  unidad = value6;

END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `buscarPalmerasAporUbi` (IN `value1` VARCHAR(10), IN `value2` VARCHAR(10))  NO SQL
BEGIN

select * from Clientes inner join ubicacionesPorCliente on Clientes.dni = ubicacionesPorCliente.dni where nicho = value1 and fila = value2;

END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `buscarPalmerasCporUbi` (IN `value1` VARCHAR(10), IN `value2` VARCHAR(10))  NO SQL
BEGIN

select * from Clientes inner join ubicacionesPorCliente on Clientes.dni = ubicacionesPorCliente.dni where nicho = value1 and fila = value2;

END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `buscarPalmerasRoporUbi` (IN `value1` VARCHAR(10), IN `value2` VARCHAR(10))  NO SQL
BEGIN

select * from Clientes inner join ubicacionesPorCliente on Clientes.dni = ubicacionesPorCliente.dni where nicho = value1 and fila = value2;

END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `buscarporApellidoNew` (IN `value1` VARCHAR(100))  NO SQL
begin 

select * from `Clientes` where `apellido`= value1;

END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `buscarporCocheria` (IN `value1` VARCHAR(100), IN `value2` VARCHAR(100))  NO SQL
BEGIN

SELECT * from `Clientes` WHERE `cocheria` = value1 and `direccion`= value2;

END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `buscarporDni` (IN `value1` VARCHAR(10))  NO SQL
BEGIN


SELECT * from `Clientes` WHERE `dni` = value1;


END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `buscarporDni2` (IN `value1` VARCHAR(10))  NO SQL
BEGIN


SELECT * from ubicacionesPorCliente WHERE ubicacionesPorCliente.dni_ocupante = value1;


END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `buscarporNombreyapellido` (IN `value1` VARCHAR(100), IN `value2` VARCHAR(100))  NO SQL
BEGIN

 

SELECT * from `Clientes` WHERE `apellido` = value1 and `nombres`= value2 ;

END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `buscarporTelefono` (IN `value1` VARCHAR(100))  NO SQL
BEGIN

SELECT * from `Clientes` WHERE `telefono_familiar` = value1;

END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `buscarUbicacionporNyA` (IN `value1` VARCHAR(100), IN `value2` VARCHAR(100))  NO SQL
BEGIN
declare 
var varchar (10);

set var=(select id_ubicacion from ubicacionesPorCliente inner join  Clientes on ubicacionesPorCliente.dni = Clientes.dni where Clientes.nombres = value1 and Clientes.apellido=value2);

if (var = '1') then 
select Circ, seccion, macizo, parcela, fila, unidad from ubicacionesPorCliente inner join  Clientes on ubicacionesPorCliente.dni = Clientes.dni where Clientes.nombres = value1 and Clientes.apellido=value2 ;

elseif (var = '2' ) then
select nicho, fila from ubicacionesPorCliente where ubicacionesPorCliente.dni = value1;
select deposito2 from ubicacionesPorCliente where ubicacionesPorCliente.dni = value1;

elseif (var = '3' ) then
select nicho, fila from ubicacionesPorCliente inner join  Clientes on ubicacionesPorCliente.dni = Clientes.dni where Clientes.nombres = value1 and Clientes.apellido=value2;

elseif (var = '4' ) then
select nicho, fila from ubicacionesPorCliente where dni = value1;

elseif (var = '5' ) then
select sepultura from ubicacionesPorCliente where dni = value1;

elseif (var= '6') then
select  Circ, seccion, macizo, parcela, bis, unidad from ubicacionesPorCliente where dni = value1;

elseif (var= '8' ) then
select seccion, macizo, sepultura, inhumacion from ubicacionesPorCliente where dni = value1;

elseif (var= '7' ) then
select seccion,macizo, bis_macizo, unidad, numero, bis from ubicacionesPorCliente where dni = value1;

elseif (var = '9' ) then
select  mueble, nicho from  ubicacionesPorCliente inner join  Clientes on ubicacionesPorCliente.dni = Clientes.dni where Clientes.nombres = value1 and Clientes.apellido=value2 ;

elseif (var = '10' ) then
select  osario from UbicacionesPorCliente where dni = value1;

elseif (var= '11' ) then
select otroCementerio from ubicacionesPorCliente where dni = value1;

else select deposito from ubicacionesPorCliente where ubicacionesPorCliente.dni = value1;
END IF;
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `buscarUbiporDNI` (IN `value2` INT(11))  NO SQL
BEGIN

select * from ubicacionesPorCliente where ubicacionesPorCliente.dni = value2;
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `busquedaUbicacionNewporDNI` (IN `value1` INT)  BEGIN
declare 
var varchar (9);

set var=(select id_ubicacion from ubicacionesPorCliente where ubicacionesPorCliente.dni = value1);

if (var = '1') then 
select Circ, seccion, macizo, parcela, fila, unidad from ubicacionesPorCliente where ubicacionesPorCliente.dni = value1;

elseif (var = '2' ) then
select nicho, fila from ubicacionesPorCliente where ubicacionesPorCliente.dni = value1;
select deposito2 from ubicacionesPorCliente where ubicacionesPorCliente.dni = value1;

elseif (var = '3' ) then
select id_ubicacion, nicho, fila from ubicacionesPorCliente where dni = value1;

elseif (var = '4' ) then
select nicho, fila from ubicacionesPorCliente where dni = value1;

elseif (var = '5' ) then
select sepultura from ubicacionesPorCliente where dni = value1;

elseif (var= '6') then
select  Circ, seccion, macizo, parcela, bis, unidad from ubicacionesPorCliente where dni = value1;

elseif (var= '8' ) then
select seccion, macizo, sepultura, inhumacion from ubicacionesPorCliente where dni = value1;

elseif (var= '7' ) then
select seccion,macizo, bis_macizo, unidad, numero, bis from ubicacionesPorCliente where dni = value1;

elseif (var = '9' ) then
select  mueble, nicho from ubicacionesPorCliente where dni = value1;

elseif (var = '10' ) then
select  osario from UbicacionesPorCliente where dni = value1;

elseif (var= '11' ) then
select otroCementerio from ubicacionesPorCliente where dni = value1;

else select deposito from ubicacionesPorCliente where ubicacionesPorCliente.dni = value1;
END IF;
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `crearusuario` (`value1` VARCHAR(100), `value2` VARCHAR(100), `value3` INT(11))  BEGIN

INSERT INTO `login`(`u_name`, `u_pass`, `u_tipo`) VALUES (value1,value2,value3);
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `insertarCodigo` (IN `value1` FLOAT(10), IN `value2` INT(11), IN `value3` VARCHAR(200))  NO SQL
BEGIN

insert into codigos (importe,id,descripcion) values (value1,value2,value3);

end$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `insertarNewBoveda` (IN `value1` VARCHAR(10), IN `value2` VARCHAR(10), IN `value3` VARCHAR(10), IN `value4` VARCHAR(10), IN `value5` VARCHAR(10), IN `value6` VARCHAR(10))  NO SQL
BEGIN


insert into ubicacionesPorCliente (ubicacionesPorCliente.dni, id_ubicacion,id_cliente,ubicacionesPorCliente.dni_ocupante, Circ, seccion, macizo, parcela, bis, unidad) values (ultimo_dni(), '6' ,ultima_ubicacion(),ultimo_dniOcupante(),value1,value2, value3, value4, value5, value6);


END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `insertarNewBovedaRE` (IN `value7` INT, IN `value1` INT, IN `value2` INT, IN `value3` INT, IN `value4` INT, IN `value5` INT, IN `value6` INT)  NO SQL
BEGIN
declare
var2 int(11);
declare
var int(11);
set var2=(select obtenerID(value7));
set var=(select obtenerDNI(value7));
insert into ubicacionesPorCliente (ubicacionesPorCliente.dni, id_ubicacion,id_cliente,ubicacionesPorCliente.dni_ocupante, Circ, seccion, macizo, parcela, bis, unidad) values (var, '6' ,var2,value7, value1,value2, value3, value4, value5, value6);


END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `insertarNewCenizario` (IN `value1` VARCHAR(10), IN `value2` VARCHAR(10))  NO SQL
BEGIN

insert into ubicacionesPorCliente (ubicacionesPorCliente.dni, id_ubicacion,id_cliente,ubicacionesPorCliente.dni_ocupante, mueble, nicho) values (ultimo_dni(), '9' ,ultima_ubicacion(),ultimo_dniOcupante(),value1,value2);
   
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `insertarNewCenizarioRE` (IN `value3` VARCHAR(11), IN `value1` VARCHAR(10), IN `value2` VARCHAR(10), IN `value4` VARCHAR(10))  NO SQL
BEGIN
declare
var2 int(11);
set var2=(select obtenerID(value3));
insert into ubicacionesPorCliente (ubicacionesPorCliente.dni, id_ubicacion,id_cliente,ubicacionesPorCliente.dni_ocupante, mueble, nicho) values (value3, '9' ,var2,value4,value1,value2);
   
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `insertarNewIndigente` (IN `value1` VARCHAR(10), IN `value2` VARCHAR(10), IN `value3` VARCHAR(10), IN `value4` VARCHAR(10))  NO SQL
BEGIN


insert into ubicacionesPorCliente (ubicacionesPorCliente.dni, id_ubicacion,id_cliente,ubicacionesPorCliente.dni_ocupante, seccion, macizo, sepultura, inhumacion) values (ultimo_dni(), '8' ,ultima_ubicacion(),ultimo_dniOcupante(),value1,value2,value3,value4);

END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `insertarNewIndigenteREP` (IN `value5` VARCHAR(10), IN `value1` VARCHAR(10), IN `value2` VARCHAR(10), IN `value3` VARCHAR(10), IN `value4` VARCHAR(10))  NO SQL
BEGIN
declare
var2 int(11);
set var2=(select obtenerID(value5));

insert into ubicacionesPorCliente (ubicacionesPorCliente.dni, id_ubicacion,id_cliente, seccion, macizo, sepultura, inhumacion) values (value5, '8' ,var2,value1,value2,value3,value4);

END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `insertarNewNichera` (IN `value1` VARCHAR(10), IN `value2` VARCHAR(10), IN `value3` VARCHAR(10), IN `value4` VARCHAR(10), IN `value5` VARCHAR(10), IN `value6` VARCHAR(10))  NO SQL
BEGIN


insert into ubicacionesPorCliente (ubicacionesPorCliente.dni, id_ubicacion,id_cliente,ubicacionesPorCliente.dni_ocupante, Circ, seccion, macizo, parcela, fila, unidad) values (ultimo_dni(), '1' ,ultima_ubicacion(),ultimo_dniOcupante(),value1,value2, value3, value4, value5, value6);


END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `insertarNewNicheraRE` (IN `value7` VARCHAR(10), IN `value1` VARCHAR(10), IN `value2` VARCHAR(10), IN `value3` VARCHAR(10), IN `value4` VARCHAR(10), IN `value5` VARCHAR(10), IN `value6` VARCHAR(10))  NO SQL
BEGIN

declare
var2 int(11);
set var2=(select obtenerID(value7));
insert into ubicacionesPorCliente (ubicacionesPorCliente.dni, id_ubicacion,id_cliente, Circ, seccion, macizo, parcela, fila, unidad) values (value7, '1' ,var2,value1,value2, value3, value4, value5, value6);


END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `insertarNewPalmerasA` (IN `value1` INT(11), IN `value2` INT(11))  NO SQL
BEGIN

insert into ubicacionesPorCliente ( ubicacionesPorCliente.dni, id_ubicacion,id_cliente, dni_ocupante, nicho, fila) values (ultimo_dni(), '2' ,ultima_ubicacion(),ultimo_dniOcupante(), value1,value2);
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `insertarNewPalmerasARE` (IN `value3` INT, IN `value1` INT, IN `value2` INT)  NO SQL
BEGIN
declare
var2 int(11);
set var2=(select obtenerID(value3));
insert into ubicacionesPorCliente ( ubicacionesPorCliente.dni, id_ubicacion,id_cliente, nicho, fila) values ( value3, '2' ,var2, value1,value2);
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `insertarNewPalmerasC` (IN `value1` VARCHAR(10), IN `value2` VARCHAR(10))  NO SQL
BEGIN

insert into ubicacionesPorCliente ( ubicacionesPorCliente.dni, id_ubicacion,id_cliente,ubicacionesPorCliente.dni_ocupante, nicho, fila) values (ultimo_dni(), '3' ,ultima_ubicacion(),ultimo_dniOcupante(), value1,value2);
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `insertarNewPalmerasCRE` (IN `value3` VARCHAR(10), IN `value1` VARCHAR(10), IN `value2` VARCHAR(10))  NO SQL
BEGIN
declare
var2 int(11);
set var2=(select obtenerID(value3));
insert into ubicacionesPorCliente ( ubicacionesPorCliente.dni, id_ubicacion,id_cliente, nicho, fila) values (value3, '3' ,var2, value1,value2);
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `insertarNewPalmerasRo` (IN `value1` VARCHAR(10), IN `value2` VARCHAR(10))  NO SQL
BEGIN

insert into ubicacionesPorCliente (ubicacionesPorCliente.dni, id_ubicacion,id_cliente,ubicacionesPorCliente.dni_ocupante, nicho, fila) values (ultimo_dni(), '4' ,ultima_ubicacion(),ultimo_dniOcupante(), value1,value2);
  
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `insertarNewPalmerasRoRE` (IN `value3` VARCHAR(10), IN `value1` VARCHAR(10), IN `value2` VARCHAR(10))  NO SQL
BEGIN
declare
var2 int(11);
set var2=(select obtenerID(value3));
insert into ubicacionesPorCliente ( ubicacionesPorCliente.dni, id_ubicacion,id_cliente, nicho, fila) values (value3, '4' ,var2, value1,value2);
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `insertarNewPalmerasSep` (IN `value1` VARCHAR(10))  NO SQL
BEGIN

insert into ubicacionesPorCliente (ubicacionesPorCliente.dni, id_ubicacion,id_cliente,ubicacionesPorCliente.dni_ocupante,sepultura) values (ultimo_dni(), '5' ,ultima_ubicacion(),ultimo_dniOcupante(), value1);

END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `insertarNewSepultura` (IN `value1` VARCHAR(10), IN `value2` VARCHAR(10), IN `value3` VARCHAR(10), IN `value4` VARCHAR(10), IN `value5` VARCHAR(10), IN `value6` VARCHAR(10))  NO SQL
BEGIN

insert into ubicacionesPorCliente (ubicacionesPorCliente.dni, id_ubicacion,id_cliente,ubicacionesPorCliente.dni_ocupante,seccion,macizo, bis_macizo, unidad, numero, bis) values (ultimo_dni(), '7' ,ultima_ubicacion(),ultimo_dniOcupante(), value1,value2, value3, value4, value5,value6);  
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `insertarNewSepulturaREP` (IN `value7` VARCHAR(10), IN `value1` VARCHAR(10), IN `value2` VARCHAR(10), IN `value3` VARCHAR(10), IN `value4` VARCHAR(10), IN `value5` VARCHAR(10), IN `value6` VARCHAR(10))  NO SQL
BEGIN
declare
var2 int(11);
set var2=(select obtenerID(value7));
insert into ubicacionesPorCliente (ubicacionesPorCliente.dni, id_ubicacion,id_cliente,seccion,macizo, bis_macizo, unidad, numero, bis) values (value7, '7' ,var2, value1,value2, value3, value4, value5,value6);  
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `insertarOsario` (IN `value1` VARCHAR(10))  NO SQL
BEGIN


insert into ubicacionesPorCliente (id_ubicacion,id_cliente,osario) values ('10' ,ultima_ubicacion(), value1);


END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `insertarPalmerasSepREP` (IN `value1` VARCHAR(10), IN `value2` VARCHAR(10))  NO SQL
BEGIN
declare
var2 int(11);
set var2=(select obtenerID(value1));
insert into ubicacionesPorCliente (ubicacionesPorCliente.dni, id_ubicacion,id_cliente, sepultura) values (value1, '5' ,var2, value2);
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `InsertarVencimiento` (IN `value1` DATE, IN `value2` INT(11))  NO SQL
BEGIN
 
insert into vencimientos (id_vencimientos,fecha) values(value2,value1);

END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `ModifCliente` (IN `value1` VARCHAR(100), IN `value2` VARCHAR(100), IN `value3` DATE, IN `value4` VARCHAR(100), IN `value5` VARCHAR(100), IN `value6` VARCHAR(100), IN `value7` VARCHAR(100), IN `value8` VARCHAR(100), IN `value9` VARCHAR(100), IN `value10` VARCHAR(100))  NO SQL
BEGIN
DECLARE
var varchar (10);
set var = (select obtenerID(value4));

UPDATE `Clientes` SET `apellido` = value1, `nombres` = value2, `fecha_fallecimiento` = value3, `direccion` = value5, `nombre_familiar` = value6, `telefono_familiar` = value7, `cocheria` = value8, `tipo_fallecimiento` = value9, `email_familiar` = value10 WHERE `Clientes`.`Num_cliente` = var AND `Clientes`.`dni` = value4;
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `modificarVencimiento` (IN `value1` INT(11), IN `value2` DATE)  NO SQL
BEGIN

UPDATE vencimientos
SET  fecha=value2 
WHERE id_vencimientos=value1;

END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `moverDeposito1` (IN `value1` VARCHAR(10))  NO SQL
BEGIN


insert into ubicacionesPorCliente (id_ubicacion,id_cliente,deposito1) values ('12' ,ultima_ubicacion(), value1);


END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `moverDeposito2` (IN `value1` VARCHAR(10))  NO SQL
BEGIN


insert into ubicacionesPorCliente (id_ubicacion,id_cliente,deposito2) values ('14' ,ultima_ubicacion(), value1);


END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `moverDeposito3` (IN `value1` VARCHAR(10))  NO SQL
BEGIN


insert into ubicacionesPorCliente (id_ubicacion,id_cliente,deposito2) values ('13' ,ultima_ubicacion(), value1);


END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `moverOtrocementerio` (IN `value1` VARCHAR(10))  NO SQL
BEGIN


insert into ubicacionesPorCliente (id_ubicacion,id_cliente, otroCementerio) values ('11' ,ultima_ubicacion(), value1);


END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `probando` (IN `value1` INT(11))  NO SQL
BEGIN
DECLARE 
var  varchar (10); 
DECLARE
vari varchar (10);
set var = (select obtenerDNI('5',value1));
set vari = (select obtenerID('5',value1));
INSERT INTO cuenta (monto,dni_cliente) values (vari,var);  
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `verificarNewBoveda` (IN `value1` VARCHAR(10), IN `value2` VARCHAR(10), IN `value3` VARCHAR(10), IN `value4` VARCHAR(10), IN `value5` VARCHAR(10), IN `value6` VARCHAR(10))  BEGIN
SELECT * from `ubicacionesPorCliente` WHERE Circ = value1 and  seccion = value2 and  macizo = value3 and parcela = value4 and  bis = value5 and  unidad=value6 and id_ubicacion = '6' ;
  
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `verificarNewCenizario` (IN `value1` VARCHAR(10), IN `value2` VARCHAR(10))  BEGIN
SELECT * from `ubicacionesPorCliente` WHERE mueble = value1  and nicho = value2 and id_ubicacion = '9' ;
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `verificarNewIndigentes` (IN `value1` INT, IN `value2` INT, IN `value3` INT, IN `value4` INT)  BEGIN

SELECT * from ubicacionesPorCliente WHERE seccion = value1 and  macizo = value2 and  sepultura = value3 and  inhumacion = value4 and id_ubicacion = '8' ;
 
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `verificarNewNichera` (IN `value1` VARCHAR(10), IN `value2` VARCHAR(10), IN `value3` VARCHAR(10), IN `value4` VARCHAR(10), IN `value5` VARCHAR(10), IN `value6` VARCHAR(10))  BEGIN
SELECT * from `ubicacionesPorCliente` WHERE  Circ = value1 and  seccion = value2 and  macizo = value3 and  parcela = value4 and  fila = value5 and  unidad = value6  and id_ubicacion = '1' ;
 
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `verificarNewPalmerasA` (IN `value1` INT(11), IN `value2` INT(11))  BEGIN
SELECT * from `ubicacionesPorCliente` WHERE `nicho` = value1  and `fila`= value2 and id_ubicacion = '2' ;
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `verificarNewPalmerasC` (IN `value1` INT(11), IN `value2` INT(11))  NO SQL
BEGIN
SELECT * from `ubicacionesPorCliente` WHERE `nicho` = value1  and `fila`= value2 and id_ubicacion = '3' ;
  
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `verificarNewPalmerasRo` (IN `value1` INT(11), IN `value2` INT(11))  BEGIN
SELECT * from `ubicacionesPorCliente` WHERE `nicho` = value1  and `fila`= value2 and id_ubicacion = '4' ;
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `verificarNewSepultura` (IN `value1` VARCHAR(10), IN `value2` VARCHAR(10), IN `value3` VARCHAR(10), IN `value4` VARCHAR(10), IN `value5` VARCHAR(10), IN `value6` VARCHAR(10))  BEGIN
SELECT * from ubicacionesPorCliente WHERE seccion = value1 and  macizo= value2 and  bis_macizo = value3 and  unidad = value4 and  numero = value5 and  bis = value6 and id_ubicacion = '7' ;
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` PROCEDURE `verificarPalmerasS` (IN `value` VARCHAR(10))  NO SQL
BEGIN

select * from ubicacionesPorCliente WHERE ubicacionesPorCliente.id_ubicacion = '5' and ubicacionesPorCliente.sepultura = value;
END$$

--
-- Funciones
--
CREATE DEFINER=`u147800277_ben`@`localhost` FUNCTION `id_cliente` (`value1` INT(11)) RETURNS INT(11) NO SQL
BEGIN
declare 
var int (11);

set var = (select Clientes.Num_cliente from Clientes where Clientes.dni = value1);
return var;
           
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` FUNCTION `obtenerDNI` (`value1` INT(11)) RETURNS INT(11) NO SQL
BEGIN
DECLARE 
var  int (10); 

set var = (SELECT ubicacionesPorCliente.dni from ubicacionesPorCliente WHERE ubicacionesPorCliente.dni_ocupante= value1);

return var;  
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` FUNCTION `obtenerDnioc` (`value` VARCHAR(10)) RETURNS INT(11) NO SQL
BEGIN
DECLARE 
var  varchar (10); 

set var = (SELECT Clientes.dni_ocupante from Clientes WHERE Clientes.dni = value2);

return var;  
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` FUNCTION `obtenerID` (`value2` VARCHAR(10)) RETURNS INT(11) NO SQL
BEGIN
DECLARE 
var  varchar (10); 

set var = (SELECT Clientes.Num_cliente from Clientes WHERE Clientes.dni = value2);

return var;  
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` FUNCTION `passCorrecto` (`value1` VARCHAR(100), `value2` VARCHAR(100)) RETURNS BIT(1) BEGIN
DECLARE 

var  varchar (100); 
set var = (SELECT `u_name` from `login` WHERE  `u_pass` = value2);
IF (var  =  value1)  then 
RETURN 1;
ELSE
RETURN 0;
END IF;
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` FUNCTION `retorna_idUbicacion` (`value1` VARCHAR(100), `value2` VARCHAR(100)) RETURNS INT(10) NO SQL
BEGIN
declare 
var int (11);

set var = (select id_ubicacion from ubicacionesPorCliente inner join  Clientes on ubicacionesPorCliente.dni = Clientes.dni where Clientes.nombres = value1 and Clientes.apellido=value2);
return var;
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` FUNCTION `ultima_ubicacion` () RETURNS INT(11) NO SQL
BEGIN
DECLARE
var int(11);
set var = (SELECT max(Num_cliente) from Clientes);

RETURN var;
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` FUNCTION `ultimo_dni` () RETURNS INT(11) NO SQL
BEGIN
DECLARE
var int(11);
set var = (SELECT Clientes.dni from Clientes where Clientes.Num_cliente = ultima_ubicacion());

RETURN var;
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` FUNCTION `ultimo_dniOcupante` () RETURNS INT(11) NO SQL
BEGIN
DECLARE
var int(11);
set var = (SELECT Clientes.dni_ocupante from Clientes where Clientes.Num_cliente = ultima_ubicacion());

RETURN var;
END$$

CREATE DEFINER=`u147800277_ben`@`localhost` FUNCTION `verificarID` (`value` VARCHAR(10)) RETURNS INT(11) NO SQL
BEGIN
DECLARE 
var  varchar (10); 
DECLARE 
vari int (11);
set var = (SELECT Clientes.Num_cliente from Clientes WHERE Clientes.dni = value );
set vari = (select ultima_ubicacion());
if (var is not null AND var != vari ) THEN
return 1;
else 
return 0;
end if;   
END$$

DELIMITER ;



-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Clientes`
--

CREATE TABLE `Clientes` (
  `Num_cliente` int(11) NOT NULL,
  `apellido` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `nombres` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `fecha_fallecimiento` date NOT NULL,
  `dni` int(11) NOT NULL,
  `direccion` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nombre_familiar` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telefono_familiar` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cocheria` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `tipo_fallecimiento` tinyint(1) DEFAULT NULL COMMENT '1 si no es traumatico, 0 si es',
  `email_familiar` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dni_ocupante` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


--
-- Disparadores `Clientes`
--
DELIMITER $$
CREATE TRIGGER `ActualizarUbicaciones` BEFORE UPDATE ON `Clientes` FOR EACH ROW BEGIN
DECLARE
var varchar (10);
set var = (select obtenerID(new.dni));

UPDATE `ubicacionesPorCliente` SET `dni` = new.dni  WHERE ubicacionesPorCliente.id_cliente = var;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `codigos`
--

CREATE TABLE `codigos` (
  `id` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `descripcion` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `importe` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta`
--

CREATE TABLE `cuenta` (
  `id_cuenta` int(11) NOT NULL,
  `monto` int(11) NOT NULL,
  `dni_cliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `login`
--

CREATE TABLE `login` (
  `u_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `u_pass` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `u_tipo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ubicacionesPorCliente`
--

CREATE TABLE `ubicacionesPorCliente` (
  `id_cliente` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `id_ubicacion` int(11) NOT NULL,
  `deposito` tinyint(1) DEFAULT NULL,
  `otrocementerio` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `osario` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nicho` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fila` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `seccion` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `macizo` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `unidad` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `bis` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `bis_macizo` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `numero` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sepultura` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `parcela` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mueble` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `inhumacion` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Circ` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dni_ocupante` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;




-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ubic_maestro`
--

CREATE TABLE `ubic_maestro` (
  `id_ubicacion` int(11) NOT NULL,
  `descripcion` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `ubic_maestro`
--

INSERT INTO `ubic_maestro` (`id_ubicacion`, `descripcion`) VALUES
(1, 'nichera '),
(2, 'palmeras_a'),
(3, 'palmeras_c'),
(4, 'palmeras_ro'),
(5, 'palmeras_S'),
(6, 'boveda'),
(7, 'sepultura'),
(8, 'indigente'),
(9, 'cenizario'),
(10, 'osario'),
(11, 'otroCementerio'),
(12, 'deposito1'),
(13, 'deposito3'),
(14, 'deposito2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vencimientos`
--

CREATE TABLE `vencimientos` (
  `id_vencimientos` int(11) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Acumulador`
--
ALTER TABLE `Acumulador`
  ADD PRIMARY KEY (`acum_id`);

--
-- Indices de la tabla `Clientes`
--
ALTER TABLE `Clientes`
  ADD PRIMARY KEY (`Num_cliente`) USING BTREE,
  ADD UNIQUE KEY `dni` (`dni`),
  ADD UNIQUE KEY `dni_cementerio` (`dni_ocupante`);

--
-- Indices de la tabla `codigos`
--
ALTER TABLE `codigos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `cuenta`
--
ALTER TABLE `cuenta`
  ADD PRIMARY KEY (`id_cuenta`);

--
-- Indices de la tabla `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`u_name`,`u_pass`);

--
-- Indices de la tabla `ubicacionesPorCliente`
--
ALTER TABLE `ubicacionesPorCliente`
  ADD UNIQUE KEY `dni_cementerio` (`dni_ocupante`),
  ADD KEY `dni` (`dni`),
  ADD KEY `id_cliente` (`id_cliente`),
  ADD KEY `id_ubicacion` (`id_ubicacion`);

--
-- Indices de la tabla `ubic_maestro`
--
ALTER TABLE `ubic_maestro`
  ADD PRIMARY KEY (`id_ubicacion`);

--
-- Indices de la tabla `vencimientos`
--
ALTER TABLE `vencimientos`
  ADD PRIMARY KEY (`id_vencimientos`);



ALTER TABLE `ubicacionesPorCliente`
  ADD CONSTRAINT `ubicacionesPorCliente_ibfk_1` FOREIGN KEY (`dni_ocupante`) REFERENCES `Clientes` (`dni_ocupante`),
  ADD CONSTRAINT `ubicacionesPorCliente_ibfk_2` FOREIGN KEY (`dni`) REFERENCES `Clientes` (`dni`),
  ADD CONSTRAINT `ubicacionesPorCliente_ibfk_3` FOREIGN KEY (`id_cliente`) REFERENCES `Clientes` (`Num_cliente`),
  ADD CONSTRAINT `ubicacionesPorCliente_ibfk_4` FOREIGN KEY (`id_ubicacion`) REFERENCES `ubic_maestro` (`id_ubicacion`);
COMMIT;


