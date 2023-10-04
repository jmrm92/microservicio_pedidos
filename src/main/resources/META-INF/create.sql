CREATE TABLE pedidosdb.pedidos (
	id_pedido INT auto_increment NOT NULL,
	codigo_producto INT NULL,
	unidades INT NULL,
	total DOUBLE NULL,
	fecha DATETIME NULL,
	CONSTRAINT pedidos_pk PRIMARY KEY (id_pedido)
)

ALTER TABLE pedidosdb.pedidos ADD CONSTRAINT pedidos_FK FOREIGN KEY (codigo_producto) REFERENCES pedidosdb.productos(codigo_producto);