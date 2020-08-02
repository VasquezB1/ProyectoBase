/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.UnidadMedida;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Edison
 */
public class UnidadesControlador {
    
    private BaseDeDatos db;

    public UnidadesControlador(String url ,String user, String password) {
        db = new BaseDeDatos(url,user,password);
    }
    
    public void create(UnidadMedida u){
        String sql = "INSERT INTO \"SDF_UNIDADES_MEDIDAS\" VALUES(" + u.getId() + ","
                + "'" + u.getNombre() + "')";
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
     
    public UnidadMedida Buscaar(int id)  {
        UnidadMedida un = new UnidadMedida();
        try {

            String sql = "SELECT * FROM \"HIP_MEDIDAS\" WHERE med_id =" + id + "";
            System.out.println("Base " + sql);

            db.conectar();
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery(sql);

          res.next();

                un.setId(id);
                un.setNombre(res.getString("med_medida")); 
                System.out.println(un.toString());
                
            res.close();
            sta.close();
            db.desconectar();

        } catch (SQLException error) {

            error.printStackTrace();

        }
      
        return un;
    }
    
    public int buscarUltimoCodigo() {
        int resultado = 0;
        db.conectar();
        try {
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery("SELECT MAX (\"MED_ID\") FROM \"SDF_UNIDADES_MEDIDAS\"");
            res.next();
            resultado = res.getInt(1);
            db.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error en la buscarUltimoCodigo " + ex);
        }
        return resultado;
    }
    
    public Set<UnidadMedida> listaUn() throws Exception {
        Set<UnidadMedida> listaUnidad = new HashSet<UnidadMedida>();
        String sentenciaSQL = "SELECT * FROM \"SDF_UNIDADES_MEDIDAS\" ";
        db.conectar();
        try {
            Statement sta = db.getConexionBD().createStatement();
            ResultSet rs = sta.executeQuery(sentenciaSQL);
            while (rs.next()) {
                UnidadMedida u = new UnidadMedida();
                u.setId(rs.getInt("MED_ID"));
                u.setNombre(rs.getString("MED_nombre"));
                
                //System.out.println(p.toString());
                listaUnidad.add(u);
                
            }
            sta.close();
            rs.close();
            db.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error Listar Personas: " + ex);
        }
        return listaUnidad;
    } 
    
    public void modificar(UnidadMedida u) throws SQLException {
        String sql = "UPDATE\"SDF_UNIDADES_MEDIDAS\" SET "
                + "\"MED_NOMBRE\"='" + u.getNombre() + "'"
                + "WHERE \"MED_ID\" = " + u.getId();
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
