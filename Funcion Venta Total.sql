--Creamos la funcion 
CREATE OR REPLACE FUNCTION total_ventas(fecha_venta VARCHAR)

RETURN VARCHAR IS
venta_total VARCHAR(50);
--Comienza el proceso
BEGIN
--suma el total de ventas de facturas en una fecha determinada
SELECT TO_CHAR(SUM(fac_total),'L99G999D99')
INTO venta_total
FROM HIP_FCATURA_CABECERAS
WHERE fac_fecha = fecha_venta
GROUP BY FAC_FECHA;
RETURN venta_total;

--Finaliza el proceso
END total_ventas;

