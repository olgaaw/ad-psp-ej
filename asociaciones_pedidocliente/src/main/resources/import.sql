insert into cliente (direccion,nombre,id) values ('Calle Ejempplo','Emilio',nextval('cliente_seq'));

insert into pedido (cliente_id,codigo,id) values (currval('cliente_seq'),'123A', nextval('pedido_seq'));