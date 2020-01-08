insert into FER_PROFESIONES values (1,'Ingeniero',2.5);
insert into FER_CARGOS values (1,'Gerente'); 
insert into FER_EMPLEADOS values (4,'Byron','Godoy','Ricaurte','0107377021','byron1@hotmail.com','byron','masculino','4077632',1);
commit;

select * from FER_CLIENTES;
SELECT * FROM FER_CLIENTES WHERE CLI_CEDULA = '0107377020';
select max(CLI_CODIGO)+1 as id from FER_CLIENTES;
commit;

SELECT * FROM FER_CLIENTES WHERE CLI_CEDULA = '0107128100';
