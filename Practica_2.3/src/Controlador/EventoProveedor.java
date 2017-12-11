/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VentanaProveedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        
    }
    
    
    
}
