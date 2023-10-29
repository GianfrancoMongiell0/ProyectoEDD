package main;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**

 * Esta ventana define la ventana de las relaciones entre usuarios

 * @author: Cristian Fazio

 * @version: 26/10/23

 */
public class Ventana3 extends javax.swing.JFrame {
    // Campos de la clase
    public static Grafos g;
    public static String direccion_archivo;
    ArchivoTxt a = new ArchivoTxt();

    public Ventana3(Grafos grafos) {
        initComponents();
         this.setVisible(true);
        g=grafos;
        this.graf.setText(g.imprimir_grafo());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        usuario2 = new javax.swing.JTextField();
        usuario1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        graf = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("RELACIONES");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 180, 30));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 204, 204));
        jButton2.setText("Añadir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, -1, -1));

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(204, 204, 204));
        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, -1, -1));

        usuario2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuario2ActionPerformed(evt);
            }
        });
        jPanel1.add(usuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 170, -1));

        usuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuario1ActionPerformed(evt);
            }
        });
        jPanel1.add(usuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 170, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 204, 204));
        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, -1, -1));

        graf.setBackground(new java.awt.Color(0, 0, 0));
        graf.setColumns(20);
        graf.setForeground(new java.awt.Color(204, 204, 204));
        graf.setRows(5);
        jScrollPane1.setViewportView(graf);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, 300, 300));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    
        String u = a.validar(usuario1.getText());
        String z = a.validar(usuario2.getText());
    
        if (usuario1.getText().isEmpty() ||usuario2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se puede relacionar un usuario vacio", "ADVERTENCIA", 2);
        }else{
             g.nuevo_seguidor(u, z);
        
        a.escribirEnArchivo(g, "usuarios.txt");
        this.graf.setText(g.imprimir_grafo());

        g.imprimir_grafo();
//        a.EscribirTxt(direccion_archivo);

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void usuario2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuario2ActionPerformed
    }//GEN-LAST:event_usuario2ActionPerformed
    private void usuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuario1ActionPerformed
    }//GEN-LAST:event_usuario1ActionPerformed
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
 
        String u = a.validar(usuario1.getText());
        String z = a.validar(usuario2.getText());
        
        if (usuario1.getText().isEmpty() ||usuario2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se puede relacionar un usuario vacio", "ADVERTENCIA", 2);
        }else{
           g.eliminar_seguidor(u, z);
                        a.escribirEnArchivo(g, "usuarios.txt");
        this.graf.setText(g.imprimir_grafo());

        g.imprimir_grafo();
//        a.EscribirTxt(direccion_archivo);


    }//GEN-LAST:event_jButton3ActionPerformed
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        this.setVisible(false);
        try {
            Ventana v  = new Ventana(g);
        } catch (IOException ex) {
            Logger.getLogger(Ventana3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana3(g).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea graf;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField usuario1;
    private javax.swing.JTextField usuario2;
    // End of variables declaration//GEN-END:variables
}
// Cierre de la ventana 3
