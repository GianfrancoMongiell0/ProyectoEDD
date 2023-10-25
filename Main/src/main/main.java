package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class main {

    public static void main(String[] args) {

//        NodE n = new NodE("AR");
//        NodE a = new NodE("sda");
//        NodE b = new NodE("febt");
//        Grafos g = new Grafos(3);
//        GraficarG graf = new GraficarG();
//        
//        g.insertar_usuario(n);
//        g.insertar_usuario(a);
//        g.insertar_usuario(b);
//        g.nuevo_seguidor(n.usuario, a.usuario);
//        g.nuevo_seguidor(n.usuario, b.usuario);
//        g.imprimir_grafo();
////        g.eliminar_usuarios(n.usuario);
//        graf.graficar(g);
//
////        String respuesta = JOptionPane.showInputDialog("Ingrese 'SI' si desea utilizar el programa, es caso contrario utilice 'NO'");
////
////        while (respuesta.equalsIgnoreCase("si")) {
//            /*
//            INTERFAZ QUE PREGUNTE QUE DESEA HACER
//                1. CARGAR ARCHIVO TXT
//                2. MODIFICAR EL GRAFO
//                3.ACTUALIZAZR REPOSITORIO
//                4. MOSTRAR GRAFO
//                5. INDENTIFICACION DE COMPONENTES FUERTEMENTE CONECTADOS
//            
//             */
////            try {
//
//                String respuesta1 = JOptionPane.showInputDialog("Seleccione:  \n1. CARGAR ARCHIVO TXT\n2. MODIFICAR EL GRAFO\n3. ACTUALIZAR REPOSITORIO\n4. MOSTRAR GRAFO\n5. INDENTIFICACION DE COMPONENTES FUERTEMENTE CONECTADOS");
//                int num1 = Integer.parseInt(respuesta1);
//
//                if (num1 == 1) {
//                    Grafos gr = new Grafos(2);
//                    ArchivoTxt archivo = new ArchivoTxt();
//                    gr = archivo.LectorChooser(gr);
////                    System.out.println(gr.usuarios[0].primero.usuario);
//                    gr.imprimir_grafo();
//
////                } else if (num1 == 2) {
////                    String respuesta2 = JOptionPane.showInputDialog("\"Seleccione: \n1. Eliminar Usuario\n2. Agregar Usuario\n3. Salir\"");
////                    int num2 = Integer.parseInt(respuesta2);
////
////                    if (num2 == 1) {
////
////                    } else if (num2 == 2) {
////
////                    } else {
////
////                    }
////
////                } else {
////                    System.exit(0);
////                }
//
////            } catch (Exception e) {
//////                JOptionPane.showMessageDialog(null, "Por favor, solo ingresa numero de 1 al 6");
////                                JOptionPane.showMessageDialog(null, e);
////
////            }
//
//        }
////         CARGAR TXT
        int contador1 = 0;
        int contador2 = 0;
        Grafos grafito = new Grafos(2);
        GraficarG grafico = new GraficarG();
        JFileChooser jfc = new JFileChooser();
        jfc.setCurrentDirectory(new File("C:\\Users\\usuario\\Desktop"));

// Mostrar el diálogo de selección de archivos y obtener el valor de retorno
        int resultado = jfc.showOpenDialog(null);

// Si el usuario ha aceptado la operación
        if (resultado == JFileChooser.APPROVE_OPTION) {
// Obtener el archivo seleccionado
            File archivo = jfc.getSelectedFile();

// Crear un objeto BufferedReader para leer el archivo
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
// Leer las líneas del archivo y mostrarlas por pantalla

                String linea;
                while ((linea = br.readLine()) != null) {
//                    System.out.println("linea");
                    if (linea.contains("@") && !linea.contains(",")) {
                        NodE nodito = new NodE(linea);
                        grafito.insertar_usuario(nodito);
                        linea = "";
                        contador1 += 1;

                    } else if (linea.contains("@") && linea.contains(",")) {
                        String[] parte = linea.split(",");
                        String parte1 = parte[0];
                        String parte2 = parte[1];
                        grafito.nuevo_seguidor(parte1, parte2);
                        contador2 += 1;
                    }
                    
                }
                System.out.println("Contador 1 :" + contador1); 
                    
                    System.out.println("Contador 2 :"  + contador2);
                JOptionPane.showMessageDialog(null, "Cargado exitosamente");
            } catch (IOException e) {
                System.out.println(e);
// Manejar la excepción de entrada/salida
                e.printStackTrace();
            }
            grafito.imprimir_grafo();
        }

        grafico.graficar(grafito);
    }

}
