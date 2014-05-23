/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package juegolaberinto;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Segurity
 */
public class VentanaPrincipal extends JFrame 
                             implements Constantes{
    
    public Lienzo lienzo;
    
    public VentanaPrincipal(){
        lienzo=new Lienzo();
        lienzo.setFocusable(true);
        lienzo.requestFocus();
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(lienzo,BorderLayout.CENTER);
        this.setSize(lienzo.getWidth()+22, lienzo.getHeight()+42);
        //this.setResizable(false);
    }
    
    
    
}
