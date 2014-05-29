/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package juegolaberinto;

import busqueda.Busqueda;
import busqueda.Estado;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Timer;
import javax.swing.JFrame;

/**
 *
 * @author Segurity
 */
public class VentanaPrincipal extends JFrame 
                             implements Constantes{
    
    public Lienzo lienzo;
    public AnimadorAutomatico animador;
    
    public VentanaPrincipal(){ 
        lienzo=new Lienzo();
        lienzo.setFocusable(true);
        lienzo.requestFocus();
       
        Timer timer = new Timer(); 
        //Animación
        animador = new AnimadorAutomatico(lienzo);
        timer.scheduleAtFixedRate(animador, 0, 1000);
        
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(lienzo,BorderLayout.CENTER);
        this.setSize(lienzo.getWidth()+22, lienzo.getHeight()+42);
        
        
        
        

    }
}
