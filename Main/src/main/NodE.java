/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author Asus
 */
public class NodE {

    String usuario;
    NodE siguiente;

    public NodE(String usuario) {
        this.usuario = usuario;
        this.siguiente = null;

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public NodE getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodE siguiente) {
        this.siguiente = siguiente;
    }

}
