-- restriccion unique en la tabla FER_CLIENTES en el campo CLI_CEDULA
alter table FER_CLIENTES 
add constraint restriccion_unique_cliente
unique (CLI_CEDULA);

-- restriccion unique en la tabla FER_EMPLEADOS en el campo EMP_CEDULA
alter table FER_EMPLEADOS 
add constraint restriccion_unique_empleado
unique (EMP_CEDULA);


-- restriccion check para que los productos no tenga stock negativos
alter table FER_PRODUCTOS
add constraint restriccion_check_productos
check (PRO_CANTIDAD >=0);   
-- para eliminar una restriccion----------
alter table FER_PRODUCTOS
drop constraint restriccion_check_productos;

-- restriccion check para la verificacion de los productos si son extranjeros o nacionales
alter table FER_PRODUCTOS
add constraint restriccion_check_productos1
check (PRO_LUGAR_FABRICACION ='Nacional' or PRO_LUGAR_FABRICACION ='Extranjero');

select * from fer_factura_detalles;
select * from fer_productos;
select * from fer_facturas;
select * from FER_AUDITORIA_PRODUCTOS;
select * from FER_AUDITORIA_FACTURAS;
select * from FER_AUDITORIA_DETALLE_FACTURA;

----------------------------- comprovacion de trabajo------------------------------
insert into FER_FACTURA_DETALLES values(FER_FACTURA_DETALLES_SEQ.nextval,1,30,30,15,13);

select To_char(obtener_ganancias('24-ENE-20'),'L9999,999.99')
from dual;

-- tablas para las auditorias de productos, factura y detalle dactura
-- tabla de auditoria de productos
create table FER_AUDITORIA_PRODUCTOS(
new_pro_codigo number(5,0),
new_pro_nombre varchar2(100),
new_pro_descripcion varchar2(100),
old_pro_codigo number(5,0),
old_pro_nombre varchar2(100),
old_pro_descripcion varchar2(100),
aud_pro_fecha TIMESTAMP,
aud_pro_usuario varchar2(50),
aud_pro_host varchar2(100));

-- comprivacion de la auditoria
update FER_PRODUCTOS set PRO_DESCRIPCION='martillo con cabeza de acero dura'
where pro_codigo=10;

-- tabla de auditorias de factura
create table FER_AUDITORIA_FACTURAS(
new_fac_codigo number(5,0),
new_fac_estado number(1),
new_fac_descuento number(7,2),
new_fac_total number(7,2),
old_fac_codigo number(5,0),
old_fac_estado number(1),
old_fac_descuento number(7,2),
old_fac_total number(7,2),
aud_fac_fecha TIMESTAMP,
aud_fac_usuario varchar2(50),
aud_fac_host varchar2(100));
---- comprovacion de la auditoria
update FER_FACTURAS set fac_total=35
where fac_codigo=9;

-- tabla de auditoria de detallefactura
create table FER_AUDITORIA_DETALLE_FACTURA(
new_fac_det_codigo number(5,0),
new_fac_det_precio_total number(7,2),
new_fac_det_cantidad number(5),
new_fac_det_codigo_producto number(5,0),
old_fac_det_codigo number(5,0),
old_fac_det_precio_total number(7,2),
old_fac_det_cantidad number(5),
old_fac_det_codigo_producto number(5,0),
aud_det_fac_fecha TIMESTAMP,
aud_det_fac_usuario varchar2(50),
aud_det_fac_host varchar2(100));
-- coprovacion de la auditoria
update FER_FACTURA_DETALLES set FER_FACTURA_FAC_CODIGO =14 
where FAC_DET_CODIGO=31;
select * from fer_factura_detalles;


-- consulta para reportes del mes------
select p.pro_nombre,sum(fac_det_cantidad),fac_det_precio_uni,p.PRO_IVA,sum(fd.fac_det_precio_total)
from fer_factura_detalles fd,fer_productos p,fer_facturas f
where f.fac_fecha >='24-ENE-20' and f.fac_fecha<='25-ENE-20' and p.pro_codigo=fd.FER_PRODUCTO_PRO_CODIGO
and fd.FER_FACTURA_FAC_CODIGO=f.FAC_CODIGO
group by p.pro_nombre,fac_det_precio_uni,p.PRO_IVA,fac_det_precio_total;


-- saber los tres primeros productos vendidos en el mes
