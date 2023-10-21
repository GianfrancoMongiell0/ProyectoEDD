/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import javax.swing.JOptionPane;

/**
 *
 * @author gianf
 */
public class Main {

    public static void main(String[] args) {
        
        ArchivoTxt txt =new ArchivoTxt();   
        ListaSimple usuarios = new ListaSimple();
        
        usuarios.AgregarFinal("Pablo");
        usuarios.AgregarFinal("Kevin");
        usuarios.AgregarFinal("Juan");
        txt.EscribirTxt(usuarios);
        ListaSimple usuarios2 = txt.LeerTxt();
        usuarios2.Imprimir();
        
        
        //ClaseFrame miVentana = new ClaseFrame();
        //miVentana.setVisible(true);
        // MI VENTANA NO SE IMPRIME, TIENE QUE SENIALAR LA RUTA DE USUARIOS.TXT 
        
    }
}
