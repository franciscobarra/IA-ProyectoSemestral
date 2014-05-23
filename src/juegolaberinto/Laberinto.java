/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package juegolaberinto;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
/**
 *
 * @author Segurity
 */
public class Laberinto extends JComponent implements Constantes {
    
    public int ancho,largo;
    public  Celda[][] casillas;
    int i_jugador,j_jugador;
    
    public Laberinto(){
        casillas = new Celda[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
            casillas[i][j] = new Celda(i+(i*Constantes.longitud_casilla),
            j+(j*Constantes.longitud_casilla),'V');
        }
    }
    i_jugador=0;
    j_jugador=0;
    casillas[i_jugador][j_jugador].tipo='J';
    this.ancho=n*longitud_casilla;
    this.largo=m*longitud_casilla;
    this.setSize(ancho,largo);
    }
    
    @Override
    public void paintComponent(Graphics g){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                casillas[i][j].paintComponent(g);
            }
        }
    }
    
    @Override
    public void update(Graphics g){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
               casillas[i][j].update(g);
            }
        }
    }
    
    public void chequearTecla(KeyEvent evento){
    if (evento.getKeyCode() == 38){
        System.out.println("Mover arriba");
        mover_arriba();
    }
    if (evento.getKeyCode() == 40){
        System.out.println("Mover abajo");
        mover_abajo();
    }
    if (evento.getKeyCode() == 37){
        System.out.println("Mover izquierda");
        mover_izquierda();
    }
    if (evento.getKeyCode() == 39){
        System.out.println("Mover derecha");
        mover_derecha();
    }
    
  }
    public void mover_izquierda(){
        System.out.println("Jugador esta en:"+i_jugador+" ,"+j_jugador);
        if(i_jugador > 0){
            if(casillas[i_jugador-1][j_jugador].tipo!='P'){
               casillas[i_jugador][j_jugador].tipo='V';
               i_jugador-=1;
               casillas[i_jugador][j_jugador].tipo='J';
                System.out.println("Jugador paso a :"+i_jugador+" , "+j_jugador);
            }else{
                System.out.println("Contra pared");
            }
        }else{
            System.out.println("Imposible moverse a la izquierda");
        }
    }
     public void mover_derecha(){
        System.out.println("Jugador esta en:"+i_jugador+" ,"+j_jugador);
        if(i_jugador < 15){
            if(casillas[i_jugador+1][j_jugador].tipo!='P'){
               casillas[i_jugador][j_jugador].tipo='V';
               i_jugador+=1;
               casillas[i_jugador][j_jugador].tipo='J';
                System.out.println("Jugador paso a :"+i_jugador+" , "+j_jugador);
            }else{
                System.out.println("Contra pared");
            }
        }else{
            System.out.println("Imposible moverse a la derecha");
        }
    }
     public void mover_arriba(){
        System.out.println("Jugador esta en:"+i_jugador+" ,"+j_jugador);
        if(j_jugador > 0){
            if(casillas[i_jugador][j_jugador-1].tipo!='P'){
               casillas[i_jugador][j_jugador].tipo='V';
               j_jugador-=1;
               casillas[i_jugador][j_jugador].tipo='J';
                System.out.println("Jugador paso a :"+i_jugador+" , "+j_jugador);
            }else{
                System.out.println("Contra pared");
            }
        }else{
            System.out.println("Imposible subir");
        }
    }
     public void mover_abajo(){
        System.out.println("Jugador esta en:"+i_jugador+" ,"+j_jugador);
        if(j_jugador < 15){
            if(casillas[i_jugador][j_jugador+1].tipo!='P'){
               casillas[i_jugador][j_jugador].tipo='V';
               j_jugador+=1;
               casillas[i_jugador][j_jugador].tipo='J';
                System.out.println("Jugador paso a :"+i_jugador+" , "+j_jugador);
            }else{
                System.out.println("Contra pared");
            }
        }else{
            System.out.println("Imposible bajar");
        }
    }
}