create or replace trigger tr_fer_audit_fac

before insert or UPDATE or delete on FER_FACTURAS

for each row

begin

    insert into FER_AUDITORIA_FACTURAS values(
    :new.fac_codigo,
    :new.fac_estado,
    :new.fac_descuento,
    :new.fac_total,
    :old.fac_codigo,
    :old.fac_estado,
    :old.fac_descuento,
    :old.fac_total,
    sysdate,
    user,
    sys_context('USERENV','HOST',15));
    
end tr_fer_audit_fac;