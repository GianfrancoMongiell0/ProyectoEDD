/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import main.Listas;
import main.NodE;

/**
 *
 * @author gianf
 */
public class ArchivoTxt {

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
            //INTERFAZ GRAFICA
            //INTERFAZ GRAFICA
            //INTERFAZ GRAFICA
            JOptionPane.showMessageDialog(null, "Guarado exitoso");
            //INTERFAZ GRAFICA
            //INTERFAZ GRAFICA
            //INTERFAZ GRAFICA
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
