/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Rol;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * 
 */
public class RolesControlador {
    private BaseDeDatos db;
    
    public RolesControlador (String url ,String user, String password) {
        db= new BaseDeDatos(url,user,password);
    }
    /**
        * Retorna la lista de Personas en la base de Datos
     *
     * @return
     * @throws Exception
     */
    public Set<Rol> listaRoles() throws Exception {
        Set<Rol> lista = new HashSet<Rol>();
        String sentenciaSQL = "SELECT * FROM \"SDF_ROLES\" ";
        db.conectar();
        try {
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery(sentenciaSQL);
            while (res.next()) {
            Rol r = new Rol();
                r.setCodigo(res.getInt("ROL_ID"));
                r.setDescripcion(res.getString("ROL_DESCRIPCION"));                
                lista.add(r);
            }
            sta.close();
            res.close();
            db.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error Listar Roles: " + ex);
        }
        return lista;
    } 
      
}
