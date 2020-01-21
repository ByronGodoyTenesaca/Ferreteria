insert into FER_PROFESIONES values (1,'Ingeniero',2.5);
insert into FER_CARGOS values (1,'Gerente'); 
insert into FER_EMPLEADOS values (4,'Byron','Godoy','Ricaurte','0107377021','byron1@hotmail.com','byron','masculino','4077632',1);
commit;

select * from FER_CLIENTES;
SELECT * FROM FER_CLIENTES WHERE CLI_CEDULA = '0107377020';
select max(CLI_CODIGO)+1 as id from FER_CLIENTES;
commit;

SELECT * FROM FER_CLIENTES WHERE CLI_CEDULA = '0107128100';

SELECT CLI_CODIGO,CLI_NOMBRE,CLI_APELLIDO,CLI_DIRECCION,CLI_CEDULA,CLI_EMAIL,CLI_NUM_TARJETA,
CLI_GENERO,CLI_TELEFONO,PRO_PROFESION
FROM FER_CLIENTES C, FER_PROFESIONES P
WHERE C.PROFESION_PRO_CODIGO=P.PRO_CODIGO AND P.PRO_PROFESION='Ingeniero';


SELECT CLI_CODIGO,CLI_NOMBRE,CLI_APELLIDO,CLI_DIRECCION,CLI_CEDULA,
CLI_EMAIL,CLI_NUM_TARJETA,CLI_GENERO,CLI_TELEFONO,PRO_PROFESION 
FROM FER_CLIENTES C, FER_PROFESIONES P WHERE C.CLI_NOMBRE LIKE 'Byron%' 
AND C.PROFESION_PRO_CODIGO=P.PRO_CODIGO;

-------------  SENTENCIA PARA SACAR LOS PRODUCTOS POR LA EMPRESA---------
SELECT PRO_CODIGO,PRO_NOMBRE,PRO_DESCRIPCION,PRO_COSTO_VENTA,
PRO_COSTO_COMPRA,PRO_CANTIDAD,PRO_LUGAR_FABRICACION,PRO_IVA,FER_CATEGORIA_CAT_CODIGO,
FER_TIPO_MEDIDA_MED_CODIGO
FROM FER_PRODUCTOS P,FER_PROVEEDORES PR,FER_PRODUCTO_PROVEEDORES PP
WHERE PR.PROV_EMPRESA LIKE 'Bellota%' AND PR.PROV_CODIGO=PP.FER_PROVEEDOR_PROV_CODIGO
AND P.PRO_CODIGO=PP.FER_PRODUCTO_PRO_CODIGO
UNION
SELECT PRO_CODIGO,PRO_NOMBRE,PRO_DESCRIPCION,PRO_COSTO_VENTA,
PRO_COSTO_COMPRA,PRO_CANTIDAD,PRO_LUGAR_FABRICACION,PRO_IVA,FER_CATEGORIA_CAT_CODIGO,
FER_TIPO_MEDIDA_MED_CODIGO FROM FER_PRODUCTOS;


SELECT PRO_CODIGO,PRO_NOMBRE,PRO_DESCRIPCION,PRO_COSTO_VENTA,PRO_COSTO_COMPRA,PRO_CANTIDAD,PRO_LUGAR_FABRICACION,PRO_IVA,FER_CATEGORIA_CAT_CODIGO,FER_TIPO_MEDIDA_MED_CODIGO FROM FER_PRODUCTOS P,FER_PROVEEDORES PR,FER_PRODUCTO_PROVEEDORES PP 
WHERE PR.PROV_EMPRESA LIKE 'Be%' and PR.PROV_CODIGO=PP.FER_PROVEEDOR_PROV_CODIGO AND P.PRO_CODIGO=PP.FER_PRODUCTO_PRO_CODIGO UNION SELECT PRO_CODIGO,PRO_NOMBRE,PRO_DESCRIPCION,PRO_COSTO_VENTA,PRO_COSTO_COMPRA,PRO_CANTIDAD,PRO_LUGAR_FABRICACION,PRO_IVA,FER_CATEGORIA_CAT_CODIGO,FER_TIPO_MEDIDA_MED_CODIGO FROM FER_PRODUCTOS;

select * from FER_PROFESIONES;
select * from FER_CATEGORIAS;
select * from FER_TIPO_MEDIDAS;
select * from FER_PROVEEDORES;
select * from FER_PRODUCTOS
ORDER BY 1;
SELECT * FROM FER_PRODUCTO_PROVEEDORES;
SELECT * FROM FER_CARGOS;
select* from FER_FACTURAS;

FER_PROD_PROV_FER_PROD_FK;


insert into FER_PRODUCTO_PROVEEDORES VALUES (FER_pRODUCTO_PROVEEDORES_SEQ.NEXTVAL,15,1,1);

insert into FER_PRODUCTO_PROVEEDORES VALUES (FER_pRODUCTO_PROVEEDORES_SEQ.NEXTVAL,20,1,2);
insert into FER_PRODUCTO_PROVEEDORES VALUES (FER_pRODUCTO_PROVEEDORES_SEQ.NEXTVAL,26,2,3);
insert into FER_PRODUCTO_PROVEEDORES VALUES (FER_pRODUCTO_PROVEEDORES_SEQ.NEXTVAL,15,2,4);
insert into FER_PRODUCTO_PROVEEDORES VALUES (FER_pRODUCTO_PROVEEDORES_SEQ.NEXTVAL,5,1,5);

commit;

delete from FER_PRODUCTO_PROVEEDORES where FER_PRODUCTO_PRO_CODIGO = 3;
delete from FER_PRODUCTOS where PRO_CODIGO = 3;

select * from fer_empleados;
SELECT * FROM FER_EMPLEADOS WHERE EMP_CEDULA='0479852314';
SELECT * FROM FER_EMPLEADOS WHERE EMP_NOMBRE LIKE 'Jo%';

select nvl(max(FAC_CODIGO),0) from FER_FACTURAS;