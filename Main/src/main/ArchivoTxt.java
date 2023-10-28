/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author gianf
 */
public class ArchivoTxt {
    
    public ArchivoTxt(){}

    public Grafos LectorChooser(Grafos grafito) throws FileNotFoundException, IOException{
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
                    if (linea.contains("@") && !linea.contains(",")) {
                    NodE nodito = new NodE(linea.trim()); // trim() elimina espacios en blanco al principio y al final
                    grafito.insertar_usuario(nodito);
                    linea = " ";
    }           else if (linea.contains("@") && linea.contains(",")) {
                    String[] parte = linea.split(",");
                        if (parte.length == 2) {
                    String parte1 = parte[0].trim();
                    String parte2 = parte[1].trim();
                    grafito.nuevo_seguidor(parte1, parte2);
        }
    
                    } else if(linea.contains("@") && linea.contains(","))  {
                    String[] parte = linea.split(",");  
                    String parte1 = parte[0];
                    String parte2 = parte[1];
                    grafito.nuevo_seguidor(parte1, parte2);}
                        
                }
                JOptionPane.showMessageDialog(null, "Cargado exitosamente");
            } catch (IOException e) {
                System.out.println(e);
// Manejar la excepción de entrada/salida
                e.printStackTrace();
            }
        }
        return grafito;
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
            
            JOptionPane.showMessageDialog(null, "Guardado exitoso");
            
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
            JOptionPane.showMessageDialog(null, "Error al momento de leer los usuarios");
        }
        return usuarios;


}
    public void escribirEnArchivo(Grafos grafo, String nombreArchivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            // Escribir la lista de usuarios
            writer.println("usuarios");
            for (int i = 0; i < grafo.max_usuarios; i++) {
                if (grafo.getUsuarios()[i] != null) {
                    writer.println(grafo.getUsuarios()[i].getPrimero().getUsuario());
                }
            }

            // Escribir las relaciones
            writer.println("relaciones");
            for (int i = 0; i < grafo.max_usuarios; i++) {
                if (grafo.getUsuarios()[i] != null) {
                    String usuario = grafo.getUsuarios()[i].getPrimero().getUsuario();
                    NodE aux = grafo.getUsuarios()[i].getPrimero().getSiguiente();

                    while (aux != null) {
                        writer.println(usuario + ", " + aux.getUsuario());
                        aux = aux.getSiguiente();
                    }
                }
            }

            System.out.println("Archivo " + nombreArchivo + " creado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    
    public String validar(String usuario){
        String user = usuario;
        if (!usuario.contains("@")){
             user = "@" + usuario;
        }
        return user;
    }
}


