/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.Date;

/**
 *
 * @author Edison
 */
public class ProductoProveedor {

    private int id;
    private String nroFActura;
    private Date fechaLlegada;
    private int cantidad;
    private Producto producto;
    private Proveedor proveedor;

    public ProductoProveedor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getNroFActura() {
        return nroFActura;
    }

    public void setNroFActura(String nroFActura) {
        this.nroFActura = nroFActura;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return "ProductoProveedor{" + "id=" + id + ", nroFActura=" + nroFActura + ", fechaLlegada=" + fechaLlegada + ", cantidad=" + cantidad + ", producto=" + producto + ", proveedor=" + proveedor + '}';
    }

}
