/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Producto;
import Modelo.Proveedor;
import Modelo.Stock;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Abuelito
 */
public class GestionDato {

    private List<Producto> productoList;
    private List<Proveedor> proveedorList;
    private List<Stock> stockList;

    public GestionDato(List<Producto> productoList, List<Proveedor> proveedorList, List<Stock> stockList) {
        this.productoList = productoList;
        this.proveedorList = proveedorList;
        this.stockList = stockList;
    }

    public boolean addProveedor(Proveedor p) {
        return this.proveedorList.add(p);
    }

    public boolean addProducto(Producto p) {
        return this.productoList.add(p);
    }

    public boolean addStock(Stock s) {
        return this.stockList.add(s);
    }

    public boolean buscarProductologico(String name) {
        boolean retorno = false;
        for (Producto pro : this.productoList) {
            if (pro.getNombre().equals(name)) {
                return true;
            }
        }
        return retorno;
    }

    public boolean buscarStocklogico(String name,String name1) {
        boolean retorno = false;
        for (Stock st : this.stockList) {
            if (st.getProducto().getNombre().equals(name) && st.getProveedor().getNombreYApellido().equals(name1)) {
                return true;
            }
        }
        return retorno;
    }

    public boolean buscarProveedorlogico(String name) {
        boolean retorno = false;
        for (Proveedor pro : this.proveedorList) {
            if (pro.getNombreYApellido().equals(name)) {
                return true;
            }
        }
        return retorno;
    }

    public Proveedor buscarProveedor(String txt) {
        Proveedor retorno = null;
        for (Proveedor pro : this.proveedorList) {
            if (pro.getNombreYApellido().equals(txt)) {

                return pro;
            }
        }
        return retorno;
    }

    public Producto buscarProducto(String txt) {
        Producto retorno = null;
        for (Producto pro : this.productoList) {
            if (pro.getNombre().equals(txt)) {
                return pro;
            }
        }
        return retorno;
    }

    public String leerArchivo(String ruta) {
        FileReader fr = null;
        BufferedReader br = null;

        String contenido = "";
        try {

            fr = new FileReader(ruta);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido += linea + "\n";
            }
        } catch (Exception e) {
        } finally {
            try {
                br.close();
            } catch (Exception ex) {
            }
        }
        return contenido;
    }

    public boolean LeerArchivoProducto() {
        try {
            FileInputStream fr = new FileInputStream("C://Practica3//Producto.dat");
            DataInputStream leer = new DataInputStream(fr);

            while (true) {

                int cod = leer.readInt();
                String nom = leer.readUTF();
                String pre = leer.readUTF();
                Producto pro = new Producto(cod, nom, pre);

                System.out.println("" + pro.toString());

            }

        } catch (IOException ae) {
            return false;
        }

    }

    public boolean LeerArchivoProveedor() {
        try {
            FileInputStream fr = new FileInputStream("C://Practica3//Proveedor.dat");
            DataInputStream leer = new DataInputStream(fr);

            while (true) {

                String name = leer.readUTF();
                String ruc = leer.readUTF();
                String telf = leer.readUTF();
                String dir = leer.readUTF();
                Proveedor pro = new Proveedor(name, ruc, telf, dir);
                System.out.println("" + pro.toString());

            }

        } catch (IOException ae) {
            return false;
        }

    }

    public boolean LeerArchivoStock() {
        try {
            FileInputStream fr = new FileInputStream("C://Practica3//Stock.dat");
            DataInputStream leer = new DataInputStream(fr);

            while (true) {
                int max = leer.readInt();
                int min = leer.readInt();
                String nameprod = leer.readUTF();
                Producto prod = this.buscarProducto(nameprod);
                String nameprove = leer.readUTF();
                Proveedor prove = this.buscarProveedor(nameprove);
                Stock sto = new Stock(max, min, prod, prove);
                System.out.println("" + sto.toString());

            }

        } catch (IOException ae) {
            return false;
        }

    }

    public boolean guardarArchivoProducto() {
        try {

            FileOutputStream ae = new FileOutputStream("C://Practica3//Producto.dat", true);
            DataOutputStream escritura = new DataOutputStream(ae);
            for (Producto p : this.productoList) {
                escritura.writeInt(p.getCodigo());
                escritura.writeUTF(p.getNombre());
                escritura.writeUTF(p.getPrecio());
            }
            escritura.close();
            return true;
        } catch (IOException e1) {

            return false;
        }
    }

    public boolean guardarArchivoStock() {
        try {

            FileOutputStream ae = new FileOutputStream("C://Practica3//Stock.dat", true);
            DataOutputStream escritura = new DataOutputStream(ae);
            for (Stock a : this.stockList) {
                escritura.writeInt(a.getCantidadMax());
                escritura.writeInt(a.getCantidadMin());
                escritura.writeUTF(a.getProducto().getNombre());
                escritura.writeUTF(a.getProveedor().getNombreYApellido());

            }
            escritura.close();
            return true;
        } catch (IOException e1) {

            return false;
        }
    }

    public boolean guardarArchivoProveedor() {
        try {
            File fichero = new File("C://Practica3");
            fichero.mkdir();
            if (fichero.exists()) {
                
            FileOutputStream ae = new FileOutputStream("C://Practica3//Proveedor.dat", true);
            DataOutputStream escritura = new DataOutputStream(ae);
            for (Proveedor pro : this.proveedorList) {
                escritura.writeUTF(pro.getNombreYApellido());
                escritura.writeUTF(pro.getRuc());
                escritura.writeUTF(pro.getTelefono());
                escritura.writeUTF(pro.getDireccion());

            }
            escritura.close();
            }
            return true;
        } catch (IOException e1) {

            return false;
        }
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    public List<Proveedor> getProveedorList() {
        return proveedorList;
    }

    public void setProveedorList(List<Proveedor> proveedorList) {
        this.proveedorList = proveedorList;
    }

    public List<Stock> getStockList() {
        return stockList;
    }

    public void setStockList(List<Stock> stockList) {
        this.stockList = stockList;
    }

}
