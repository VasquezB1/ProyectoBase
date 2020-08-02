/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

/**
 *
 * @author Edison
 */
public class Proveedor {

    private int id;
    private String empresa;
    private String responsable;
    

    public Proveedor() {
    }

    public Proveedor(int id, String empresa, String responsable) {
        this.id = id;
        this.empresa = empresa;
        this.responsable = responsable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "id=" + id + ", empresa=" + empresa + ", responsable=" + responsable + '}';
    }

  
  
}
