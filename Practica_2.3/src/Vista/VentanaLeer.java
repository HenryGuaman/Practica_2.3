/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.EventoLeer;
import Controlador.GestionDato;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;


/**
 *
 * @author SVAIO
 */
public class VentanaLeer extends JInternalFrame {

    private JTextField txt;
    private JButton boton;
    private GestionDato gD;
    private JTextPane txp;
    private JScrollPane scroll;

    public VentanaLeer(GestionDato gD) {
        super("Leer Datos", true, true, true, true);
        this.gD = gD;
        this.setSize(500, 500);
        iniciaComponente();

    }

    public void iniciaComponente() {

        setLayout(new BorderLayout());

        this.txp = new JTextPane();
        this.scroll = new JScrollPane();
        this.scroll.setViewportView(txp);

        add(this.scroll, BorderLayout.CENTER);

        this.boton = new JButton("Abrir");
        this.boton.addActionListener(new EventoLeer(this));

        add(this.boton, BorderLayout.NORTH);

    }

    public JTextPane getTxp() {
        return txp;
    }

    public void setTxp(JTextPane txp) {
        this.txp = txp;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public JTextField getTxt() {
        return txt;
    }

    public void setTxt(JTextField txt) {
        this.txt = txt;
    }

    public JButton getBoton() {
        return boton;
    }

    public void setBoton(JButton boton) {
        this.boton = boton;
    }

    public GestionDato getgD() {
        return gD;
    }

    public void setgD(GestionDato gD) {
        this.gD = gD;
    }

}
