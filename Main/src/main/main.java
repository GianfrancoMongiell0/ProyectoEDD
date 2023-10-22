package main;


import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;




import javax.swing.JOptionPane;

public class main {

    public static void main(String[] args) {
        String respuesta = JOptionPane.showInputDialog("Ingrese 'SI' si desea utilizar el programa, es caso contraio utilice 'NO'");


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
    
        while (respuesta.equalsIgnoreCase("si")) {
            /*
            INTERFAZ QUE PREGUNTE QUE DESEA HACER
                1. CARGAR ARCHIVO TXT
                2. MODIFICAR EL GRAFO
                3.ACTUALIZAZR REPOSITORIO
                4. MOSTRAR GRAFO
                5. INDENTIFICACION DE COMPONENTES FUERTEMENTE CONECTADOS
            
             */
            try {
                Grafos g = new Grafos(0);

                String respuesta1 = JOptionPane.showInputDialog("Seleccione:  \n1. CARGAR ARCHIVO TXT\n2. MODIFICAR EL GRAFO\n3.ACTUALIZAZR REPOSITORIO\n4. MOSTRAR GRAFO\n5. INDENTIFICACION DE COMPONENTES FUERTEMENTE CONECTADOS");
                int num = Integer.parseInt(respuesta1);

                while (1 <= num && num <= 6) {

                    if (respuesta1 == "1") {
                        
                        ArchivoTxt lector = new ArchivoTxt();
                        lector.LectorChooser();

                    } else if (respuesta1 == "2") {

                        try {

//                             INTERFAZ 
                            String respuesta3 = JOptionPane.showInputDialog("Seleccione: \n1. Eliminar Usuario\n2.Agregar Usuario\n3. Salir");
                            int num1 = Integer.parseInt(respuesta3);
//                            CARGAR GRAFO.TXT
                            while (1 <= num1 && num1 <= 3) {

                                if (num == 1) {
                                    
                                    

                                } else if (num == 2) {

                                } else {

                                    break;

                                }
                            }
                        } catch (Exception e) {
                        }

                    } else if (num == 3) {

                    } else if (num == 4) {

                    } else if (num == 5) {

                    } else {
                        break;
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Por favor solo ingresa numero de 1 al 6");
            }

        }
//         CARGAR TXT

    }
}

