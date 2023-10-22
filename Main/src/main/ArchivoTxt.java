/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author gianf
 */
public class ArchivoTxt {

    public void LectorChooser(){
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
                Grafos grafito = new Grafos(2);

                String linea;
                while ((linea = br.readLine()) != null) {
                                            
                    if (linea.contains("@") && !linea.contains(",")) {
                        NodE nodito = new NodE(linea);
                        grafito.insertar_usuario(nodito);
                        linea = " ";

                    } else if(linea.contains("@") && linea.contains(","))  {
                    String[] parte = linea.split(",");
                    String parte1 = parte[0];
                    String parte2 = parte[1];
                    grafito.nuevo_seguidor(parte1, parte2);}
                        
                }grafito.imprimir_grafo();
            } catch (IOException e) {
// Manejar la excepción de entrada/salida
                e.printStackTrace();
            }
        }
    }
    
    public void EscribirTxt(Listas usuarios) {
        String UsuariosActuales = "";
        if (!usuarios.IsEmpty()) {
            NodE pAux = usuarios.getPrimero();
            for (int i = 0; i < usuarios.getSize(); i++) {
                UsuariosActuales += pAux.getUsuario()+ "\n";
                pAux = pAux.getSiguiente();
            }
        }
        try {
<<<<<<< HEAD
            try (PrintWriter pw = new PrintWriter("test\\usuarios.txt")) {
                pw.print(UsuariosActuales);
            }
            //INTERFAZ GRAFICA
            //INTERFAZ GRAFICA
            //INTERFAZ GRAFICA
            JOptionPane.showMessageDialog(null, "Guarado exitoso");
            //INTERFAZ GRAFICA
            //INTERFAZ GRAFICA
            //INTERFAZ GRAFICA
        } catch (HeadlessException | FileNotFoundException e) {
=======
            PrintWriter pw = new PrintWriter("test\\usuarios.txt");
            pw.print(UsuariosActuales);
            pw.close();
            
            JOptionPane.showMessageDialog(null, "Guarado exitoso");
            
        } catch (Exception e) {
>>>>>>> 5aed82951f053725b4341dd3b20cddaf2f638cdd
            JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
    }

    public Listas LeerTxt() {
        Listas usuarios = new Listas();
        String line;
        String usuarios_txt = "";
        String path = "test\\usuarios.txt";
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();

            } else {
                FileReader fr = new FileReader(file);
                try (BufferedReader br = new BufferedReader(fr)) {
                    while ((line = br.readLine()) != null) {
                        if (!line.isEmpty()) {
                            usuarios_txt += line + "\n";
                        }
                    }
                    if (!"".equals(usuarios_txt)) {
                        String[] usuario_split = usuarios_txt.split("\n");
                        for (String usuario_split1 : usuario_split) {
                            String[] usuario = usuario_split1.split(",");
                            usuarios.insertar_fin(usuario[0]);
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "Lectura exitosa");

            }
        } catch (HeadlessException | IOException e) {
            JOptionPane.showMessageDialog(null, "error al momento de leer los clientes");
        }
        return usuarios;
    }

}
