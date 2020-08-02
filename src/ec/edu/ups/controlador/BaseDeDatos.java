/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jose Guillermo Quinde
 */
public class BaseDeDatos {
    
    private Connection connection;
    private String url;
    private String user;
    private String password;
    
    public BaseDeDatos() {
    }

    public BaseDeDatos(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }
    
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    public Connection getConexionBD() {
        return connection;
    }
    
    public void conectar(){
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
       // String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "HiperMercado";
        String password = "administrador";
        try {
            connection = DriverManager.getConnection(url,user,password);
            if (connection.isValid(2000)) {
                System.out.println("Conectado!");
            } else {
                System.out.println("No se pudo conectar!");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void desconectar(){
        try{
            if(!connection.isClosed()){
                connection.close();
                System.out.println("Desconectado");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public int getCode(String nombreColumna, String nombreTabla){
        int code = 0;
        //SELECT MAX(salary) "Maximum" FROM employees;
        String sql = "SELECT MAX(" + nombreColumna + ") FROM " + nombreTabla;
        conectar();
        try {
            Statement sta = connection.createStatement();
            ResultSet rs = sta.executeQuery(sql);
            if (rs.next()) {
                code = rs.getInt(1);
                code++;
            }
            rs.close();
            sta.close();
            desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return code;
    }
    
}
