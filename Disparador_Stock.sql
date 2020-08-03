-- Este disparador manda a llamar el procedimiento para 
-- modificar el stock 
CREATE OR REPLACE TRIGGER tr_det_fac_pr_st
BEFORE INSERT ON Hipermercado.HIP_FACTURA_DETALLES

FOR EACH ROW
BEGIN 
--Se llama al procedimiento que modifica el stock con los valores
--que estan ingresando
Hipermercado.MODIFICAR_STOCK(:new.HIP_PRODUCTOS_PROD_ID, 
                             :new.FAD_CANTIDAD);
                     
END tr_det_fac_pr_st;
