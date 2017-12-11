/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Producto;
import Modelo.Proveedor;
import Modelo.Stock;
import Vista.VentanaStock;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Abuelito
 */
public class EventoStock implements ActionListener {

    private VentanaStock vStock;

    public EventoStock(VentanaStock vStock) {
        this.vStock = vStock;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.vStock.getBotonList().get(0))) {
            try {
                int n = Integer.parseInt(this.vStock.getTxtList().get(0).getText());
                int n1 = Integer.parseInt(this.vStock.getTxtList().get(1).getText());
                String pr = this.vStock.getCombobox().getSelectedItem().toString();
                String prov = this.vStock.getCombobox1().getSelectedItem().toString();
                boolean res = this.vStock.getgD().buscarStocklogico(pr, prov);
                if (res == true) {
                    JOptionPane.showMessageDialog(vStock, "Mercancia ya  Registrada ", "Error Registro", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    Producto p = this.vStock.getgD().buscarProducto(pr);
                    Proveedor prvd = this.vStock.getgD().buscarProveedor(prov);
                    Stock s = new Stock(n, n1, p, prvd);
                    this.vStock.getgD().addStock(s);
                    Object[][] datostock = this.vStock.cargarDatosTabla(this.vStock.getgD().getStockList().size(), 4);
                    this.vStock.setDatos(datostock);
                    this.vStock.getModeloTabla().setDataVector(this.vStock.getDatos(), this.vStock.getEncabezado());
                    this.vStock.getgD().guardarArchivoStock();
                }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(vStock, "Todos los campos son necesarios ", "Error Registro", JOptionPane.ERROR_MESSAGE);
            } catch (NullPointerException npe) {
                JOptionPane.showMessageDialog(vStock, "Todos los campos son necesarios ", "Error Registro", JOptionPane.ERROR_MESSAGE);

            }
        }
        if (e.getSource().equals(this.vStock.getBotonList().get(1))) {
            this.vStock.getTxtList().get(0).setText("");
            this.vStock.getTxtList().get(1).setText("");
        }
    }

}
