-- Auditoria para la tabla Factura Cabecera

CREATE OR REPLACE TRIGGER tr_auditoria_fcaturaCabecera
BEFORE INSERT OR UPDATE ON Hipermercado.hip_fcatura_cabeceras 

FOR EACH ROW -- PERMITE QUE EL DISPARADOR TRABAJE POR TUPLAS

BEGIN 

INSERT INTO HIP_AUDIT_FACT_CABE VALUES( :NEW.FAC_ID,
                                          :NEW.FAC_FECHA,
                                          :NEW.FAC_ESTADO,
                                          :NEW.FAC_SUBTOTAL,
                                          :NEW.FAC_IVA,
                                          :NEW.FAC_TOTAL,                                          
                                          :NEW.HIP_PERSONAS_PER_ID,
                                          :OLD.FAC_ID,
                                          :OLD.FAC_FECHA,
                                          :OLD.FAC_ESTADO,
                                          :OLD.FAC_SUBTOTAL,
                                          :OLD.FAC_IVA,
                                          :OLD.FAC_TOTAL,                                          
                                          :OLD.HIP_PERSONAS_PER_ID,
                                          SYSDATE,
                                          USER,
                                          SYS_CONTEXT('USERENV','HOST',20));                                                                      
END tr_auditoria_facturaCabecera;


