/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VentanaLeer;
import Vista.VentanaPrincipal;
import Vista.VentanaProducto;
import Vista.VentanaProveedor;
import Vista.VentanaStock;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Abuelito
 */
public class EventoPrincipal implements ActionListener{
    
    private VentanaPrincipal vPrincipal;

    public EventoPrincipal(VentanaPrincipal vPrincipal) {
        this.vPrincipal = vPrincipal;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.vPrincipal.getMenuItemList().get(0))) {
            VentanaProveedor vAt = new VentanaProveedor(this.vPrincipal.getgD());
            vAt.setVisible(true);
            this.vPrincipal.getEscritorio().add(vAt);
        }

        if (e.getSource().equals(this.vPrincipal.getMenuItemList().get(1))) {
            VentanaProducto vCo = new VentanaProducto(this.vPrincipal.getgD());
            vCo.setVisible(true);
            this.vPrincipal.getEscritorio().add(vCo);
        }

        if (e.getSource().equals(this.vPrincipal.getMenuItemList().get(2))) {
            VentanaStock vRe = new VentanaStock(this.vPrincipal.getgD());
            vRe.setVisible(true);
            this.vPrincipal.getEscritorio().add(vRe);
        }
        if (e.getSource().equals(this.vPrincipal.getMenuItemList().get(3))) {
            VentanaLeer vL= new VentanaLeer(this.vPrincipal.getgD());
            vL.setVisible(true);
            this.vPrincipal.getEscritorio().add(vL);
        }
    }
    
}
