/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.EventoProveedor;
import Controlador.GestionDato;
import Modelo.Proveedor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eduardo
 */
public class VentanaProveedor extends JInternalFrame{
    
    private List<JLabel> etiquetaList;
    private List<JButton> botonList;
    private List<JTextField> txtList;
    private Object[][] datos;
    private Object[] encabezado;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    private JScrollPane scroll;
    private GestionDato gD;

    public VentanaProveedor(GestionDato gD) {
        super("Registro del Proveedor", true, true, true, true);
        this.setSize(800, 600);
        this.gD = gD;
        iniciaComponente();

    }

    public void iniciaComponente() {

        this.etiquetaList = new ArrayList<JLabel>();

        this.etiquetaList.add(new JLabel("Nombre y Apellido: "));
        this.etiquetaList.add(new JLabel("Ruc: "));
        this.etiquetaList.add(new JLabel("Telefono: "));
        this.etiquetaList.add(new JLabel("Direccion: "));

        this.txtList = new ArrayList<JTextField>();
        this.txtList.add(new JTextField(15));
        this.txtList.add(new JTextField(15));
        this.txtList.add(new JTextField(15));
        this.txtList.add(new JTextField(15));
        
        JPanel panel = new JPanel();
        this.botonList = new ArrayList<JButton>();
        this.botonList.add(new JButton("Guardar"));
        this.botonList.add(new JButton("Nuevo"));
        
        this.botonList.get(0).addActionListener(new EventoProveedor(this));
        this.botonList.get(1).addActionListener(new EventoProveedor(this));
        

        this.encabezado = new Object[4];

        this.encabezado[0] = "Datos Personales";
        this.encabezado[1] = "Ruc";
        this.encabezado[2] = "Telefono";
        this.encabezado[3] = "Direccion";
    
        this.modeloTabla = new DefaultTableModel(this.datos, this.encabezado);
        this.tabla = new JTable(this.modeloTabla);
        this.scroll = new JScrollPane(this.tabla);

        panel.add(this.etiquetaList.get(0));
        panel.add(this.txtList.get(0));
        panel.add(this.etiquetaList.get(1));
        panel.add(this.txtList.get(1));
        panel.add(this.etiquetaList.get(2));
        panel.add(this.txtList.get(2));
        panel.add(this.etiquetaList.get(3));
        panel.add(this.txtList.get(3));
        panel.add(botonList.get(0));
        panel.add(botonList.get(1));
        panel.add(this.scroll);
        this.add(panel);
    }
    
    public Object[][] cargaDatosTabla(int h, int w) {
        Object[][] retorno = new Object[h][w];
        int i = 0;
        for (Proveedor p : this.gD.getProveedorList()) {
            retorno[i][0] = p.getNombreYApellido();
            retorno[i][1] = p.getRuc();
            retorno[i][2] = p.getTelefono();
            retorno[i][3] = p.getDireccion();
            
            i++;
        }
        return retorno;
    }

    public List<JLabel> getEtiquetaList() {
        return etiquetaList;
    }

    public void setEtiquetaList(List<JLabel> etiquetaList) {
        this.etiquetaList = etiquetaList;
    }

    public List<JButton> getBotonList() {
        return botonList;
    }

    public void setBotonList(List<JButton> botonList) {
        this.botonList = botonList;
    }

    public List<JTextField> getTxtList() {
        return txtList;
    }

    public void setTxtList(List<JTextField> txtList) {
        this.txtList = txtList;
    }

    public Object[][] getDatos() {
        return datos;
    }

    public void setDatos(Object[][] datos) {
        this.datos = datos;
    }

    public Object[] getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(Object[] encabezado) {
        this.encabezado = encabezado;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public GestionDato getgD() {
        return gD;
    }

    public void setgD(GestionDato gD) {
        this.gD = gD;
    }
    
}
