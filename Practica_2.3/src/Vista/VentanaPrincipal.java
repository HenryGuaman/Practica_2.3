/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.EventoPrincipal;
import Controlador.GestionDato;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Eduardo
 */
public class VentanaPrincipal extends JFrame {
    private JMenuBar menu;
    private JDesktopPane escritorio;
    private List<JMenu> menuList;
    private List<JMenuItem> menuItemList;
    private GestionDato gD;

    public VentanaPrincipal(String t, GestionDato gD) {
        this.setTitle(t);
        this.setSize(825, 800);
        this.setDefaultCloseOperation(3);
        this.gD = gD;
        iniciaComponente();

    }

    public void iniciaComponente() {
        this.menu = new JMenuBar();
        this.escritorio = new JDesktopPane();
        this.menuList = new ArrayList<JMenu>();
        this.menuList.add(new JMenu("Proveedor"));
        this.menuList.add(new JMenu("Producto"));
        this.menuList.add(new JMenu("Stock"));
        this.menuList.add(new JMenu("Leer Archivos"));
        

        this.menuItemList = new ArrayList<JMenuItem>();
        this.menuItemList.add(new JMenuItem("Registro Proveedor"));
        this.menuItemList.add(new JMenuItem("Registro Producto"));
        this.menuItemList.add(new JMenuItem("Informe Stock"));
        this.menuItemList.add(new JMenuItem("Leer Datos"));

        this.setContentPane(this.escritorio);
        this.setJMenuBar(menu);

        this.menu.add(this.menuList.get(0));
        this.menu.add(this.menuList.get(1));
        this.menu.add(this.menuList.get(2));
        this.menu.add(this.menuList.get(3));
        this.menuList.get(0).add(this.menuItemList.get(0));
        this.menuList.get(1).add(this.menuItemList.get(1));
        this.menuList.get(2).add(this.menuItemList.get(2));
        this.menuList.get(3).add(this.menuItemList.get(3));

        this.menuItemList.get(0).addActionListener(new EventoPrincipal(this));
        this.menuItemList.get(1).addActionListener(new EventoPrincipal(this));
        this.menuItemList.get(2).addActionListener(new EventoPrincipal(this));
        this.menuItemList.get(3).addActionListener(new EventoPrincipal(this));
    }

    public JMenuBar getMenu() {
        return menu;
    }

    public void setMenu(JMenuBar menu) {
        this.menu = menu;
    }

    public JDesktopPane getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }

    public List<JMenu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<JMenu> menuList) {
        this.menuList = menuList;
    }

    public List<JMenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(List<JMenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    public GestionDato getgD() {
        return gD;
    }

    public void setgD(GestionDato gD) {
        this.gD = gD;
    }
    
}
