/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.controlador.BaseDeDatos;
import ec.edu.ups.modelo.FDetalle;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author srcti
 */
public class FDetalleControlador {

    private BaseDeDatos            db;
    private int codigo;
    private Set<FDetalle> lista;
    private FCabeceraControlador cabeceraControlador;
    private ControladorProducto controladorProducto;

    public int getCodigo() {
        return codigo;
    }

    public Set<FDetalle> getLista() {
        return lista;
    }

    public FDetalleControlador() {

        lista = new HashSet<>();
        codigo = 0;
        

    }

    public FDetalleControlador(String url, String user, String password) {

        db = new BaseDeDatos(url, user, password);
        this.cabeceraControlador = new FCabeceraControlador(url, user, password);
        this.controladorProducto = new ControladorProducto(url, user, password);
        

    }

    public int buscarUltCodigo() {
    int resultado = 0;
        db.conectar();
        try {
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery("SELECT MAX (\"FAD_ID\") FROM \"HIP_FACTURA_DETALLES\"");
            res.next();
            resultado = res.getInt(1);
            db.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error en la buscarUltimoCodigo " + ex);
        }
        return resultado;
    }

    public void createFacDet(FDetalle facDet) {

        String sql = "INSERT INTO \"HIP_FACTURA_DETALLES\" VALUES("
                + facDet.getId()+ ","
                + facDet.getCant() + ","
                + facDet.getPrecioUnitario()+ ","
                + facDet.getIvaPro() + ","
                + facDet.getTotalCP() + ","
                + facDet.getRucFac() + ","
                + facDet.getCodPro() + ")";

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

    public void createFacDet1(FDetalle facDet) {

        codigo++;
        facDet.setId(buscarUltCodigo());
        lista.add(facDet);

    }

     public FDetalle BuscarFacDet(int codigo) {

        FDetalle facDet = new FDetalle();

        try {

            String sql = "SELECT * FROM \"HIP_FACTURA_DETALLES\"WHERE  hip_fcatura_cabeceras_fac_id = " + codigo;
            System.out.println("BASE " + sql);

            db.conectar();
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery(sql);

            while (res.next()) {

               // facDet.setCodigo(codigo);
                facDet.setCodPro(res.getInt("hip_productos_prod_id"));
                facDet.setCant(res.getInt("fad_cantidad"));
                //facDet.set
                //facDet.set
                facDet.setIvaPro(res.getDouble("fad_iva"));
                facDet.setTotalCP(res.getDouble("fad_preciototal"));

            }/*    fdt_precio_pro
            fdt_precio_iva
            fdt_total
            sdf_factura_cabeceras_fac_id*/
            res.close();
            sta.close();
            db.desconectar();

        } catch (SQLException error) {
            error.printStackTrace();
        }
        return facDet;

    }


    /*  public FDetalle BuscarFacCab1(int codigo) {

     for (FDetalle fac : lista) {
     if (fac.getCodigo() == codigo) {
     return fac;
     }
     }
     return null;

     }*/
    public Set printFacDet() {

        Set<FDetalle> lista = new HashSet<>();

        try {

            String sql = "SELECT * FROM \"HIP_FACTURAS_DETALLES\"";
            System.out.println("Base listar" + sql);

            db.conectar();
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery(sql);

            while (res.next()) {

                FDetalle facDet = new FDetalle();
                facDet.setId(res.getInt("codigo"));
                facDet.setCant(res.getInt("cantidad"));
                facDet.setTotalCP(res.getDouble("total"));

            }
            res.close();
            sta.close();
            db.desconectar();
        } catch (SQLException error) {

            error.printStackTrace();

        }
        return lista;
    }
    
    public Set<FDetalle> listarFacDet(int codigo) {
        Set<FDetalle> l = new HashSet<>();
        

        try {

            String sql = "SELECT * FROM \"HIP_FACTURAS_DETALLES\"WHERE hip_fcatura_cabeceras_fac_id = " + codigo;
            System.out.println("BASE " + sql);

            db.conectar();
            Statement sta = db.getConexionBD().createStatement();
            ResultSet res = sta.executeQuery(sql);

            while (res.next()) {
                FDetalle facDet = new FDetalle();
                facDet.setId(res.getInt("FAD_ID"));
                facDet.setCant(res.getInt("FAD_CANTIDAD"));
                facDet.setPrecioUnitario(res.getDouble("FAD_PRECIOUNITARIO"));
                facDet.setIvaPro(res.getDouble("FAD_IVA"));
                facDet.setTotalCP(res.getDouble("FAD_PRECIOTOTAL"));
                facDet.setFcab(cabeceraControlador.BuscarFacCab(res.getInt("hip_fcatura_cabeceras_fac_id")));
                facDet.setPro(controladorProducto.Buscar(res.getInt("HIP_PRODUCTOS_PRO_ID")));
                facDet.setCodPro(res.getInt("HIP_PRODUCTOS_PRO_ID"));
                facDet.setRucFac(codigo);
                System.out.println(facDet.toString());
                l.add(facDet);

            }/*    fdt_precio_pro
            fdt_precio_iva
            fdt_total
            sdf_factura_cabeceras_fac_id*/
            res.close();
            sta.close();
            db.desconectar();

        } catch (SQLException error) {
            error.printStackTrace();
        }
        return l;

    }

}
