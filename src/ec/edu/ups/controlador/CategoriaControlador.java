/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.CategoriaProducto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Edison
 */
public class CategoriaControlador {
    
    private int codigo;
    
    
    private BaseDeDatos db;

    public CategoriaControlador(String url ,String user, String password) {      
         db= new BaseDeDatos(url,user,password);
    }
    
    public void create(CategoriaProducto categoriaProducto){
        String sql = "INSERT INTO \"HIP_CATEGORIAS\" VALUES(" + categoriaProducto.getId() + ","
                + "'" + categoriaProducto.getNombre() + "')";
        System.out.println(sql);
        
         db.conectar();
        try {
            Statement sta = db.getConexionBD().createStatement();
            sta.execute(sql);
            db.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    }public CategoriaProducto Buscar(int id){
        CategoriaProducto cat = new CategoriaProducto();
        try {

            String sql = "SELECT * FROM \"HIP_CATEGORIAS\" WHERE cat_id =" + id;
            System.out.println("Base " + sql);

            db.conectar();
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery(sql);

          res.next();

                cat.setId(id);
                cat.setNombre(res.getString("CAT_NOMBRE"));
                System.out.println(cat.toString());
                
            
            res.close();
            sta.close();
            db.desconectar();

        } catch (SQLException error) {

            error.printStackTrace();

        }
      
        return cat;
    }
    
    public Set<CategoriaProducto> listaCategoria() throws Exception {
        Set<CategoriaProducto> listaCategoria = new HashSet<CategoriaProducto>();
        String sentenciaSQL = "SELECT * FROM \"HIP_CATEGORIAS\" ";
        db.conectar();
        try {
            Statement sta = db.getConexionBD().createStatement();
            ResultSet rs = sta.executeQuery(sentenciaSQL);
            while (rs.next()) {
                CategoriaProducto c = new CategoriaProducto();
                c.setId(rs.getInt("CAT_ID"));
                c.setNombre(rs.getString("cat_nombre"));
                
                //System.out.println(p.toString());
                listaCategoria.add(c);
                
            }
            sta.close();
            rs.close();
            db.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error Listar Personas: " + ex);
        }
        return listaCategoria;
    } 
    
    public void modificar(CategoriaProducto c) throws SQLException {
        String sql = "UPDATE\"SDF_CATEGORIAS\" SET "
                + "\"CAT_NOMBRE\"='" + c.getNombre() + "'"
                + "WHERE \"CAT_ID\" = " + c.getId();
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
    
    public int buscarUltimoCodigo() {
        int resultado = 0;
        db.conectar();
        try {
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery("SELECT MAX (\"CAT_ID\") FROM \"HIP_CATEGORIAS\"");
            res.next();
            resultado = res.getInt(1);
            db.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error en la buscarUltimoCodigo " + ex);
        }
        return resultado;
    }
    
    public void eliminar(int id){
        
    }
}
