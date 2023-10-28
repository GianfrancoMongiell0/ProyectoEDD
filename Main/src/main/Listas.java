/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author Asus
 */
public class Listas {

    NodE primero;
    int size;

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
    public boolean IsEmpty(){
        return this.primero == null;
    }
    public void insertar_in(NodE nuevo) {

        if (primero == null) {
            primero = nuevo;
            size++;
        } else {
            nuevo.setSiguiente(primero);
            primero = nuevo;
            size++;
        }
    }

    public void delete(String dato) {
        NodE aux = this.primero;
        
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
        
        
    }

    public NodE search(String dato) {
        if (primero.getUsuario().equals(dato)) {
            return primero;
        } else {
            NodE aux = primero;
            while (aux != null && !aux.getUsuario().equals(dato)) {
                aux = aux.getSiguiente();
            }
            return aux;
        }
    }

    public void imprimir() {
        NodE aux = primero;
        while (aux != null) {
            System.out.println(aux.getUsuario());
            aux = aux.getSiguiente();
        }
    }
}
