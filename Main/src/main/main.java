/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class main {
    
    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Asus
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        Lista lista = new Lista();
//        lista.insertar_fin("L");               
//        lista.insertar_fin("P");
//        lista.delete("Q");
//        lista.imprimir();
//        lista.delete("Ñ");

        Grafos g = new Grafos(2);
        NodE a = new NodE("juan");
        NodE b= new NodE("andres");
        NodE c= new NodE("pedro");
        NodE d = new NodE("nicole");
        
        g.insertar_usuario(a);
        g.insertar_usuario(b);
        g.insertar_usuario(c);
        g.insertar_usuario(d);
        
        g.nuevo_seguidor("juan", "andres");
        g.nuevo_seguidor("juan", "pedro");
        g.nuevo_seguidor("pedro", "nicole");
        g.eliminar_usuarios("nicole");
        g.imprimir_grafo();
        
        ArchivoTxt txt =new ArchivoTxt();   
        Listas usuarios = new Listas();
        
        usuarios.insertar_fin("Pablo");
        usuarios.insertar_fin("Kevin");
        usuarios.insertar_fin("Juan");
        txt.EscribirTxt(usuarios);
        Listas usuarios2 = txt.LeerTxt();
        usuarios2.imprimir();
        
        //ClaseFrame miVentana = new ClaseFrame();
        //miVentana.setVisible(true);
        // MI VENTANA NO SE IMPRIME, TIENE QUE SENIALAR LA RUTA DE USUARIOS.TXT 
        
    }
    }
    }
    
