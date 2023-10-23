package main;

/**
 *
 * @author Asus
 */

import javax.swing.JOptionPane;

public class main {

    public static void main(String[] args) {

        String respuesta = JOptionPane.showInputDialog("Ingrese 'SI' si desea utilizar el programa, es caso contrario utilice 'NO'");

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

                String respuesta1 = JOptionPane.showInputDialog("Seleccione:  \n1. CARGAR ARCHIVO TXT\n2. MODIFICAR EL GRAFO\n3. ACTUALIZAR REPOSITORIO\n4. MOSTRAR GRAFO\n5. INDENTIFICACION DE COMPONENTES FUERTEMENTE CONECTADOS");
                int num1 = Integer.parseInt(respuesta1);

                if (num1 == 1) {

                    ArchivoTxt archivo = new ArchivoTxt();
                    archivo.LectorChooser();

                } else if (num1 == 2) {
                    String respuesta2 = JOptionPane.showInputDialog("\"Seleccione: \\n1. Eliminar Usuario\\n2. Agregar Usuario\\n3. Salir\"");
                    int num2 = Integer.parseInt(respuesta2);

                    if (num2 == 1) {

                    } else if (num2 == 2) {

                    } else {

                    }

                } else {
                    System.exit(0);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Por favor solo ingresa numero de 1 al 6");
            }
        }
    }
}
//         CARGAR TXT
