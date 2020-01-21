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
check (PRO_CANTIDAD >0);
-- para eliminar una restriccion----------
alter table NOMBRETABLA
drop constraint NOMBRERESTRICCION;

-- restriccion check para la verificacion de los productos si son extranjeros o nacionales
alter table FER_PRODUCTOS
add constraint restriccion_check_productos1
check (PRO_LUGAR_FABRICACION ='Nacional' or PRO_LUGAR_FABRICACION ='Extranjero');