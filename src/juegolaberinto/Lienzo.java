/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package juegolaberinto;

import busqueda.Busqueda;
import busqueda.Estado;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author Segurity
 */
public class Lienzo extends Canvas {
    public Laberinto laberinto;
    
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
                      laberinto.casillas[i][j].tipo!='P'){
                      laberinto.casillas[i][j].tipo='P';
                   }
                   else
                   laberinto.casillas[i][j].tipo='V';
                   break;
               }    
           }
        }
    }
    
    public char iniciar_busqueda(int ini_x, int ini_y){
        Estado inicial,fin;
        Busqueda b;
        Point posicionInicial, posicionFinal;
        posicionInicial = new Point(ini_x,ini_y);
        inicial = new Estado (posicionInicial,null,'0',laberinto.casillas);
        posicionFinal = new Point (15,15);
        fin = new Estado (posicionFinal,null,'0',laberinto.casillas);
        b = new Busqueda (inicial,fin);
        
        return b.iniciarBusqueda();
    }
    
}
