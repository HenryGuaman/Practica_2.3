/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VentanaProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        
    }
    
}
