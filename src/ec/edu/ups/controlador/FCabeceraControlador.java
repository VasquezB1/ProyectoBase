
package ec.edu.ups.controlador;
import ec.edu.ups.controlador.BaseDeDatos;
import ec.edu.ups.controlador.PersonaControlador;
import ec.edu.ups.modelo.FCabecera;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class FCabeceraControlador {

    private BaseDeDatos db;
    private Set<FCabecera> lista;
    private int ruc;

    private PersonaControlador per;

    public Set<FCabecera> getFFactura() {
        return lista;
    }

    public FCabeceraControlador() {

        lista = new HashSet<>();

    }

    public int getRuc() {
        return ruc;
    }

    public FCabeceraControlador(String url, String user, String password) {

        db = new BaseDeDatos(url, user, password);
        per = new PersonaControlador(url, user, password);

    }

    /**
     * Te devuelve el ultimo codigo del ultimo registro de la base de datos
     *
     * @return
     */
    public int buscarUltimoCodigo() {
        int resultado = 0;
        db.conectar();
        try {
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery("SELECT MAX (\"FAC_ID\") FROM \"HIP_FCATURA_CABECERAS\"");
            res.next();
            resultado = res.getInt(1);
            db.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error en la buscarUltimoCodigo " + ex);
        }
        return resultado;
    }

    public void createFacCab(FCabecera facCab) {
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        //String fecha = sdf.format(facCab.getFecha());
        String sql = "INSERT INTO \"HIP_FCATURA_CABECERAS\" VALUES("
                + facCab.getId()+ ",'"
                + facCab.getFecha() + "','"
                + facCab.getEstado() + "',"
                + facCab.getSubtotal() + ","
                + facCab.getIva() + ","
                + facCab.getTotal() + ",'"
                + facCab.getPer().getId() + "'"
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

    public void create(FCabecera fcab) {

        fcab.setId(buscarUltimoCodigo());
        lista.add(fcab);

    }

    public FCabecera BuscarFacCab(int id) {

        FCabecera facCab = new FCabecera();

        try {

            String sql = "SELECT * FROM \"HIP_FCATURA_CABECERAS\" WHERE fac_id = " + id + "";
            System.out.println("BASE: " + sql);

            db.conectar();
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery(sql);

            while (res.next()) {
                String m = res.getString("FAC_ESTADO");
                facCab.setId(id);
                facCab.setFecha(res.getString("FAC_FECHA"));
                facCab.setSubtotal(res.getDouble("FAC_SUBTOTAL"));
                facCab.setIva(res.getDouble("FAC_IVA"));
                facCab.setTotal(res.getDouble("FAC_TOTAL"));
                facCab.setEstado(m.charAt(0));
                facCab.setPer(per.buscarid(res.getString("HIP_PERSONAS_PER_ID")));

            }
            res.close();
            sta.close();
            db.desconectar();

        } catch (SQLException error) {
            error.printStackTrace();
        }

        return facCab;

    }

    /*
     public FCabecera BuscarFacCab1(int ruc) {

     //FCabecera facCab = new FCabecera();
     for (FCabecera fac : lista) {

     if (fac.getRuc() == ruc) {

     return fac;

     }

     }
     return null;
     }*/
    public void modificar(FCabecera faC) throws SQLException {
        System.out.println("*******************************");
        String sql = "UPDATE \"HIP_FCATURA_CABECERAS\" SET "
                + "FAC_ESTADO = '" + faC.getEstado() + "'"
                + " WHERE \"FAC_ID\" = " + faC.getId() + "" /*+
                "commit;"*/;

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

    public Set printFacCab() {

        //Set<FCabecera> lista = new HashSet<>();
        try {

            String sql = "SELECT * FROM \"HIP_FCATURA_CABECERAS\" ";
            System.out.println("Base listar" + sql);

            db.conectar();
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery(sql);

            while (res.next()) {

                FCabecera facCab = new FCabecera();
                facCab.setId(res.getInt("fac_ruc"));
                facCab.setFecha(res.getString("fac_fecha"));
                facCab.setSubtotal(res.getDouble("fac_subtotal"));
                facCab.setIva(res.getDouble("fac_iva"));
                facCab.setTotal(res.getDouble("fac_total"));

            }

            res.close();
            sta.close();
            db.desconectar();
        } catch (SQLException error) {

            error.printStackTrace();

        }
        return lista;
    }

}
