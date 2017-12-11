/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VentanaStock;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Abuelito
 */
public class EventoStock implements ActionListener{
    
    private VentanaStock vStock;

    public EventoStock(VentanaStock vStock) {
        this.vStock = vStock;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }
    
    
}
