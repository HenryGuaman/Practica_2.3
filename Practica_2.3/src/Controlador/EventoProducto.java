/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Producto;
import Modelo.Proveedor;
import Vista.VentanaProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Abuelito
 */
public class EventoProducto implements ActionListener{
    private VentanaProducto vProducto;

    public EventoProducto(VentanaProducto vProducto) {
        this.vProducto = vProducto;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.vProducto.getBotonList().get(0))) {
            try {
                int c = Integer.parseInt(this.vProducto.getTxtList().get(0).getText());
                String nom = this.vProducto.getTxtList().get(1).getText();
                String pre = this.vProducto.getTxtList().get(2).getText();
                
                if ( nom.equals("") || pre.equals("") ) {
                    JOptionPane.showMessageDialog(vProducto, "Todos los campos son obligatorios ", "Falta Informacion", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    boolean res = this.vProducto.getgD().buscarProductologico(nom);

                    if (res == true) {
                        JOptionPane.showMessageDialog(vProducto, "Producto ya  Registrado ", "Error Registro", JOptionPane.INFORMATION_MESSAGE);
                        this.vProducto.getTxtList().get(0).setText("");
                        this.vProducto.getTxtList().get(1).setText("");
                        this.vProducto.getTxtList().get(2).setText("");
                    } else {
                        Producto pro = new Producto(c,nom,pre);
                        this.vProducto.getgD().addProducto(pro);
                        Object[][] datoProducto = this.vProducto.cargaDatosTabla(this.vProducto.getgD().getProductoList().size(), 3);
                        this.vProducto.setDatos(datoProducto);
                        this.vProducto.getModeloTabla().setDataVector(this.vProducto.getDatos(), this.vProducto.getEncabezado());
                        this.vProducto.getgD().guardarArchivoProducto();
                    }
                }
            } catch (NumberFormatException c) {
                JOptionPane.showMessageDialog(vProducto, "Codigo es un numero entero");
            }
        }
        
        if (e.getSource().equals(this.vProducto.getBotonList().get(1))) {
            this.vProducto.getTxtList().get(0).setText("");
            this.vProducto.getTxtList().get(1).setText("");
            this.vProducto.getTxtList().get(2).setText("");
            
            }
    }
    
}
