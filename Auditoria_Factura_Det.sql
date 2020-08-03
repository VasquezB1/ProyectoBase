CREATE OR REPLACE TRIGGER tr_audi_fac_det
BEFORE INSERT OR UPDATE OR DELETE ON Hipermercado.HIP_FACTURA_DETALLES

FOR EACH ROW -- PERMITE QUE EL DISPARADOR TRABAJE POR TUPLAS

BEGIN 

INSERT INTO HIP_AUT_DET VALUES( :NEW.FAD_ID,
                                          :NEW.FAD_CANTIDAD,
                                          :NEW.FAD_PRECIOUNITARIO,
                                          :NEW.FAD_IVA,
                                          :NEW.FAD_PRECIOTOTAL,
                                          :NEW.HIP_FAC_CAB_FAC_ID,
                                          :NEW.HIP_PRODUCTOS_PROD_ID,
                                          :OLD.FAD_ID,
                                          :OLD.FAD_CANTIDAD,
                                          :OLD.FAD_PRECIOUNITARIO,
                                          :OLD.FAD_IVA,
                                          :OLD.FAD_PRECIOTOTAL,
                                          :OLD.HIP_FAC_CAB_FAC_ID,
                                          :OLD.HIP_PRODUCTOS_PROD_ID,
                                          SYSDATE,
                                          USER,
                                          SYS_CONTEXT('USERNV','HOST',15));
                                          
END tr_audi_fac_det;