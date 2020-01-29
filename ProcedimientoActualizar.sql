create or replace procedure actualizar(var_pro_codigo in FER_PRODUCTOS.PRO_CODIGO%type,
                                       var_pro_cantidad in FER_PRODUCTOS.PRO_CANTIDAD%type)
                    
is

begin 
update fer_productos
set pro_cantidad =pro_cantidad-var_pro_cantidad
where pro_codigo=var_pro_codigo;

end actualizar;