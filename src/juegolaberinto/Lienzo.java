/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package juegolaberinto;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 *
 * @author Segurity
 */
public class Lienzo extends Canvas {
    Laberinto laberinto;
    
    public Lienzo(){
        laberinto=new Laberinto();
        this.setBackground(Color.DARK_GRAY);
        this.setSize(laberinto.ancho,laberinto.largo);
        addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt){
            identificarCelda(evt);
            repaint();
        }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
           @Override
           public void keyPressed(KeyEvent e){
               laberinto.chequearTecla(e);
               repaint();
           }
        });
        
    }
    @Override
    public void update(Graphics g){
        laberinto.update(g);
    }
    
    @Override
    public void paint(Graphics g){
     laberinto.paintComponent(g);
    }
    
    private void identificarCelda(java.awt.event.MouseEvent evt){
        for(int i = 0 ; i < laberinto.casillas.length ; i++){
           for(int j = 0 ; j < laberinto.casillas.length ; j++){
               if(laberinto.casillas[i][j].dentro_area(evt.getX(),evt.getY())){
                   if(laberinto.casillas[i][j].tipo!='J'&& 
                      laberinto.casillas[i][j].tipo!='P')laberinto.casillas[i][j].tipo='P';
                   else
                   laberinto.casillas[i][j].tipo='V';
                   break;
               }    
           }
        }
    }
    
    
}
