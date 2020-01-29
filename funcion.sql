create or replace function obtener_ganancias(var_fecha VARCHAR2)
return number is

var_ganancias number; 
begin

select sum(fac_total)
into var_ganancias
from fer_facturas
where fac_fecha=var_fecha;

return var_ganancias;

end obtener_ganancias;