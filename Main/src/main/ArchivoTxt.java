/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import main.Listas;
import main.NodE;

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
                        
                }
                JOptionPane.showMessageDialog(null, "Cargado exitosamente");
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
            PrintWriter pw = new PrintWriter("test\\usuarios.txt");
            pw.print(UsuariosActuales);
            pw.close();
            
            JOptionPane.showMessageDialog(null, "Guarado exitoso");
            
        } catch (Exception e) {
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
                BufferedReader br = new BufferedReader(fr);
                while ((line = br.readLine()) != null) {
                    if (!line.isEmpty()) {
                        usuarios_txt += line + "\n";
                    }
                }
                if (!"".equals(usuarios_txt)) {
                    String[] usuario_split = usuarios_txt.split("\n");
                    for (int i = 0; i < usuario_split.length; i++) {
                        String[] usuario = usuario_split[i].split(",");
                        usuarios.insertar_fin(usuario[0]);
                    }
                }
                br.close();
                JOptionPane.showMessageDialog(null, "Lectura exitosa");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al momento de leer los clientes");
        }
        return usuarios;        
    }
}