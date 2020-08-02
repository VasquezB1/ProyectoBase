/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Domenica
 */
public class FCabecera {
    
    
    private int id;
    private String fecha;
    private char estado;
    private double subtotal;
    private double iva;
    private double total;
    private String CedPer;
    
    //Clases
    
    private Personas per;
    private Producto pro;
    private List<FDetalle> detalle;

    public FCabecera() {
        
        detalle = new ArrayList<>();
        //fecha = new Date();                
        iva = 0.12;
        
    }



    public void añadirFacDetalle(FDetalle fDet){
        detalle.add(fDet);
    }

    public FCabecera(int id, String fecha,char estado, double subtotal, double iva, double total,  String CedPer, Personas per, Producto pro, List<FDetalle> detalle) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.CedPer = CedPer;
        this.per = per;
        this.pro = pro;
        this.detalle = detalle;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
     public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

   

    public String getCedPer() {
        return CedPer;
    }

    public void setCedPer(String CedPer) {
        this.CedPer = CedPer;
    }

    public Personas getPer() {
        return per;
    }

    public void setPer(Personas per) {
        this.per = per;
    }

    public Producto getPro() {
        return pro;
    }

    public void setPro(Producto pro) {
        this.pro = pro;
    }

    public List<FDetalle> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<FDetalle> detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        //fecha = new Date();
        //SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
       
        return "FCabecera{" + "id=" + id + ", fecha=" + fecha + ", subtotal=" + subtotal + ", iva=" + iva + ", total=" + total + ", estado=" + estado + ", CedPer=" + CedPer + ", per=" + per + ", pro=" + pro + ", detalle=" + detalle + '}';    
    }
    }
