CREATE TABLE HIP_AUDIT_PRODUCTOS(
NEW_PROD_ID NUMBER(5,0),
NEW_PROD_CODIGOBARRA VARCHAR2(10),
NEW_PROD_NOMBRE VARCHAR2(50),
NEW_PROD_DESCRIPCION VARCHAR(50),
NEW_PROD_PRECIO NUMBER(5,2),
NEW_PROD_STOCK NUMBER(3),
NEW_PROD_NACIONALIDAD CHAR(1),
NEW_HIP_MEDIDAS_MED_ID NUMBER(5),
NEW_HIP_CATEGORIAS_CAT_ID NUMBER(5),
NEW_PROD_ESTADO VARCHAR(5),
NEW_PROD_IVA CHAR(1),
OLD_PROD_ID NUMBER(5,0),
OLD_PROD_CODIGOBARRA VARCHAR2(10),
OLD_PROD_NOMBRE VARCHAR2(50),
OLD_PROD_DESCRIPCION VARCHAR(50),
OLD_PROD_PRECIO NUMBER(5,2),
OLD_PROD_STOCK NUMBER(3),
OLD_PROD_NACIONALIDAD CHAR(1),
OLD_HIP_MEDIDAS_MED_ID NUMBER(5),
OLD_HIP_CATEGORIAS_CAT_ID NUMBER(5),
OLD_PROD_ESTADO VARCHAR(5),
OLD_PROD_IVA CHAR(1),
AUD_PROD_FECHA TIMESTAMP,
AUD_PROD_USUARIO VARCHAR2(50),
AUD_PROD_HOST VARCHAR2(100));

CREATE TABLE HIP_AUDIT_FACT_CABE(
NEW_FAC_ID NUMBER(5,0),
NEW_FAC_FECHA DATE,
NEW_FAC_ESTADO CHAR(1),
NEW_FAC_SUBTOTAL NUMBER(5,3),
NEW_FAC_IVA NUMBER(5,3),
NEW_FAC_TOTAL NUMBER(5,3),
NEW_HIP_PRESONAS_PER_ID NUMBER(5,0),
OLD_FAC_ID NUMBER(5,0),
OLD_FAC_FECHA DATE,
OLD_FAC_ESTADO CHAR(1),
OLD_FAC_SUBTOTAL NUMBER(5,3),
OLD_FAC_IVA NUMBER(5,3),
OLD_FAC_TOTAL NUMBER(5,3),
OLD_HIP_PRESONAS_PER_ID NUMBER(5,0),
AUD_FAC_FECHA TIMESTAMP,
AUD_FAC_USUARIO VARCHAR2(50),
AUD_FAC_HOST VARCHAR2(130));

CREATE TABLE HIP_AUT_DET(
NEW_FAD_ID  NUMBER(5),
NEW_FAD_CANTIDAD NUMBER(5),
NEW_FAD_PRECIOUNITARIO NUMBER(5,2),
NEW_FAD_IVA NUMBER(5,2),
NEW_FAD_PRECIOTOTAL NUMBER(5,2),
NEW_HIP_FAC_CAB_FAC_ID NUMBER(5),
NEW_HIP_PRODUCTOS_PROD_ID NUMBER(5),
OLD_FAD_ID  NUMBER(5),
OLD_FAD_CANTIDAD NUMBER(5),
OLDFAD_PRECIOUNITARIO NUMBER(5,2),
OLD_FAD_IVA NUMBER(5,2),
OLD_FAD_PRECIOTOTAL NUMBER(5,2),
OLD_HIP_FAC_CAB_FAC_ID NUMBER(5),
OLD_HIP_PRODUCTOS_PROD_ID NUMBER(5),
AUD_FAD_FECHA TIMESTAMP,
AUD_FAD_USUARIO VARCHAR2(50),
AUD_FAD_HOST VARCHAR2(100));

SELECT * FROM "HIP_PERSONAS" WHERE per_cedula ='0302261548';
SELECT COUNT(PER_CEDULA) FROM hip_personas a, hip_fcatura_cabeceras b WHERE a.per_id= b.hip_personas_per_id AND a.per_cedula= '0126593625';
SELECT * FROM HIP_ROLES;
SELECT * FROm hip_personas;
SELECT * FROM hip_medidas;
SELECT * FROM hip_categorias;
SELECT * FROM hip_productos;
SELECT * FROM hip_proveedores;
SELECT * FROm hip_proveedor_producto;
SELECT * FROM hip_factura_detalles;
SELECT * FROM hip_fcatura_cabeceras;

SELECT * FROM HIP_AUDIT_PRODUCTOS;

INSERT INTO HIP_ROLES VALUES(1,'Administrador');
INSERT INTO HIP_ROLES VALUES(2,'Empleado');
INSERT INTO HIP_ROLES VALUES(3,'Cliente');

INSERT INTO hip_personas VALUES(hip_personas_seq.nextval,'Vinicio','Campoverde','0115487859','Calle Larga','0748592615','0948591548','dcampoverde@gmail.com',null,null,3);
INSERT INTO hip_personas VALUES(hip_personas_seq.nextval,'Jose','Tapia','0148592636','Gonzales Suarez','0748592615','0848591526','tapia56@gmail.com',null,null,1);
INSERT INTO hip_personas VALUES(hip_personas_seq.nextval,'Byron','Vasquez','0302261548','Ricaurte','0748591574','0987481548','bvasquez@gmail.com',null,null,2);
INSERT INTO hip_personas VALUES(hip_personas_seq.nextval,'Carmen','Bravo','0126593625','Luis Cordero','0748151147','0978457789','carmenb@gmail.com',null,null,3);
INSERT INTO hip_personas VALUES(hip_personas_seq.nextval,'Rolando','Calle','0159664899','Remigio','0859154878','0966558877','caller@gmail.com',null,null,3);


insert into hip_medidas values (HIP_MEDIDAS_SEQ.nextval,'Libras');
insert into hip_medidas values (HIP_MEDIDAS_SEQ.nextval,'Unidades');
insert into hip_medidas values (HIP_MEDIDAS_SEQ.nextval,'kilos');
insert into hip_medidas values (HIP_MEDIDAS_SEQ.nextval,'gramos');
insert into hip_medidas values (HIP_MEDIDAS_SEQ.nextval,'metros');
insert into hip_medidas values (HIP_MEDIDAS_SEQ.nextval,'frascos');


insert into hip_categorias values(HIP_CATEGORIAS_SEQ.nextval,'Libreria');
INSERT INTO hip_categorias VALUES(HIP_CATEGORIAS_SEQ.nextval,'Snacks');
INSERT INTO hip_categorias VALUES(HIP_CATEGORIAS_SEQ.nextval,'Productos de Limpieza');
INSERT INTO hip_categorias VALUES(HIP_CATEGORIAS_SEQ.nextval,'Embutidos');
INSERT INTO hip_categorias VALUES(HIP_CATEGORIAS_SEQ.nextval,'Verduras');
INSERT INTO hip_categorias VALUES(HIP_CATEGORIAS_SEQ.nextval,'Bebidas');

INSERT INTO HIP_PROVEEDORES VALUES(HIP_PROVEEDORES_SEQ.nextval,'LNS','juan perez');
INSERT INTO HIP_PROVEEDORES VALUES(HIP_PROVEEDORES_SEQ.nextval,'FRITO LAY','maria calle');
INSERT INTO HIP_PROVEEDORES VALUES(HIP_PROVEEDORES_SEQ.nextval,'OLIMPIA','mario ramos');
INSERT INTO HIP_PROVEEDORES VALUES(HIP_PROVEEDORES_SEQ.nextval,'VERMONTINA','luis torres');
INSERT INTO HIP_PROVEEDORES VALUES(HIP_PROVEEDORES_SEQ.nextval,'ITALIANA','pablo toral');
INSERT INTO HIP_PROVEEDORES VALUES(HIP_PROVEEDORES_SEQ.nextval,'IMPERIAL','sofia encalada');

Insert into hip_productos values (HIP_PRODUCTOS_SEQ.nextval,'10101011','Calculadora','calculadora Cientifica',5.00,10,'N',2,1,'A','S');
Insert into hip_productos values (HIP_PRODUCTOS_SEQ.nextval,'10111100','Papas Fritas','rufles',0.50,20,'E',2,2,'A');
Insert into hip_productos values (HIP_PRODUCTOS_SEQ.nextval, '101001', 'Cuaderno', 'Cuaderno de 100 hojas',3.00,0,'N',2,1,'I');
Insert into hip_productos values (HIP_PRODUCTOS_SEQ.nextval, '010110101', 'Coca cola', 'Coca cola 1lt', 1.5, 10, 'N', 2, 6, 'A');
Insert into hip_productos values (HIP_PRODUCTOS_SEQ.nextval, '01011011', 'Manzana', 'Manzana Verde', 0.5, 10, 'E', 2, 5, 'A');
Insert into hip_productos values (HIP_PRODUCTOS_SEQ.nextval,'01235645','Toallas','Toalla de baño',5.00,50,'E',2,3,'A','S');
INSERT INTO hip_productos VALUES (HIP_PRODUCTOS_SEQ.nextval,'01010102','Papel Regalo','Papel para regalos',0.30,20,'E',2,1,'A','C');


INSERT INTO hip_proveedor_producto VALUES(HIP_PROVEEDOR_PRODUCTO_SEQ.nextval,20,'28-05-2020',0001,2,2);
INSERT INTO hip_proveedor_producto VALUES(HIP_PROVEEDOR_PRODUCTO_SEQ.nextval,10,'18-01-2020',0011,4,6);
INSERT INTO hip_proveedor_producto VALUES(HIP_PROVEEDOR_PRODUCTO_SEQ.nextval,5,'16-03-2020',0012,5,4);
 
INSERT INTO hip_factura_detalles VALUES (HIP_FACTURA_DETALLES_SEQ.nextval,2,0.50,0.06,0.56,1,2);
INSERT INTO hip_factura_detalles VALUES (HIP_FACTURA_DETALLES_SEQ.nextval,2,0.50,0.06,0.56,1,2);
INSERT INTO hip_factura_detalles VALUES (HIP_FACTURA_DETALLES_SEQ.nextval,5,0.50,0.00,2.50,4,5);
INSERT INTO hip_factura_detalles VALUES (HIP_FACTURA_DETALLES_SEQ.nextval,2,1.50,1.68,3.18,6,4);
INSERT INTO hip_factura_detalles VALUES (HIP_FACTURA_DETALLES_SEQ.nextval,5,5.00,0.00,25.00,1,1);
INSERT INTO hip_factura_detalles VALUES (HIP_FACTURA_DETALLES_SEQ.nextval,2,5.00,0.00,10.00,3,1);
INSERT INTO hip_factura_detalles VALUES (HIP_FACTURA_DETALLES_SEQ.nextval,6,1.50,0.00,9.00,2,4);
INSERT INTO hip_factura_detalles VALUES (HIP_FACTURA_DETALLES_SEQ.nextval,10,5.00,0.00,50.00,5,6);
INSERT INTO hip_factura_detalles VALUES (HIP_FACTURA_DETALLES_SEQ.nextval,10,0.50,0.06,5.60,1,2);
INSERT INTO hip_factura_detalles VALUES (HIP_FACTURA_DETALLES_SEQ.nextval,1,5.00,0.00,5.00,1,1);
INSERT INTO hip_factura_detalles VALUES (HIP_FACTURA_DETALLES_SEQ.nextval,10,0.50,0.06,5.60,1,2);
INSERT INTO hip_factura_detalles VALUES (HIP_FACTURA_DETALLES_SEQ.nextval,10,1.50,0.00,15.00,3,2);
INSERT INTO hip_factura_detalles VALUES (HIP_FACTURA_DETALLES_SEQ.nextval,15,1.50,0.00,22.50,3,4);
INSERT INTO hip_factura_detalles VALUES (HIP_FACTURA_DETALLES_SEQ.nextval,2,1.50,0.00,4.50,3,4);

 
INSERT INTO hip_fcatura_cabeceras VALUES (HIP_FACTURA_CABECERAS_SEQ.nextval,'22-07-2020','A',0.56,0.06,0.62,5);
INSERT INTO hip_fcatura_cabeceras VALUES (HIP_FACTURA_CABECERAS_SEQ.nextval,'22-07-2020','A',4.12,0.49,4.61,4);
INSERT INTO hip_fcatura_cabeceras VALUES (HIP_FACTURA_CABECERAS_SEQ.nextval,'02-09-2019','F',5.60,0.67,6.27,5);
INSERT INTO hip_fcatura_cabeceras VALUES (HIP_FACTURA_CABECERAS_SEQ.nextval,'03-10-2019','A',5.60,0.67,6.27,5);
INSERT INTO hip_fcatura_cabeceras VALUES (HIP_FACTURA_CABECERAS_SEQ.nextval,'03-10-2019','A',5.60,0.67,6.27,4);
INSERT INTO hip_fcatura_cabeceras VALUES (HIP_FACTURA_CABECERAS_SEQ.nextval,'25-07-2020','A',20.30,2.43,22.73,4);
INSERT INTO hip_fcatura_cabeceras VALUES (HIP_FACTURA_CABECERAS_SEQ.nextval,'23-07-2020','A',50.60,0.00,50.60,4);
INSERT INTO hip_fcatura_cabeceras VALUES (HIP_FACTURA_CABECERAS_SEQ.nextval,'24-07-2020','A',50.00,0.00,50.00,4);



COMMIT;

SELECT total_ventas('22-07-2020') VENTA_TOTAL from dual;

SELECT total_ventas('24-07-2020') from dual;



--Consulta para el reporte de ventas del mes: se deberá crear una consulta para presentar
--un reporte de ventas del mes. Para la consulta se deberá filtrar la información entre una
--fecha de inicio y una fecha de fin. La consulta deberá presentar el nombre del producto, la
--cantidad de unidades vendidas, el precio de venta, el subtotal, el valor de IVA si aplica o caso
--contrario se debería presentar el valor de cero y el valor total de las ventas (subtotal + IVA).
--La información deberá estar ordenada por valor total de forma descendente. 

select p.PROD_NOMBRE Nombre_Producto, sum(d.FAD_CANTIDAD) Cantidades_Vendidas, p.PROD_PRECIO Precio_Venta, sum(p.prod_precio*d.fad_cantidad)SubTotal, sum(d.FAD_IVA)Precio_IVA, sum((p.PROD_PRECIO*d.fad_cantidad)+d.fad_iva) Total
FROM HIP_PRODUCTOS p, HIP_FACTURA_DETALLES d, HIP_FCATURA_CABECERAS c
where d.hip_productos_prod_id = p.PROD_ID and d.hip_fac_cab_fac_id =c.FAC_ID and ((c.fac_fecha BETWEEN '23072020' AND '24072020')and(c.FAC_ESTADO = 'A'))
group by p.PROD_NOMBRE, p.PROD_PRECIO
order by 6 desc;

--SELECT *
--FROM HIP_PRODUCTOS p, HIP_FACTURA_DETALLES d, HIP_FCATURA_CABECERAS c
--where d.hip_productos_prod_id = p.PROD_ID and d.hip_fac_cab_fac_id =c.FAC_ID and c.fac_fecha BETWEEN TO_DATE('23/07/2020','DD/MM/YYYY') AND TO_DATE('24/07/2020','DD/MM/YYYY')and(c.FAC_ESTADO = 'A');´


--Consulta para el reporte de los tres mejores productos o servicios de un mes: se
--deberá presentar un reporte de los tres productos o servicios que más se han vendido en un
--mes. Para la consulta se deberá filtrar la información entre una fecha de inicio y una fecha
--de fin. La consulta deberá presentar el nombre del producto o servicio, la cantidad de facturas 
--en la que aparece el servicio, y el monto total pagado en facturas. Esta información deberá
--estar ordenada en forma descendente por el monto total pagado.

select A.NOMBRE_PRODUCTO, A.FACTURAS_VENDIDAS, A.TOTAL_PAGADO
from (SELECT p.prod_nombre NOMBRE_PRODUCTO,count(c.fac_id) FACTURAS_VENDIDAS,sum((p.PROD_PRECIO*d.fad_cantidad)+d.fad_iva)TOTAL_PAGADO
            FROM hip_productos p,hip_fcatura_cabeceras c, hip_factura_detalles d
            WHERE d.hip_productos_prod_id = p.prod_id
            AND d.hip_fac_cab_fac_id = c.fac_id
            AND c.fac_fecha BETWEEN '15/08/2020' AND '30/08/2020'
            GROUP BY p.prod_nombre
            ORDER BY 3 DESC) A
WHERE ROWNUM <= 3;

COMMIT;
