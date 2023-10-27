package main;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.io.IOException;
import static main.Ventana.direccion_archivo;


public class main {



    public static void main(String[] args) throws IOException {
        // Crear una instancia de la clase Grafos (supongamos que la tienes ya)
        Grafos grafo = new Grafos(3);
        
        Ventana n = new Ventana(grafo, direccion_archivo);
//        ArchivoTxt archivoTxt = new ArchivoTxt();
//        grafo = archivoTxt.LectorChooser(grafo);

        // Crear una instancia de la clase GraficarG
//        GraficarG graficarG = new GraficarG();
        //graficarG.graficar(grafo);
   
    }

}