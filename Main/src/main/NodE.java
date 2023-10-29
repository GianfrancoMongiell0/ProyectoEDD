/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
/**

 * Esta clase define el uso de los nodos

 * @author: GIanfranco Mongiello

 * @version: 24/10/23

 */
public class NodE {
// Campos de la clase
    String usuario;
    NodE siguiente;

    
    /**

     * Constructor para los nodos

     */
    public NodE(String usuario) {
        this.usuario = usuario;
        this.siguiente = null;

    }
     /**

     * Método que permite acceder a la informacion del usuario

     */

    public String getUsuario() {
        return usuario;
    }//Cierre del metodo
 /**

     * Método que permite cambiar la direccion del siguiente usuario

     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }//Cierre del metodo
 /**

     * Método que permite acceder a los datos siguiente nodo

     */
    public NodE getSiguiente() {
        return siguiente;
    }//Cierre del metodo
 /**

     * Método que permite cambiar las direccion del siguiente nodo

     */
    public void setSiguiente(NodE siguiente) {
        this.siguiente = siguiente;
    }

}//Cierre del metodo
// Cierre de la clase NodE
