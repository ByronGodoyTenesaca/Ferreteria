-- Generado por Oracle SQL Developer Data Modeler 19.2.0.182.1216
--   en:        2020-01-06 18:55:15 COT
--   sitio:      Oracle Database 12c
--   tipo:      Oracle Database 12c



CREATE TABLE fer_cargos (
    car_codigo   NUMBER(5) NOT NULL,
    car_cargo    VARCHAR2(50) NOT NULL
);

COMMENT ON COLUMN fer_cargos.car_cargo IS
    'el cargo que puede ocupar los empleados ejemplo Cajero';

ALTER TABLE fer_cargos ADD CONSTRAINT cargo_pk PRIMARY KEY ( car_codigo );



CREATE TABLE fer_categorias (
    cat_codigo   NUMBER(5) NOT NULL,
    cat_nombre   VARCHAR2(50) NOT NULL
);

COMMENT ON COLUMN fer_categorias.cat_nombre IS
    'nombre de la categoria que se tiene del producto ejemplo decorado';

ALTER TABLE fer_categorias ADD CONSTRAINT fer_categoria_pk PRIMARY KEY ( cat_codigo );


CREATE TABLE fer_clientes (
    cli_codigo             NUMBER(5) NOT NULL,
    cli_nombre             VARCHAR2(50) NOT NULL,
    cli_apellido           VARCHAR2(50) NOT NULL,
    cli_direccion          VARCHAR2(50) NOT NULL,
    cli_cedula             VARCHAR2(10) NOT NULL,
    cli_email              VARCHAR2(100) NOT NULL,
    cli_num_tarjeta        VARCHAR2(15),
    cli_genero             VARCHAR2(20) NOT NULL,
    cli_telefono           VARCHAR2(10) NOT NULL,
    profesion_pro_codigo   NUMBER(5) NOT NULL
);

COMMENT ON COLUMN fer_clientes.cli_nombre IS
    'nombre del cliente ejemplo ivan';

COMMENT ON COLUMN fer_clientes.cli_apellido IS
    'apellido del cliente ejemplo Sanchez';

COMMENT ON COLUMN fer_clientes.cli_direccion IS
    'direccion en donde vive el cliente ejemplo baños';

COMMENT ON COLUMN fer_clientes.cli_cedula IS
    'cedula o ruc del cliente ejemplo 0120115782';

COMMENT ON COLUMN fer_clientes.cli_email IS
    'correo electronico del cliente ejemplo ivan@hotmail.com';

COMMENT ON COLUMN fer_clientes.cli_num_tarjeta IS
    'el numero de la tajeta de credito este campo es opcional ya que todos los clientes no possen tarjeta de credito ejemplo 0255221255221'
    ;

COMMENT ON COLUMN fer_clientes.cli_genero IS
    'registra el genero que tiene el cliente ejemplo Masculino';

COMMENT ON COLUMN fer_clientes.cli_telefono IS
    'el numero de telefono o celular del cliente ejemplo 096878441';

ALTER TABLE fer_clientes ADD CONSTRAINT fer_cliente_pk PRIMARY KEY ( cli_codigo );



CREATE TABLE fer_empleados (
    emp_codigo         NUMBER(5) NOT NULL,
    emp_nombre         VARCHAR2(50) NOT NULL,
    emp_apellido       VARCHAR2(50) NOT NULL,
    emp_direccion      VARCHAR2(100) NOT NULL,
    emp_cedula         VARCHAR2(10) NOT NULL,
    emp_email          VARCHAR2(100) NOT NULL,
    emp_contraseña     VARCHAR2(50) NOT NULL,
    emp_genero         VARCHAR2(15) NOT NULL,
    emp_telefono       VARCHAR2(10) NOT NULL,
    cargo_car_codigo   NUMBER(5) NOT NULL
);

COMMENT ON COLUMN fer_empleados.emp_nombre IS
    'nombre del empleado ejemplo Rolando';

COMMENT ON COLUMN fer_empleados.emp_apellido IS
    'apellido del empleado ejemplo Calle';

COMMENT ON COLUMN fer_empleados.emp_direccion IS
    'direccion en donde vive el empleado ejemplo Ricaurte';

COMMENT ON COLUMN fer_empleados.emp_cedula IS
    'numero de cedula del empleado ejemplo 0258741369';

COMMENT ON COLUMN fer_empleados.emp_email IS
    'correo electronico del empleado el cual tambien servira como login ejemplo rolando@gmail.com';

COMMENT ON COLUMN fer_empleados.emp_contraseña IS
    'la contraseña del empleado al momento del login ejemplo Rc123';

COMMENT ON COLUMN fer_empleados.emp_genero IS
    'genero del empleado ejemplo Masculino';

COMMENT ON COLUMN fer_empleados.emp_telefono IS
    'el numero de telefono del trabajador ejemplo 0968718441';

ALTER TABLE fer_empleados ADD CONSTRAINT fer_empleado_pk PRIMARY KEY ( emp_codigo );


CREATE TABLE fer_factura_detalles (
    fac_det_codigo            NUMBER(5) NOT NULL,
    fac_det_cantidad          NUMBER(10) NOT NULL,
    fac_det_precio_uni        NUMBER(10, 2) NOT NULL,
    fac_det_precio_total      NUMBER(10, 2) NOT NULL,
    fer_factura_fac_codigo    NUMBER(5) ,
    fer_producto_pro_codigo   NUMBER(5) NOT NULL
);

COMMENT ON COLUMN fer_factura_detalles.fac_det_cantidad IS
    'la cantidad de productos que se va a realizar la compra ejemplo 5';

COMMENT ON COLUMN fer_factura_detalles.fac_det_precio_uni IS
    'el precio del producto de forma individual ejemplo 12.20';

COMMENT ON COLUMN fer_factura_detalles.fac_det_precio_total IS
    'el precio total que se va a cancelar por los productos ejemplo 30.20';


ALTER TABLE fer_factura_detalles ADD CONSTRAINT fer_factura_detalle_pk PRIMARY KEY ( fac_det_codigo );



CREATE TABLE fer_facturas (
    fac_codigo                NUMBER(5) NOT NULL,
    fac_fecha                 DATE NOT NULL,
    fac_subtotal              NUMBER(10, 2) NOT NULL,
    fac_descuento             NUMBER(10, 2) NOT NULL,
    fac_iva                   NUMBER(5, 2) NOT NULL,
    fac_total                 NUMBER(10, 2) NOT NULL,
    fac_forma_pago            VARCHAR2(50) NOT NULL,
    fer_cliente_cli_codigo    NUMBER(5) NOT NULL,
    fer_empleado_emp_codigo   NUMBER(5) NOT NULL
);

COMMENT ON COLUMN fer_facturas.fac_fecha IS
    'la fecha en la que se realiza la factura ejemplo 23/12/2019';

COMMENT ON COLUMN fer_facturas.fac_subtotal IS
    'el subtotal del costo de los productos ejemplo 20.15';

COMMENT ON COLUMN fer_facturas.fac_descuento IS
    'el descuento que se le asigna dependiendo del tipo de cliente ejemplo 1.12';

COMMENT ON COLUMN fer_facturas.fac_iva IS
    'el total del iva que poseen algunos productos ejemplo 0.45';

COMMENT ON COLUMN fer_facturas.fac_total IS
    'el total a cancelar de la factura ejemplo 20.25';

COMMENT ON COLUMN fer_facturas.fac_forma_pago IS
    'sirve para saber el modo de pago que se va a realizar ejemplo contado o tarjeta de credito';

ALTER TABLE fer_facturas ADD CONSTRAINT fer_factura_pk PRIMARY KEY ( fac_codigo );



CREATE TABLE fer_producto_proveedores (
    prod_pro_id                 NUMBER(5) NOT NULL,
    prod_prov_cantidad          NUMBER(10, 2) NOT NULL,
    fer_proveedor_prov_codigo   NUMBER(5) NOT NULL,
    fer_producto_pro_codigo     NUMBER(5) NOT NULL
);

COMMENT ON COLUMN fer_producto_proveedores.prod_prov_cantidad IS
    'la cantidad que provee el proveedor ejemplo 5';

ALTER TABLE fer_producto_proveedores ADD CONSTRAINT fer_producto_proveedor_pk PRIMARY KEY ( prod_pro_id );



CREATE TABLE fer_productos (
    pro_codigo                   NUMBER(5) NOT NULL,
    pro_nombre                   VARCHAR2(50) NOT NULL,
    pro_descripcion              VARCHAR2(200) NOT NULL,
    pro_costo_venta              NUMBER(10, 2) NOT NULL,
    pro_costo_compra             NUMBER(10, 2) NOT NULL,
    pro_cantidad                 NUMBER(5) NOT NULL,
    pro_lugar_fabricacion        VARCHAR2(50) NOT NULL,
    pro_iva                      NUMBER NOT NULL,
    fer_categoria_cat_codigo     NUMBER(5) NOT NULL,
    fer_tipo_medida_med_codigo   NUMBER(5) NOT NULL
);

COMMENT ON COLUMN fer_productos.pro_nombre IS
    'el nombre del producto ejemplo Serrucho';

COMMENT ON COLUMN fer_productos.pro_descripcion IS
    'la descripcion del producto por ejemplo dientes de acero';

COMMENT ON COLUMN fer_productos.pro_costo_venta IS
    'el precio de venta al publico ejemplo 12.23';

COMMENT ON COLUMN fer_productos.pro_costo_compra IS
    'precio en el que se compro el producto ejemplo 12.50';

COMMENT ON COLUMN fer_productos.pro_cantidad IS
    'la cantidad que se tiene del stock';

COMMENT ON COLUMN fer_productos.pro_lugar_fabricacion IS
    'lugar de fabricacion ejemplo nacional o extranjero';

COMMENT ON COLUMN fer_productos.pro_iva IS
    'true si tiene iva el producto
false si no tiene iva el producto';

ALTER TABLE fer_productos ADD CONSTRAINT fer_producto_pk PRIMARY KEY ( pro_codigo );



CREATE TABLE fer_profesiones (
    pro_codigo      NUMBER(5) NOT NULL,
    pro_profesion   VARCHAR2(50) NOT NULL,
    pro_descuento   NUMBER(5, 2) NOT NULL
);

COMMENT ON COLUMN fer_profesiones.pro_profesion IS
    'profesion que puede tener los clientes ejemplo Arquitecto';

COMMENT ON COLUMN fer_profesiones.pro_descuento IS
    'el descuento que posee dicha profesion a momento de las compras ';

ALTER TABLE fer_profesiones ADD CONSTRAINT profesion_pk PRIMARY KEY ( pro_codigo );

CREATE TABLE fer_proveedores (
    prov_codigo      NUMBER(5) NOT NULL,
    prov_empresa     VARCHAR2(50) NOT NULL,
    prov_direccion   VARCHAR2(50) NOT NULL,
    prov_telefono    VARCHAR2(10) NOT NULL,
    porv_nombre      VARCHAR2(50) NOT NULL,
    prov_apellido    VARCHAR2(50) NOT NULL,
    prov_cedula      VARCHAR2(10) NOT NULL,
    prov_email       VARCHAR2(100) NOT NULL,
    prov_genero      VARCHAR2(15) NOT NULL
);

COMMENT ON COLUMN fer_proveedores.prov_empresa IS
    'el nombre de la empresa que entrega los productos ejemplo Bellota';

COMMENT ON COLUMN fer_proveedores.prov_direccion IS
    'direccion del proveedor ejemplo Ordoñes laso';

COMMENT ON COLUMN fer_proveedores.prov_telefono IS
    'el telefono del proveedor ejemplo 2521255';

COMMENT ON COLUMN fer_proveedores.porv_nombre IS
    'el nombre de la persona que trabaja con el proveedor ejemplo Juan';

COMMENT ON COLUMN fer_proveedores.prov_apellido IS
    'apellido de la persona que tabaja con el proveedor ejemplo Perez';

COMMENT ON COLUMN fer_proveedores.prov_cedula IS
    'la cedula del trabajador del proveedor ejemplo 2012354894';

COMMENT ON COLUMN fer_proveedores.prov_email IS
    'el correo electronico del trabajador que provee';

COMMENT ON COLUMN fer_proveedores.prov_genero IS
    'el genero del proveedor ejemplo Masculino';

ALTER TABLE fer_proveedores ADD CONSTRAINT fer_proveedor_pk PRIMARY KEY ( prov_codigo );



CREATE TABLE fer_tipo_medidas (
    med_codigo   NUMBER(5) NOT NULL,
    med_nombre   VARCHAR2(25) NOT NULL
);

COMMENT ON COLUMN fer_tipo_medidas.med_nombre IS
    'nombre del tipo de medida que se tiene ejemplo Libras al ser en clavos o metros al ser sogas';

ALTER TABLE fer_tipo_medidas ADD CONSTRAINT fer_tipo_medida_pk PRIMARY KEY ( med_codigo );



ALTER TABLE fer_clientes
    ADD CONSTRAINT fer_cliente_profesion_fk FOREIGN KEY ( profesion_pro_codigo )
        REFERENCES fer_profesiones ( pro_codigo );

ALTER TABLE fer_empleados
    ADD CONSTRAINT fer_empleado_cargo_fk FOREIGN KEY ( cargo_car_codigo )
        REFERENCES fer_cargos ( car_codigo );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE fer_factura_detalles
    ADD CONSTRAINT fer_fac_det_fer_fac_fk FOREIGN KEY ( fer_factura_fac_codigo )
        REFERENCES fer_facturas ( fac_codigo );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE fer_factura_detalles
    ADD CONSTRAINT fer_fac_det_fer_prod_fk FOREIGN KEY ( fer_producto_pro_codigo )
        REFERENCES fer_productos ( pro_codigo );

ALTER TABLE fer_facturas
    ADD CONSTRAINT fer_factura_fer_cliente_fk FOREIGN KEY ( fer_cliente_cli_codigo )
        REFERENCES fer_clientes ( cli_codigo );

ALTER TABLE fer_facturas
    ADD CONSTRAINT fer_factura_fer_empleado_fk FOREIGN KEY ( fer_empleado_emp_codigo )
        REFERENCES fer_empleados ( emp_codigo );

ALTER TABLE fer_productos
    ADD CONSTRAINT fer_pro_fer_cat_fk FOREIGN KEY ( fer_categoria_cat_codigo )
        REFERENCES fer_categorias ( cat_codigo );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE fer_productos
    ADD CONSTRAINT fer_pro_fer_tipmed_fk FOREIGN KEY ( fer_tipo_medida_med_codigo )
        REFERENCES fer_tipo_medidas ( med_codigo );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE fer_producto_proveedores
    ADD CONSTRAINT fer_prod_prov_fer_prod_fk FOREIGN KEY ( fer_producto_pro_codigo )
        REFERENCES fer_productos ( pro_codigo );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE fer_producto_proveedores
    ADD CONSTRAINT fer_prodprov_fer_prov_fk FOREIGN KEY ( fer_proveedor_prov_codigo )
        REFERENCES fer_proveedores ( prov_codigo );



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            11
-- CREATE INDEX                             0
-- ALTER TABLE                             21
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- TSDP POLICY                              0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   5
-- WARNINGS                                 0

commit;



