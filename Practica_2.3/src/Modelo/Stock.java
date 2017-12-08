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
public class Stock {
    private int cantidadMax;
    private int cantidadMin;
    private Producto producto;
    private Proveedor proveedor;

    public Stock(int cantidadMax, int cantidadMin, Producto producto, Proveedor proveedor) {
        this.cantidadMax = cantidadMax;
        this.cantidadMin = cantidadMin;
        this.producto = producto;
        this.proveedor = proveedor;
    }

    public int getCantidadMax() {
        return cantidadMax;
    }

    public void setCantidadMax(int cantidadMax) {
        this.cantidadMax = cantidadMax;
    }

    public int getCantidadMin() {
        return cantidadMin;
    }

    public void setCantidadMin(int cantidadMin) {
        this.cantidadMin = cantidadMin;
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
            return cantidadMax + "|" + cantidadMin + "|" + producto + "|" + proveedor;
    }
    
    
}
