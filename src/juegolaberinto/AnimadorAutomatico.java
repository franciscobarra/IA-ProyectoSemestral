/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package juegolaberinto;

import java.util.ArrayList;
import java.util.TimerTask;

/**
 *
 * @author Segurity
 */
public class AnimadorAutomatico extends TimerTask implements Constantes{

    public Lienzo lienzo;
    public ArrayList<Character> pasos;
    public int paso_actual;
    
    public AnimadorAutomatico(Lienzo lienzo,ArrayList<Character> pasos){
        this.lienzo = lienzo;
        this.pasos = pasos;
        paso_actual = 0;
    }
    
    @Override
    public void run() {
        if(paso_actual < pasos.size()){
            switch(pasos.get(paso_actual)){
                case 'D' : lienzo.laberinto.mover_abajo();break;
                case 'U' : lienzo.laberinto.mover_arriba();break;
                case 'R' : lienzo.laberinto.mover_derecha();break;
                case 'L' : lienzo.laberinto.mover_izquierda();break;
            }
            lienzo.repaint();
            paso_actual++;
        }else{
            this.cancel();
        }
        
        
    }
    
    
}
