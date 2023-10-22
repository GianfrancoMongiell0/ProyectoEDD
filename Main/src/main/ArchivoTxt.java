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
import javax.swing.JOptionPane;

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
