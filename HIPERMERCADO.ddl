-- Generado por Oracle SQL Developer Data Modeler 19.4.0.350.1424
--   en:        2020-07-22 16:34:09 COT
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g



CREATE TABLE hip_categorias (
    cat_id      NUMBER(5) NOT NULL,
    cat_nombre  VARCHAR2(50) NOT NULL
);

COMMENT ON COLUMN hip_categorias.cat_id IS
    'Llave primaria de la entidad  categoria';

COMMENT ON COLUMN hip_categorias.cat_nombre IS
    'Nombre de la categoria ejemplo( categoria de carne, electrodomesticos,etc. )';

ALTER TABLE hip_categorias ADD CONSTRAINT hip_categorias_pk PRIMARY KEY ( cat_id );

CREATE TABLE hip_factura_detalles (
    fad_id                        NUMBER(5) NOT NULL,
    fad_cantidad                  NUMBER(5) NOT NULL,
    fad_preciounitario            NUMBER(5, 2) NOT NULL,
    fad_iva                       NUMBER(5, 2),
    fad_preciototal               NUMBER(5, 3) NOT NULL,
    hip_fcatura_cabeceras_fac_id  NUMBER(5) NOT NULL,
    hip_productos_prod_id         NUMBER(5) NOT NULL
);

ALTER TABLE hip_factura_detalles RENAME COLUMN hip_fcatura_cabeceras_fac_id TO hip_fac_cab_fac_id;
COMMIT;
COMMENT ON COLUMN hip_factura_detalles.fad_id IS
    'Llave primaria de la entidad factura detalle';

COMMENT ON COLUMN hip_factura_detalles.fad_cantidad IS
    'Cantidad del producto que se cargara la factura';

COMMENT ON COLUMN hip_factura_detalles.fad_preciounitario IS
    'Precio que tiene el producto en la factura detalle';

COMMENT ON COLUMN hip_factura_detalles.fad_iva IS
    'Precio del producto mas el IVA 
Solo aplica cuando el producto tiene IVA';

COMMENT ON COLUMN hip_factura_detalles.fad_preciototal IS
    'Precio total de factura detalle ';

ALTER TABLE hip_factura_detalles ADD CONSTRAINT hip_factura_detalles_pk PRIMARY KEY ( fad_id );

CREATE TABLE hip_fcatura_cabeceras (
    fac_id               NUMBER(5) NOT NULL,
    fac_fecha            DATE NOT NULL,
    fac_estado           CHAR(1) NOT NULL,
    fac_subtotal         NUMBER(5, 3) NOT NULL,
    fac_iva              NUMBER(5, 3) NOT NULL,
    fac_total            NUMBER(5, 3) NOT NULL,
    hip_personas_per_id  NUMBER(5) NOT NULL
);

COMMENT ON COLUMN hip_fcatura_cabeceras.fac_id IS
    'Llave primaria de la entidad facturas cabecera';

COMMENT ON COLUMN hip_fcatura_cabeceras.fac_fecha IS
    'Fecha en la que se emitira la factura';

COMMENT ON COLUMN hip_fcatura_cabeceras.fac_estado IS
    'Ingrese A si la factura esta existente
    F si la factura esta anulada';

COMMENT ON COLUMN hip_fcatura_cabeceras.fac_subtotal IS
    'Subtotal de la factura en general';

COMMENT ON COLUMN hip_fcatura_cabeceras.fac_iva IS
    'Iva e n general';

COMMENT ON COLUMN hip_fcatura_cabeceras.fac_total IS
    'Total a pagar de factura general ';

ALTER TABLE hip_fcatura_cabeceras ADD CONSTRAINT hip_fcatura_cabeceras_pk PRIMARY KEY ( fac_id );

CREATE TABLE hip_medidas (
    med_id      NUMBER(5) NOT NULL,
    med_medida  VARCHAR2(20) NOT NULL
);

COMMENT ON COLUMN hip_medidas.med_id IS
    'Llave primaria de la entidad medidas';

COMMENT ON COLUMN hip_medidas.med_medida IS
    'Aqui se especifica el nombre del tipo de medida que se registra';

ALTER TABLE hip_medidas ADD CONSTRAINT hip_medidas_pk PRIMARY KEY ( med_id );

CREATE TABLE hip_personas (
    per_id            NUMBER(5) NOT NULL,
    per_nombre        VARCHAR2(100) NOT NULL,
    per_apellido      VARCHAR2(100) NOT NULL,
    per_cedula        VARCHAR2(10) NOT NULL,
    per_direccion     VARCHAR2(100) NOT NULL,
    per_telefono      VARCHAR2(10),
    per_celular       VARCHAR2(10) NOT NULL,
    per_email         VARCHAR2(30) NOT NULL,
    per_usuario       VARCHAR2(50),
    per_contrasenia   VARCHAR2(20),
    hip_roles_rol_id  NUMBER(5) NOT NULL
);

COMMENT ON COLUMN hip_personas.per_id IS
    'Llave primaria de la entidad persona 
';

COMMENT ON COLUMN hip_personas.per_nombre IS
    'Dos nombres de la persona';

COMMENT ON COLUMN hip_personas.per_apellido IS
    'Dos apellidos de la persona';

COMMENT ON COLUMN hip_personas.per_cedula IS
    'Numero de cedula de la persona';

COMMENT ON COLUMN hip_personas.per_direccion IS
    'Direccion completa(calle secundaria,calle primaria) en la que la persona reside';

COMMENT ON COLUMN hip_personas.per_telefono IS
    'Numero de telefono de la persona en caso de tenerlo';

COMMENT ON COLUMN hip_personas.per_celular IS
    'Numero de celular de la persona';

COMMENT ON COLUMN hip_personas.per_email IS
    'Email de la persona';

COMMENT ON COLUMN hip_personas.per_usuario IS
    'El campo  sera  obligatorio en caso de que sea empleado  o administrador ';

COMMENT ON COLUMN hip_personas.per_contrasenia IS
    'El campo  sera  obligatorio en caso de que sea empleado  o administrador ';

ALTER TABLE hip_personas ADD CONSTRAINT hip_personas_pk PRIMARY KEY ( per_id );

CREATE TABLE hip_productos (
    prod_id                NUMBER(5) NOT NULL,
    prod_codigobarra       VARCHAR2(20) NOT NULL,
    prod_nombre            VARCHAR2(50) NOT NULL,
    prod_descripcion       VARCHAR2(200) NOT NULL,
    prod_precio            NUMBER(5, 3) NOT NULL,
    prod_stock             NUMBER(5) NOT NULL,
    prod_nacionalidad      CHAR(1) NOT NULL,
    hip_medidas_med_id     NUMBER(5) NOT NULL,
    hip_categorias_cat_id  NUMBER(5) NOT NULL,
    prod_estado            CHAR(1) NOT NULL
);

ALTER TABLE hip_productos ADD prod_iva CHAR(1);

ALTER TABLE HIP_PRODUCTOS 
ADD CONSTRAINT IVA_CK CHECK(prod_iva IN 'S' OR prod_iva IN 'C');

COMMENT ON COLUMN hip_productos.prod_id IS
    'LLave primaria   de  la entidad producto ';

COMMENT ON COLUMN hip_productos.prod_codigobarra IS
    'Codigo de barras del producto';

COMMENT ON COLUMN hip_productos.prod_nombre IS
    'Nombre del producto';

COMMENT ON COLUMN hip_productos.prod_descripcion IS
    'Decripcion del producto';

COMMENT ON COLUMN hip_productos.prod_precio IS
    'Precio del producto';

COMMENT ON COLUMN hip_productos.prod_stock IS
    ' stock disponible del producto en funcion de la unidad de medida';

COMMENT ON COLUMN hip_productos.prod_nacionalidad IS
    ' N si es nacional 
 E si es extranjero
  ';

COMMENT ON COLUMN hip_productos.prod_estado IS
    'A   "Si el producto esta activo"
I  "Si el producto esta inactivo "';

ALTER TABLE hip_productos ADD CONSTRAINT hip_productos_pk PRIMARY KEY ( prod_id );

CREATE TABLE hip_proveedor_producto (
    ppr_id                  NUMBER(45) NOT NULL,
    ppr_cantidad            NUMBER(5) NOT NULL,
    ppr_fecha_llegada       DATE NOT NULL,
    ppr_num_factura         NUMBER(5) NOT NULL,
    hip_productos_prod_id   NUMBER(5) NOT NULL,
    hip_proveedores_pro_id  NUMBER(5) NOT NULL
);

COMMENT ON COLUMN hip_proveedor_producto.ppr_id IS
    'Llave primaria  de la entidad intermedia proveedor_producto
';

COMMENT ON COLUMN hip_proveedor_producto.ppr_cantidad IS
    'cantidad que hay en el  stock';

COMMENT ON COLUMN hip_proveedor_producto.ppr_fecha_llegada IS
    'Fecha de llegada del producto';

COMMENT ON COLUMN hip_proveedor_producto.ppr_num_factura IS
    'Numero de factura';

ALTER TABLE hip_proveedor_producto ADD CONSTRAINT hip_proveedor_producto_pk PRIMARY KEY ( ppr_id );

CREATE TABLE hip_proveedores (
    pro_id           NUMBER(5) NOT NULL,
    pro_empresa      VARCHAR2(60) NOT NULL,
    pro_responsable  VARCHAR2(50) NOT NULL
);

COMMENT ON COLUMN hip_proveedores.pro_id IS
    'LLave primaria de la entidad  proveedores';

COMMENT ON COLUMN hip_proveedores.pro_empresa IS
    'Nombre de la empresa ';

COMMENT ON COLUMN hip_proveedores.pro_responsable IS
    'Nombre y apellido del responsable que brindara el servicio';

ALTER TABLE hip_proveedores ADD CONSTRAINT hip_proveedores_pk PRIMARY KEY ( pro_id );

CREATE TABLE hip_roles (
    rol_id      NUMBER(5) NOT NULL,
    rol_nombre  VARCHAR2(30) NOT NULL
);

COMMENT ON COLUMN hip_roles.rol_id IS
    'Llave primaria de la entidad Roles';

COMMENT ON COLUMN hip_roles.rol_nombre IS
    'Nombre del rol  que desempeñara';

ALTER TABLE hip_roles ADD CONSTRAINT hip_roles_pk PRIMARY KEY ( rol_id );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE hip_factura_detalles
    ADD CONSTRAINT hip_factura_detalles_hip_fcatura_cabeceras_fk FOREIGN KEY ( hip_fcatura_cabeceras_fac_id )
        REFERENCES hip_fcatura_cabeceras ( fac_id );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE hip_factura_detalles
    ADD CONSTRAINT hip_factura_detalles_hip_productos_fk FOREIGN KEY ( hip_productos_prod_id )
        REFERENCES hip_productos ( prod_id );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE hip_fcatura_cabeceras
    ADD CONSTRAINT hip_fcatura_cabeceras_hip_personas_fk FOREIGN KEY ( hip_personas_per_id )
        REFERENCES hip_personas ( per_id );

ALTER TABLE hip_personas
    ADD CONSTRAINT hip_personas_hip_roles_fk FOREIGN KEY ( hip_roles_rol_id )
        REFERENCES hip_roles ( rol_id );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE hip_productos
    ADD CONSTRAINT hip_productos_hip_categorias_fk FOREIGN KEY ( hip_categorias_cat_id )
        REFERENCES hip_categorias ( cat_id );

ALTER TABLE hip_productos
    ADD CONSTRAINT hip_productos_hip_medidas_fk FOREIGN KEY ( hip_medidas_med_id )
        REFERENCES hip_medidas ( med_id );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE hip_proveedor_producto
    ADD CONSTRAINT hip_proveedor_producto_hip_productos_fk FOREIGN KEY ( hip_productos_prod_id )
        REFERENCES hip_productos ( prod_id );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE hip_proveedor_producto
    ADD CONSTRAINT hip_proveedor_producto_hip_proveedores_fk FOREIGN KEY ( hip_proveedores_pro_id )
        REFERENCES hip_proveedores ( pro_id );



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             9
-- CREATE INDEX                             0
-- ALTER TABLE                             17
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   6
-- WARNINGS                                 0
