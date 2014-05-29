/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package juegolaberinto;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import java.util.Timer;

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
        ArrayList<Character> pasos = new ArrayList<>();
        pasos.add('D');pasos.add('U');
        pasos.add('R');pasos.add('L');
        pasos.add('R');pasos.add('U');
        pasos.add('U');pasos.add('D');
        pasos.add('U');
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(lienzo,BorderLayout.CENTER);
        this.setSize(lienzo.getWidth()+22, lienzo.getHeight()+42);
        animador = new AnimadorAutomatico(lienzo,pasos);
        timer.scheduleAtFixedRate(animador, 0, 1000);

    }
}
