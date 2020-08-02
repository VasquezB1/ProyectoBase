/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.Date;

/**
 *
 */
public class FDetalle {

    private int id;
    private int cant;
    private double precioUnitario;
    private double ivaPro;
    private double totalCP;
    private int rucFac;
    private int codPro;

    //Clase
    private Producto pro;
    private FCabecera fcab;

    public FDetalle() {
    }

    public FDetalle(int id, int cant, double precioUnitario, double ivaPro, double totalCP, int rucFac, int codPro, Producto pro, FCabecera fcab) {
        this.id = id;
        this.cant = cant;
        this.precioUnitario = precioUnitario;
        this.ivaPro = ivaPro;
        this.totalCP = totalCP;
        this.rucFac = rucFac;
        this.codPro = codPro;
        this.pro = pro;
        this.fcab = fcab;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getIvaPro() {
        return ivaPro;
    }

    public void setIvaPro(double ivaPro) {
        this.ivaPro = ivaPro;
    }

    public double getTotalCP() {
        return totalCP;
    }

    public void setTotalCP(double totalCP) {
        this.totalCP = totalCP;
    }

    public int getRucFac() {
        return rucFac;
    }

    public void setRucFac(int rucFac) {
        this.rucFac = rucFac;
    }

    public int getCodPro() {
        return codPro;
    }

    public void setCodPro(int codPro) {
        this.codPro = codPro;
    }

    public Producto getPro() {
        return pro;
    }

    public void setPro(Producto pro) {
        this.pro = pro;
    }

    public FCabecera getFcab() {
        return fcab;
    }

    public void setFcab(FCabecera fcab) {
        this.fcab = fcab;
    }

    @Override
    public String toString() {
        return "FDetalle{" + "id=" + id + ", cant=" + cant + ", precioUnitario=" + precioUnitario + ", ivaPro=" + ivaPro + ", totalCP=" + totalCP + ", rucFac=" + rucFac + ", codPro=" + codPro + ", pro=" + pro + ", fcab=" + fcab + '}';
    }

    

}
