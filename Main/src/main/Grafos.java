/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author Asus
 */
public class Grafos {
    
    Listas [] usuarios;
    int max_usuarios;

    public Grafos(int max) {
        this.usuarios = new Listas [max];
        this.max_usuarios = max;
    }

    public Listas[] getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Listas[] usuarios) {
        this.usuarios = usuarios;
    }

    public int getMax() {
        return max_usuarios;
    }

    public void setMax(int max) {
        this.max_usuarios = max;
    }
    
    public void insertar_usuario(NodE nodo){
        boolean enc =  false;
        for (int n = 0; n < max_usuarios; n++) {
                  if (usuarios[n]== null){
                  usuarios[n] = new Listas();
                  usuarios[n].primero = nodo;
                  enc = true;
                  break;
     }
     }       
        if (!enc){nuevo_grafo(nodo);}}
        
         public void nuevo_grafo(NodE nodo){
            Listas[] nuevo = new Listas[max_usuarios +1];
            for (int n= 0; n < max_usuarios; n++) {
                            nuevo[n] =new Listas();
                  nuevo[n].insertar_in(this.usuarios[n].primero);
     }
           nuevo[max_usuarios] = new Listas();
           nuevo[max_usuarios].insertar_in(nodo);
                  this.usuarios = nuevo;
                  this.max_usuarios ++;
     }
         public void eliminar_usuarios(String dato){
             for (int n = 0; n < max_usuarios; n++){
                if (this.usuarios[n].primero != null && this.usuarios[n].primero.getUsuario().equals(dato)){
                this.usuarios[n].primero = null;
         }else{
                        NodE aux = new NodE(dato);
                        this.usuarios[n].delete(aux.getUsuario());
     }
     }
     }
         public void nuevo_seguidor(String dato, String seguidor){
             for (int n = 0; n < max_usuarios; n++) {
                 if (this.usuarios[n].primero.getUsuario().equals(dato)){
                     
                     NodE aux = new NodE(seguidor);
                     this.usuarios[n].insertar_fin(aux.getUsuario());
                     break;
     }
     }
     }
         public void imprimir_grafo(){
            for (int n = 0; n < max_usuarios; n++) {
            if (this.usuarios[n].getPrimero() != null){
            NodE aux = (NodE) this.usuarios[n].getPrimero();
            if (aux.getSiguiente() == null ){System.out.println("El usuario " + aux.getUsuario() + ", no esta siguiendo a nadie.");
            
            }else{
                String lista ="El usuario "+ aux.getUsuario()+ ", sigue a ";
                aux = aux.getSiguiente();
                    System.out.println(n);
               
            while(aux!=null){
                    lista+= aux.getUsuario() + " ";
                    aux = aux.getSiguiente();
     }
                System.out.println(lista);
     }
     }
     }
     }
     }
