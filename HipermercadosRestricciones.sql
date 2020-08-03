--RESTRICCIONES UNIQUE
--RESTRICCION SOBRE EL CAMPO  CEDULA DE LOS CLIENTES  Y EMPLEADOS 
ALTER TABLE HIP_PERSONAS
ADD UNIQUE ( PER_CEDULA );

--RESTRICCION SOBRE EL CAMPO EMAIL DE LOS CLIENTES  Y EMPLEADOS 
ALTER TABLE HIP_PERSONAS
ADD UNIQUE ( PER_EMAIL );

SELECT *
FROM all_constraints
WHERE table_name = 'HIP_PRODUCTOS' AND constraint_type='C';


-- RESTRICCION SOBRE EL CAMPO STOCK  PARA QUE LOS PRODUCTOS NO TENGAN  STOCK NEGATIVO
alter  TABLE HIP_PRODUCTOS
add constraint valores_positivos_ck
check( PROD_STOCK >= 0 );

--RESTRICCION SOBRE EL CAMPO DE LA NACIONALIDAD DE LOS PRODUCTOS
--Generear un CHECK que permita solo ingresar loa letra E en caso de ser un prodcuto Extranjero y la letra N 
--en caso de ser un producto nacional
ALTER TABLE HIP_PRODUCTOS 
ADD CONSTRAINT PRODUCTOS_CK CHECK(pro_nacio IN 'N' OR pro_nacio IN 'E');

DESC HIP_PRODUCTOS;



