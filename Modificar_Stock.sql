-- Procedimiento que genera una factura 
CREATE OR REPLACE PROCEDURE MODIFICAR_STOCK(                                       
                                        VAR_PROD_ID NUMBER,
                                        VAR_CANT_PRO NUMBER
                                        ) IS 

-- Seccion en donde se puede declarar variables

-- Es como un vector
CURSOR CUR_PRODUCTO IS
       SELECT PROD_ID,PROD_STOCK       
       FROM HIP_PRODUCTOS
       WHERE PROD_ID=VAR_PROD_ID;
       

-- Variable para almacenar el codigo de cada producto
var_pro_id HIP_PRODUCTOS.PROD_ID%TYPE;

-- Variable para obtener el stock de cada producto
var_pro_stock HIP_PRODUCTOS.PROD_STOCK%TYPE;


BEGIN

    -- Se obtiene los valores del producto
    OPEN CUR_PRODUCTO;
    LOOP 
    
        FETCH CUR_PRODUCTO INTO var_pro_id,var_pro_stock; -- FETCH recorre las filas o tuplas
        EXIT WHEN CUR_PRODUCTO%NOTFOUND; -- CUANDO SE DEBE DETENER, CUABNDO YA NO HAYA MAS DATOS
    
    END LOOP;
    
    CLOSE CUR_PRODUCTO;
    
    --Se actualiza el stock del producto 
    UPDATE HIP_PRODUCTOS
    SET PROD_STOCK= var_pro_stock-VAR_CANT_PRO
    WHERE PROD_ID=var_pro_id;

EXCEPTION 
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;

END MODIFICAR_STOCK;