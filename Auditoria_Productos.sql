-- Disparador para auditoria de la tabla Estudiante
CREATE OR REPLACE TRIGGER tr_uni_audit_pro
BEFORE INSERT OR UPDATE OR DELETE ON Hipermercado.HIP_PRODUCTOS

--(FOR EACH ROW) Permite que el disparador trabajo por tuplas
FOR EACH ROW

BEGIN
INSERT INTO HIP_AUDIT_PRODUCTOS VALUES(
   :NEW.PROD_ID,
   :NEW.PROD_CODIGOBARRA,   
   :NEW.PROD_NOMBRE,
   :NEW.PROD_DESCRIPCION,
   :NEW.PROD_PRECIO,
   :NEW.PROD_STOCK,
   :NEW.PROD_NACIONALIDAD,
   :NEW.HIP_MEDIDAS_MED_ID,
   :NEW.HIP_CATEGORIAS_CAT_ID,
   :NEW.PROD_ESTADO,
   :NEW.PROD_IVA,   
   :OLD.PROD_ID,
   :OLD.PROD_CODIGOBARRA,
   :OLD.PROD_NOMBRE,
   :OLD.PROD_DESCRIPCION,
   :OLD.PROD_PRECIO,
   :OLD.PROD_STOCK,
   :OLD.PROD_NACIONALIDAD,
   :OLD.HIP_MEDIDAS_MED_ID,
   :OLD.HIP_CATEGORIAS_CAT_ID,
   :OLD.PROD_ESTADO,
   :OLD.PROD_IVA,
   SYSDATE,
   USER,
   SYS_CONTEXT('USERENV','HOST',15));

END tr_uni_audit_pro;