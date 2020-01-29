create or replace trigger tr_fer_audit_pro

before insert or UPDATE or delete on FER_PRODUCTOS

for each row

begin

    insert into FER_AUDITORIA_PRODUCTOS values(
    :new.pro_codigo,
    :new.pro_nombre,
    :new.pro_descripcion,
    :old.pro_codigo,
    :old.pro_nombre,
    :old.pro_descripcion,
    sysdate,
    user,
    sys_context('USERENV','HOST',15));
    
end tr_fer_audit_pro;