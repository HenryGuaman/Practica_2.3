/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.GestionDato;
import Modelo.Producto;
import Modelo.Proveedor;
import Modelo.Stock;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SVAIO
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Producto> pL=new ArrayList<Producto>();
        List<Proveedor> prL=new ArrayList<Proveedor>();
        List<Stock> sL=new ArrayList<Stock>();
        GestionDato gD=new GestionDato(pL, prL, sL);
        VentanaPrincipal vP= new VentanaPrincipal("Software de Gestion",gD);
        vP.setVisible(true);
    }
    
}
