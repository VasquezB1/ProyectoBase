/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Producto;
import ec.edu.ups.modelo.ProductoProveedor;
import ec.edu.ups.modelo.Proveedor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Jose Guillermo Quinde
 */
public class ProvProdControlador {
    
     
 private BaseDeDatos db;
    ControladorProducto contproducto;
    ProveedorControlador proveedorControlador;

    public ProvProdControlador(String url, String user, String password) {

        db = new BaseDeDatos(url, user, password);
        contproducto=new ControladorProducto(url, user, password);
        proveedorControlador=new ProveedorControlador(url, user, password);

    }
    /**
     * Te devuelve el ultimo codigo del ultimo registro de la base de datos
     * @return 
     */
     public int buscarUltimoCodigo() {
        int resultado = 0;
        db.conectar();
        try {
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery("SELECT MAX (\"PRV_PRO_ID\") FROM \"SDF_PRV_PRO\"");
            res.next();
            resultado = res.getInt(1);
            db.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error en la buscarUltimoCodigo " + ex);
        }
        return resultado;
    }

    public void createProvProd(ProductoProveedor p) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = sdf.format(p.getFechaLlegada());
        String sql = "INSERT INTO \"SDF_PRV_PRO\" VALUES("
                + p.getId() + ",'"
                + p.getNroFActura()+ "','"
                +fecha+"',"
                +p.getCantidad()+","
                +p.getProducto().getId()+","
                +p.getProveedor().getId()
                + ")";

        //System.out.println(sql);

        db.conectar();
        try {

            Statement sta = db.getConexionBD().createStatement();
            sta.execute(sql);
            db.desconectar();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public ProductoProveedor BuscarProveedorCodigo(int codigo) {

        ProductoProveedor prov = new ProductoProveedor();

        try {

            String sql = "SELECT * FROM \"SDF_PRV_PRO\"WHERE\"PRV_PRO_ID\"= '" + codigo + "'";

            db.conectar();
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery(sql);

            while (res.next()) {

                prov.setId(codigo);
                prov.setNroFActura(res.getString("PRV_PRO_NRO_FACTURA"));
                prov.setFechaLlegada(res.getDate("PRV_PRO_FECHA_LLEGADA"));
                prov.setCantidad(res.getInt("PRV_PRO_CANTIDAD"));
                int codigop=res.getInt("SDF_PRODUCTOS_PRO_ID");
                int codigoprov=res.getInt("SDF_PROVEEDORES_PRV_ID");
                Proveedor prov1=proveedorControlador.BuscarProveedorCodigo(codigoprov);
                Producto p=contproducto.Buscar(codigop);
                prov.setProducto(p);
                prov.setProveedor(prov1);
                
            }
            res.close();
            sta.close();
            db.desconectar();

        } catch (SQLException error) {
            error.printStackTrace();
        }

        return prov;

    }

   

   /* private void modificar(ProductoProveedor p) throws SQLException {

        String sql = "UPDATE\"SDF_PROVEEDORES\" SET "
                + "\"PRV_NOMBRE\"='" + p.getNombre() + "',"
                + "WHERE \"PRV_ID\" = " + p.getId() + ";";

        //System.out.println(sql);
        db.conectar();
        try {
            Statement sta = db.getConexionBD().createStatement();
            sta.execute(sql);
            db.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }*/

    public Set<ProductoProveedor> listaProveedor() throws Exception {
        Set<ProductoProveedor> listaProv = new HashSet<ProductoProveedor>();
            String sql = "SELECT * FROM \"SDF_PRV_PRO\" ";
            db.conectar();
            try {
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery(sql);

            while (res.next()) {

                ProductoProveedor prov = new ProductoProveedor();
                prov.setId(res.getInt("PRV_PRO_ID"));
                prov.setNroFActura(res.getString("PRV_PRO_NRO_FACTURA"));
                prov.setFechaLlegada(res.getDate("PRV_PRO_FECHA_LLEGADA"));
                prov.setCantidad(res.getInt("PRV_PRO_CANTIDAD"));
                int codigop=res.getInt("SDF_PRODUCTOS_PRO_ID");
                int codigoprov=res.getInt("SDF_PROVEEDORES_PRV_ID");
                Proveedor prov1=proveedorControlador.BuscarProveedorCodigo(codigoprov);
                Producto p=contproducto.Buscar(codigop);
                prov.setProducto(p);
                prov.setProveedor(prov1);
                listaProv.add(prov);
            }

            res.close();
            sta.close();
            db.desconectar();
        } catch (SQLException error) {

            error.printStackTrace();

        }
        return listaProv;
    }

}
   