create or replace trigger tr_fer_act_pro

after insert or update on FER_FACTURA_DETALLES

declare 
var_codigo numeric;
var_cantidad numeric;
var_cod_detfactura numeric;

begin

select max(fac_det_codigo)
into var_cod_detfactura
from FER_FACTURA_DETALLES;


select FER_PRODUCTO_PRO_CODIGO
into var_codigo
from FER_FACTURA_DETALLES
where FAC_DET_CODIGO=var_cod_detfactura;

select FAC_DET_CANTIDAD
into var_cantidad
from FER_FACTURA_DETALLES
where FAC_DET_CODIGO=var_cod_detfactura;

 actualizar(var_codigo,var_cantidad);
  
end tr_fer_act_pro; 