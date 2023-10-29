/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
/**

 * Esta clase define las listas y sus metodos

 * @author: Gianfranco Mongiello

 * @version: 24/10/23

 */
public class Listas {
// Campos de la clase
    NodE primero;
    int size;

    /**

     * Constructor para las listas
     
     */
    public Listas() {
        this.primero = null;
        this.size = 0;
    }

    public NodE getPrimero() {
        return primero;
    }

    public void setPrimero(NodE primero) {
        this.primero = primero;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
 /**

     * Método que permite agregar un nodo al final de la lista

     */
    public void insertar_fin(String dato) {
        NodE nuevo = new NodE(dato);
        NodE aux = primero;
        if (primero == null) {
            primero = nuevo;
        } else {
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
            size++;
        }
    }
    
     /**

     * Método que permite ver si la lista es vacia
     
     *@return si la lista contiene alguna informacion 

     */
    public boolean IsEmpty(){
        return this.primero == null;
    }//Cierre del metodo
    public void insertar_in(NodE nuevo) {

        if (primero == null) {
            primero = nuevo;
            size++;
        } else {
            nuevo.setSiguiente(primero);
            primero = nuevo;
            size++;
        }
    }//Cierre del metodo
 /**

     * Método que borrar un dato de la lista

     */
    public void delete(String dato) {
        NodE aux = primero;
        
        boolean encontrado = false;
        while(aux != null){
            if(aux.getSiguiente()!= null && aux.getSiguiente().getUsuario().equals(dato)){
                encontrado = true;
                break;
            }
            aux = aux.getSiguiente();
        }
        if (encontrado){
            aux.setSiguiente(aux.getSiguiente().getSiguiente());
        }
        
        
    }//Cierre del metodo
 /**

     * Método que permite buscar por el dato en la lista

     */
    public NodE search(String dato) {
        if (primero.getUsuario().equals(dato)) {
            return primero;
        } else {
            NodE aux = primero;
            while (aux != null && !aux.getUsuario().equals(dato)) {
                aux = aux.getSiguiente();
            }
            return aux;
        }//Cierre del metodo
    }
 /**

     * Método que permite imprimir la lista

     */
    public void imprimir() {
        NodE aux = primero;
        while (aux != null) {
            System.out.println(aux.getUsuario());
            aux = aux.getSiguiente();
        }//Cierre del metodo
    }
}
// Cierre de la clase listas