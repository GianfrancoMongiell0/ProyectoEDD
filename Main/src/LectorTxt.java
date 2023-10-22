//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.swing.JFileChooser;
//import javax.swing.JOptionPane;
//import main.Grafos;
//import main.Listas;
//import main.NodE;
//
//public class LectorTxt {
//
//    public static void main(String[] args) {
//// Crear un objeto JFileChooser y asignarle un directorio inicial
//        JFileChooser jfc = new JFileChooser();
//        jfc.setCurrentDirectory(new File("C:\\Users\\usuario\\Desktop"));
//
//// Mostrar el diálogo de selección de archivos y obtener el valor de retorno
//        int resultado = jfc.showOpenDialog(null);
//
//// Si el usuario ha aceptado la operación
//        if (resultado == JFileChooser.APPROVE_OPTION) {
//// Obtener el archivo seleccionado
//            File archivo = jfc.getSelectedFile();
//
//// Crear un objeto BufferedReader para leer el archivo
//            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
//// Leer las líneas del archivo y mostrarlas por pantalla
//                Grafos grafito = new Grafos(2);
//
//                String linea;
//                while ((linea = br.readLine()) != null) {
//                                            
//                    if (linea.contains("@") && !linea.contains(",")) {
//                        NodE nodito = new NodE(linea);
//                        grafito.insertar_usuario(nodito);
//                        linea = " ";
//
//                    } else if(linea.contains("@") && linea.contains(","))  {
//                    String[] parte = linea.split(",");
//                    String parte1 = parte[0];
//                    String parte2 = parte[1];
//                    grafito.nuevo_seguidor(parte1, parte2);}
//                        
//                }grafito.imprimir_grafo();
//            } catch (IOException e) {
//// Manejar la excepción de entrada/salida
//                e.printStackTrace();
//            }
//        }
//    }
//
//}
