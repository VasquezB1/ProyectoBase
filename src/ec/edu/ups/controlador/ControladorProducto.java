/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Producto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Edison
 */
public class ControladorProducto {

    private BaseDeDatos db;
    private UnidadesControlador un;
    private CategoriaControlador cc;

    public ControladorProducto(String url, String user, String password) {
        db = new BaseDeDatos(url, user, password);
        un = new UnidadesControlador(url, user, password);
        cc = new CategoriaControlador(url, user, password);
    }

    public void create(Producto producto) {
        String sql = "INSERT INTO \"HIP_PRODUCTOS\" VALUES(" + producto.getId() + ",'"
                + producto.getCodBarra() + "','"
                + producto.getNombre() + "',"
                + producto.getPrecio() + ","
                + producto.getStock() + ",'"
                + producto.getNacionalidad() + "',"
                + producto.getUm().getId() + ","
                + producto.getCp().getId() + ",'"
                + producto.getIva() + "')";
        System.out.println(sql);

        db.conectar();
        try {
            Statement sta = db.getConexionBD().createStatement();
            sta.execute(sql);
            db.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public Producto Buscar(int id) {
        Producto pro = new Producto();
        try {

            String sql = "SELECT * FROM \"HIP_PRODUCTOS\" WHERE prod_id =" + id;
            System.out.println("Base " + sql);

            db.conectar();
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery(sql);

            res.next();

            pro.setId(id);
            pro.setNombre(res.getString("PROD_NOMBRE"));
            pro.setCodBarra(res.getString("PROD_CODIGOBARRA"));
            pro.setPrecio(res.getDouble("PROD_PRECIO"));
            pro.setStock(res.getInt("PROD_STOCK"));
            String c = res.getString("PROD_NACIONALIDAD");
            pro.setNacionalidad(c.charAt(0));
            c = res.getString("PROD_IVA");
            pro.setIva(c.charAt(0));
            pro.setUm(un.Buscaar(res.getInt("HIP_MEDIDAS_MED_ID")));
            pro.setCp(cc.Buscar(res.getInt("HIP_CATEGORIAS_CAT_ID")));
            System.out.println(pro.toString());

            res.close();
            sta.close();
            db.desconectar();

        } catch (SQLException error) {

            error.printStackTrace();

        }

        return pro;
    }

    public Producto BuscarNombre(String nombre) {
        Producto pro = new Producto();
        try {

            String sql = "SELECT * FROM \"HIP_PRODUCTOS\" WHERE prod_nombre ='" + nombre + "'";
            System.out.println("Base " + sql);

            db.conectar();
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery(sql);

            res.next();

            pro.setId(res.getInt("PROD_ID"));
            pro.setNombre(nombre);
            pro.setCodBarra(res.getString("PROD_CODIGOBARRA"));
            pro.setPrecio(res.getDouble("PROD_PRECIO"));
            pro.setStock(res.getInt("PROD_STOCK"));
            String c = res.getString("PROD_NACIONALIDAD");
            pro.setNacionalidad(c.charAt(0));
            c = res.getString("PROD_IVA");
            pro.setIva(c.charAt(0));
            pro.setUm(un.Buscaar(res.getInt("HIP_MEDIDAS_MED_ID")));
            pro.setCp(cc.Buscar(res.getInt("HIP_CATEGORIAS_CAT_ID")));
            System.out.println(pro.toString());

            res.close();
            sta.close();
            db.desconectar();

        } catch (SQLException error) {

            error.printStackTrace();

        }

        return pro;
    }

    public int buscarUltimoCodigo() {
        int resultado = 0;
        db.conectar();
        try {
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery("SELECT MAX (\"PRO_ID\") FROM \"SDF_PRODUCTOS\"");
            res.next();
            resultado = res.getInt(1);
            db.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error en la buscarUltimoCodigo " + ex);
        }
        return resultado;
    }

    public Set<Producto> listaProductos() throws Exception {
        Set<Producto> listaProductos = new HashSet<Producto>();
        String sentenciaSQL = "SELECT * FROM \"SDF_PRODUCTOS\" ";
        db.conectar();
        try {
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery(sentenciaSQL);
            while (res.next()) {

                Producto pro = new Producto();

                pro.setId(res.getInt("PRO_ID"));
                pro.setNombre(res.getString("PRO_NOMBRE"));
                pro.setCodBarra(res.getString("PRO_COD_BARRA"));
                pro.setPrecio(res.getDouble("PRO_PRECIO"));
                pro.setStock(res.getInt("PRO_STOCK"));
                String c = res.getString("PRO_NACIO");
                pro.setNacionalidad(c.charAt(0));
                c = res.getString("PRO_IVA");
                pro.setIva(c.charAt(0));
                pro.setUm(un.Buscaar(res.getInt("SDF_UNIDADES_MEDIDAS_MED_ID")));
                pro.setCp(cc.Buscar(res.getInt("SDF_CATEGORIAS_CAT_ID")));
                //System.out.println(p.toString());
                listaProductos.add(pro);

            }
            sta.close();
            res.close();
            db.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error Listar Personas: " + ex);
        }
        return listaProductos;
    }
    
     public void modificarStock(Producto p,int cantidad) throws SQLException {
         int sumar=p.getStock()+cantidad;
         System.out.println("11111111111 "+p.getStock()+" "+cantidad);
        String sql = "UPDATE\"SDF_PRODUCTOS\" SET "
                + "\"PRO_STOCK\"=" +sumar
                + " WHERE \"PRO_ID\" = " + p.getId();
        System.out.println(sql);
        db.conectar();
        try {
            Statement sta = db.getConexionBD().createStatement();
            sta.execute(sql);
            db.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void modificar(Producto p) throws SQLException {
        String sql = "UPDATE\"SDF_PRODUCTOS\" SET "
                + "\"PRO_COD_BARRA\"='" + p.getCodBarra() + "',"
                + "\"PRO_NOMBRE\"='" + p.getNombre() + "',"
                + "\"PRO_PRECIO\"=" + p.getPrecio() + ","
                + "\"PRO_NACIO\"='" + p.getNacionalidad() + "',"
                + "\"SDF_UNIDADES_MEDIDAS_MED_ID\"=" + p.getUm().getId() + ","
                + "\"SDF_CATEGORIAS_CAT_ID\"=" + p.getCp().getId() + ","
                + "\"PRO_IVA\"='" + p.getIva() + "'"
                + "WHERE \"PRO_ID\" = " + p.getId();
        System.out.println(sql);
        db.conectar();
        try {
            Statement sta = db.getConexionBD().createStatement();
            sta.execute(sql);
            db.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void eliminar(int id){
        String sql = "DELETE\"SDF_PRODUCTOS\" WHERE \"PRO_ID\" = " + id;
        System.out.println(sql);
        db.conectar();
        try {
            Statement sta = db.getConexionBD().createStatement();
            sta.execute(sql);
            db.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
