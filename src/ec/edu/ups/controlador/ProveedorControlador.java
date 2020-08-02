/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Proveedor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author srcti
 */
public class ProveedorControlador {
    
 private BaseDeDatos db;
    private Set<Proveedor> lista;


    public ProveedorControlador(String url, String user, String password) {
        db = new BaseDeDatos(url, user, password);

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
            ResultSet res = sta.executeQuery("SELECT MAX (\"PRO_ID\") FROM \"HIP_PROVEEDORES\"");
            res.next();
            resultado = res.getInt(1);
            db.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error en la buscarUltimoCodigo " + ex);
        }
        return resultado;
    }

    public void createProveedor(Proveedor p) {

        String sql = "INSERT INTO \"HIP_PROVEEDORES\" VALUES('" + p.getId()+ "',"
                + "'" + p.getEmpresa()+ "',"
                + "'"+ p.getResponsable()+ "'"
                + ")";

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

    public Proveedor BuscarProveedorNombre(String nombre) {

        Proveedor prov = new Proveedor();

        try {

            String sql = "SELECT * FROM \"HIP_PROVEEDORES\"WHERE\"PRO_RESPONSABLE\"= '" + nombre + "'";

            db.conectar();
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery(sql);

            while (res.next()) {

                prov.setId(res.getInt("PRO_ID"));
                prov.setResponsable(nombre);
                
            }
            res.close();
            sta.close();
            db.desconectar();

        } catch (SQLException error) {
            error.printStackTrace();
        }

        return prov;

    }

    public Proveedor BuscarProveedorCodigo(int codigo) {

        Proveedor prov = new Proveedor();

        try {

            String sql = "SELECT * FROM \"HIP_PROVEEDORES\"WHERE\"PRO_ID\"= '" + codigo + "'";

            db.conectar();
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery(sql);

            while (res.next()) {

                prov.setId(codigo);
                prov.setEmpresa(res.getString("PRO_EMPRESA"));
                prov.setResponsable(res.getString("PRO_RESPONSABLE"));
            }
            res.close();
            sta.close();
            db.desconectar();

        } catch (SQLException error) {
            error.printStackTrace();
        }

        return prov;

    }

    public void modificarProveedor(Proveedor p) throws SQLException {

        String sql = "UPDATE\"HIP_PROVEEDORES\" SET "
                + "\"PRO_EMPRESA\"='" + p.getEmpresa()
                + "\"PRO_RESPONSABLE\"='" + p.getEmpresa()
                + "WHERE \"PRO_ID\" = " + p.getId() + "";

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

      public Set<Proveedor> listaProveedor() throws Exception {
        Set<Proveedor> listaProv = new HashSet<Proveedor>();
        String sentenciaSQL = "SELECT * FROM \"HIP_PROVEEDORES\" ";
        db.conectar();
        try {
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery(sentenciaSQL);
            while (res.next()) {

                Proveedor prov = new Proveedor();
                prov.setId(res.getInt("PRO_ID"));
                prov.setEmpresa(res.getString("PRO_EMPRESA"));
                prov.setResponsable(res.getString("PRO_RESPONSABLE"));
                //System.out.println(p.toString());
                listaProv.add(prov);

            }
            sta.close();
            res.close();
            db.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error Listar Proveedores: " + ex);
        }
        return listaProv;
    }
   

}
