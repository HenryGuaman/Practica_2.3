/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Proveedor;
import Vista.VentanaProveedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Abuelito
 */
public class EventoProveedor implements ActionListener {

    private VentanaProveedor vProveedor;

    public EventoProveedor(VentanaProveedor vProveedor) {
        this.vProveedor = vProveedor;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.vProveedor.getBotonList().get(0))) {
            try {
                String n = this.vProveedor.getTxtList().get(0).getText();
                String ruc = this.vProveedor.getTxtList().get(1).getText();
                String telf = this.vProveedor.getTxtList().get(2).getText();
                String dir = this.vProveedor.getTxtList().get(3).getText();

                if (n.equals("") || ruc.equals("") || telf.equals("") || dir.equals("")) {
                    JOptionPane.showMessageDialog(vProveedor, "Todos los campos son obligatorios ", "Falta Informacion", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    boolean res = this.vProveedor.getgD().buscarProveedorlogico(n);

                    if (res == true) {
                        JOptionPane.showMessageDialog(vProveedor, "Proveedor ya  Registrado ", "Error Registro", JOptionPane.INFORMATION_MESSAGE);
                        this.vProveedor.getTxtList().get(0).setText("");
                        this.vProveedor.getTxtList().get(1).setText("");
                        this.vProveedor.getTxtList().get(2).setText("");
                        this.vProveedor.getTxtList().get(3).setText("");
                    } else {
                        Proveedor pro = new Proveedor(n, ruc, telf, dir);
                        this.vProveedor.getgD().addProveedor(pro);
                        Object[][] datoProveedor = this.vProveedor.cargaDatosTabla(this.vProveedor.getgD().getProveedorList().size(), 4);
                        this.vProveedor.setDatos(datoProveedor);
                        this.vProveedor.getModeloTabla().setDataVector(this.vProveedor.getDatos(), this.vProveedor.getEncabezado());
                        this.vProveedor.getgD().guardarArchivoProveedor();
                    }
                }
            } catch (NumberFormatException numb) {
                JOptionPane.showMessageDialog(vProveedor, "Edad es un numero entero");
            }
        }
        
        if (e.getSource().equals(this.vProveedor.getBotonList().get(1))) {
            this.vProveedor.getTxtList().get(0).setText("");
            this.vProveedor.getTxtList().get(1).setText("");
            this.vProveedor.getTxtList().get(2).setText("");
            this.vProveedor.getTxtList().get(3).setText("");
            }

    }
}
