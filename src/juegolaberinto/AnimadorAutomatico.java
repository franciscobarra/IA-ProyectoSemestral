/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package juegolaberinto;

import java.awt.Point;
import java.util.ArrayList;
import java.util.TimerTask;

/**
 *
 * @author Segurity
 */
public class AnimadorAutomatico extends TimerTask implements Constantes{

    public Lienzo lienzo;
    public char pasos;
    public int paso_actual;
    public int x,y;
    
    public AnimadorAutomatico(Lienzo lienzo){
        this.lienzo = lienzo;
        paso_actual = 0;
        this.x=0;
        this.y=0;
    }
    
    @Override
    public void run() {
        pasos=lienzo.iniciar_busqueda(x,y);
            switch(pasos){
                case 'D' : lienzo.laberinto.mover_abajo();
                           x+=1;
                break;
                case 'U' : lienzo.laberinto.mover_arriba();
                           x-=1;
                break;
                case 'R' : lienzo.laberinto.mover_derecha();
                           y+=1;
                break;
                case 'L' : lienzo.laberinto.mover_izquierda();
                           y-=1;
                break;
            }
            
            lienzo.repaint();
            System.out.println(pasos);
                 
    }
    
    
}
