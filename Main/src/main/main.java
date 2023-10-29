package main;

/**

 * Esta clase define el main

 * @author: Gianfranco Mongiello

 * @version: 21/10/23

 */
import java.io.IOException;


public class main {
    public static void main(String[] args) throws IOException {
        Grafos grafo = new Grafos(3);
        
        Ventana v = new Ventana(grafo);   
    }
}
// Cierre del main