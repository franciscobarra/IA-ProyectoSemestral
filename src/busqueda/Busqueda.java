/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package busqueda;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Alumno
 */
public class Busqueda {
    private Estado actual,meta;
    private ArrayList<Estado> abierto,cerrado;
    private boolean busqueda;
    
    public Busqueda(Estado actual, Estado meta){
        this.actual = actual;
        this.meta = meta;
        abierto = new ArrayList<Estado>();
        cerrado = new ArrayList<Estado>();
        this.busqueda = true;
    }    
    
    public boolean getBusqueda(){
        return busqueda;
    }
    
    public void setBusqueda(boolean busqueda){
        this.busqueda=busqueda;
    }
    
    public Character iniciarBusqueda(){
        boolean esMeta = false;
        char resultado = 0;
        
        abierto.add(actual);
 
        while(!abierto.isEmpty() && !esMeta ){
            actual = abierto.get(0);
            if(!getBusqueda())abierto.remove(0); // busqueda en profundidad;
            if(!cerrado.contains(actual)){

               cerrado.add(actual);
               expandir(actual);
            } 
            if(actual.getPosicion().equals(meta.getPosicion())){
                esMeta=true;
            }

            if(getBusqueda())abierto.remove(0); // busqueda en anchura
            
        }
        if(!esMeta)return '0';
     
        while(actual.getAntecesor()!=null){
            resultado=actual.getMovimiento();
            actual = actual.getAntecesor();
           
        }
        return resultado;
    }
    
    public void expandir(Estado actual){
       Point posicion;
       Estado opcion;
        
        if(actual.moverArriba()){
           posicion = actual.getPosicion(); 
           posicion.y-=1;
           opcion = new Estado(posicion, actual,'U',actual.getLaberinto());
           if(getBusqueda())abierto.add(opcion); // busqueda en anchura;
           if(!getBusqueda())abierto.add(0,opcion); // busqueda en profundidad;
        }
        
        if(actual.moverDerecha()){
           posicion = actual.getPosicion(); 
           posicion.x+=1;
           opcion = new Estado(posicion, actual,'R',actual.getLaberinto());
           if(getBusqueda())abierto.add(opcion);
           if(!getBusqueda())abierto.add(0,opcion);
        }   
        
        if(actual.moverAbajo()){
           posicion = actual.getPosicion(); 
           posicion.y+=1;
           opcion = new Estado( posicion, actual,'D',actual.getLaberinto());
           if(getBusqueda())abierto.add(opcion);
           if(!getBusqueda())abierto.add(0,opcion);
        }
        
        if(actual.moverIzquierda()){
           posicion = actual.getPosicion(); 
           posicion.x-=1;
           opcion = new Estado(posicion, actual,'L',actual.getLaberinto()); 
           if(getBusqueda())abierto.add(opcion);
           if(!getBusqueda())abierto.add(0,opcion);
        }
        
    }
}
    