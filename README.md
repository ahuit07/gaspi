### Información General
* Se requiere una instancia de base de datos postgresql
* Actualizar el usuario y pass de la base de datos en el archivo .properties
* Crear la siguiente tabla y secuencia:
* CREATE TABLE public.tbl_proveedores (
*	id_proveedor bigserial NOT NULL,
*	nb_proveedor varchar(80) NOT NULL,
*	rs_proveedor varchar(80) NOT NULL,
*	dir_proveedor varchar(80) NOT NULL,
*	st_proveedor bool NOT NULL,
*	CONSTRAINT proveedores_pk PRIMARY KEY (id_proveedor),
*	CONSTRAINT tbl_proveedores_nb_proveedor_unique UNIQUE (nb_proveedor)
* );
* CREATE SEQUENCE public.tbl_proveedores_id_proveedor_seq
*	INCREMENT BY 1
*	MINVALUE 1
*	MAXVALUE 9223372036854775807
*	START 1
*	CACHE 1
*	NO CYCLE;