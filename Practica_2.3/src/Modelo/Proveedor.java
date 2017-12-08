/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Proveedor {

    private String nombreYApellido;
    private String ruc;
    private String telefono;
    private String direccion;

    public Proveedor(String nombreYApellido, String ruc, String telefono, String direccion) {
        this.nombreYApellido = nombreYApellido;
        this.ruc = ruc;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public void asignarDatos(String d) {
        int pos1 = 0;
        int pos2 = 0;
        int pos3=  0;
        for (int i = 0; i < d.length(); i++) {
            if (d.charAt(i) == 124 && pos1 == 0) {
                pos1 = i;
            }
            if (d.charAt(i) == 124 && pos1 != 0) {
                pos2 = i;
            }
            if (d.charAt(i) == 124 && pos2 != 0) {
                pos3 = i;
            }
        }

        this.nombreYApellido = d.substring(0, pos1 - 1);
        this.ruc = d.substring(pos1 + 2, pos2 - 1);
        this.telefono = d.substring(pos2 + 2, pos3-1);
        this.direccion=d.substring(pos3+2, d.length());
    }

    public String getNombreYApellido() {
        return nombreYApellido;
    }

    public void setNombreYApellido(String nombreYApellido) {
        this.nombreYApellido = nombreYApellido;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return nombreYApellido + "|" + ruc + "|" + telefono + "|" + direccion;
    }

}
