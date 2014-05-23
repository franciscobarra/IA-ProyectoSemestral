/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package juegolaberinto;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;


/**
import java.awt.Graphics;
import javax.swing.JComponent;
 *
 * @author Segurity
 */


public class Celda extends JComponent implements Constantes {
    
    int x, y;
    char tipo;
    BufferedImage personaje,muro,vacio;
    
    public Celda(int x, int y, char tipo){
        this.x=x;
        this.y=y;
        this.tipo=tipo;
        try{
            personaje = ImageIO.read(new File("src/images/lee sin1.png"));
            muro = ImageIO.read(new File("src/images/muro6.png"));
            vacio = ImageIO.read(new File("src/images/muro5.png"));
        } catch (IOException e){
            System.out.println(e.toString());
        }
    }
    
    public boolean dentro_area(int xp, int yp){
     Rectangle r=new Rectangle (x,y,Constantes.longitud_casilla,
                                      Constantes.longitud_casilla);
     return r.contains(new Point(xp,yp));
    }
    
    @Override
    public void paintComponent(Graphics g){
        update(g);
    }
    
    @Override
    public void update(Graphics g){
        switch(tipo){
            case 'J': g.drawImage(personaje, x, y, null);break;
            case 'P': g.drawImage(muro, x, y, null);break;
            case 'V': g.drawImage(vacio, x, y, null);break;    
                
        }
    }
 
}
