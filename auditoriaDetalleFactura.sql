create or replace trigger tr_fer_audit_fac_det

before insert or UPDATE or delete on FER_FACTURA_DETALLES

for each row

begin

    insert into FER_AUDITORIA_DETALLE_FACTURA values(
    :new.fac_det_codigo,
    :new.fac_det_precio_total,
    :new.fac_det_cantidad,
    :new.fer_producto_pro_codigo,
    :old.fac_det_codigo,
    :old.fac_det_precio_total,
    :old.fac_det_cantidad,
    :old.fer_producto_pro_codigo,
    sysdate,
    user,
    sys_context('USERENV','HOST',15));
    
end tr_fer_audit_fac_det;