/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package busqueda;
import java.awt.Point;
import java.util.Objects;
import juegolaberinto.Celda;
import juegolaberinto.Laberinto;

public class Estado {
    private Celda[][] laberinto;
    private Estado antecesor;
    private char movimiento;
    private Point posicion;
    
   public Estado(Point posicion, Estado antecesor,char movimiento,Celda[][] laberinto ) {
        this.laberinto = laberinto;
        this.antecesor=antecesor;
        this.movimiento=movimiento;
        this.posicion=posicion;
    }

    public Estado getAntecesor() {
        return antecesor;
    }

    public char getMovimiento() {
        return movimiento;
    }

    public Celda[][] getLaberinto() {
        return laberinto;
    }

    public Point getPosicion() {
        Point punto;
        punto=new Point(posicion);
        return punto;
    }
    
    public Point getPunto() {
        return posicion;
    }

    @Override
    public String toString() {
        return posicion.toString();
    }
    
    
    //Matriz [6][4];
    
    public boolean moverArriba(){
        if(posicion.x-1>=0){
            if(laberinto[posicion.x-1][posicion.y].tipo=='V'){
                System.out.println("X: "+posicion.x+", Y");
                return true;
            }
        }
        return false;
    }
     public boolean moverAbajo(){
         if(posicion.x+1<=15){
            if(laberinto[posicion.x+1][posicion.y].tipo=='V'){
               return true;
            }
         }
        return false;
    }
      public boolean moverIzquierda(){
          if(posicion.y-1>=0){
            if(laberinto[posicion.x][posicion.y-1].tipo=='V'){
               return true;
            }
          }
        return false;
      }
       public boolean moverDerecha(){
           if(posicion.y+1<=15){
            if(laberinto[posicion.x][posicion.y+1].tipo=='V'){
               return true;
            }
           }
        return false;
    }
     
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Estado))return false;
        return ((Estado)obj).getPosicion().equals(this.getPosicion());
    }
      @Override
    public int hashCode() {
        //Hashcode generado por IDE
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.posicion);
        return hash;
    }
}
