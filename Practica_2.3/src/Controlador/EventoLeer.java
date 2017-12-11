/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VentanaLeer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author SVAIO
 */
public class EventoLeer implements ActionListener {

    private VentanaLeer vLeer;
    private GestionDato gD;

    public EventoLeer(VentanaLeer vLeer) {
        this.vLeer = vLeer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(this.vLeer.getBoton())) {

            JFileChooser abrirArchivo = new JFileChooser();
            abrirArchivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int seleccion = abrirArchivo.showOpenDialog(this.vLeer);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File f = abrirArchivo.getSelectedFile();
                try {
                    String nombre = f.getName();
                    String path = f.getAbsolutePath();
                    String contenido = this.vLeer.getgD().leerArchivo(path);

                    this.vLeer.setTitle(nombre);

                    this.vLeer.getTxp().setText(contenido);

                } catch (Exception exp) {
                }
            }
        }
    }

}
