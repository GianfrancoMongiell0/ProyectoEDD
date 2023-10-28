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

    Listas[] usuarios;
    int max_usuarios;

    public Grafos(int max) {
        this.usuarios = new Listas[max];
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

    public void insertar_usuario(NodE nodo) {
        boolean enc = false;
        for (int n = 0; n < max_usuarios; n++) {
            if (usuarios[n] == null) {
                usuarios[n] = new Listas();
                usuarios[n].primero = nodo;
                enc = true;
                break;
            }
        }
        if (!enc) {
            nuevo_grafo(nodo);
        }
    }

    public void nuevo_grafo(NodE nodo) {
        Listas[] nuevo = new Listas[max_usuarios + 1];
        for (int n = 0; n < max_usuarios; n++) {
            nuevo[n] = new Listas();
            nuevo[n].insertar_in(this.usuarios[n].primero);
        }
        nuevo[max_usuarios] = new Listas();
        nuevo[max_usuarios].insertar_in(nodo);
        this.usuarios = nuevo;
        this.max_usuarios++;
    }

    public void eliminar_usuarios(String dato) {
            for (int n = 0; n < max_usuarios; n++) {
                if (this.usuarios[n] != null){
         if (this.usuarios[n].primero != null && this.usuarios[n].primero.getUsuario().equals(dato)) {
                this.usuarios[n].primero = null;
         }else{
                    NodE aux = new NodE(dato);
                    this.usuarios[n].delete(aux.getUsuario());
            }
        }
    }
}
    public void eliminar_seguidor(String usuario, String seguidor){
        Listas us = null;
        boolean encontrado = false;
        for (int n = 0; n < max_usuarios; n++) {
            if(this.usuarios[n] != null && this.usuarios[n].getPrimero()!= null){
            if(this.usuarios[n].primero.getUsuario().equals(usuario)){
                us = usuarios[n];
        }else if (usuarios[n].primero.getUsuario().equals(seguidor)){
            encontrado = true;
        }
            if (encontrado && us!=null){break;}
        }
        if (encontrado && us!=null){
        us.delete(seguidor);}
    }
}
  
    public void nuevo_seguidor(String dato, String seguidor) {
        for (int n = 0; n < max_usuarios; n++) {
            
            if (this.usuarios[n]!= null && this.usuarios[n].getPrimero() != null && this.usuarios[n].primero.getUsuario().equals(dato)) {

                NodE aux = new NodE(seguidor);
                this.usuarios[n].insertar_fin(aux.getUsuario());
                break;
            }
        }
    }

    public String imprimir_grafo() {
        String finalString = "usuarios\n";
        for (int n = 0; n < max_usuarios; n++) {
            if (this.usuarios[n]!= null && this.usuarios[n].getPrimero()!=null){
                finalString+= this.usuarios[n].getPrimero().getUsuario() + "\n";}}
        
         for (int n = 0; n < max_usuarios; n++) {
            if (this.usuarios[n]!= null && this.usuarios[n].getPrimero()!=null) {      
                NodE aux = (NodE) this.usuarios[n].getPrimero().getSiguiente();
                while(aux!= null){
                    finalString +=  this.usuarios[n].getPrimero().getUsuario() + ", " + aux.getUsuario() + "\n";
                    aux = aux.getSiguiente();}
                }
            
         }
         return finalString;
    }
       public Listas[] kosaraju() {
    Listas[] components = new Listas[max_usuarios];
    int componentIndex = 0;

    int[] num = new int[max_usuarios];
    int numIndex = 0;
    boolean[] visited = new boolean[max_usuarios];
    for (int i = 0; i < max_usuarios; i++) {
        if (usuarios[i] != null && !visited[i]) {
            dfs(i, visited, num, numIndex);
        }
    }

   
    Grafos transposedGraph = transpose();

    visited = new boolean[max_usuarios];
    while (numIndex > 0) {
        int nodeIndex = num[--numIndex];
        if (!visited[nodeIndex]) {
            Listas component = new Listas();
            dfs(nodeIndex, visited, component);
            components[componentIndex++] = component;
        }
    }

    if (componentIndex < components.length) {
        Listas[] trimmedComponents = new Listas[componentIndex];
        System.arraycopy(components, 0, trimmedComponents, 0, componentIndex);
        components = trimmedComponents;
    }

    return components;
}

private void dfs(int index, boolean[] visited, int[] num1, int num1Index) {
    visited[index] = true;
    NodE node = usuarios[index].getPrimero();
    while (node != null) {
        int neighborIndex = getIndexFromUsuario(node.getUsuario());
        if (!visited[neighborIndex]) {
            num1[num1Index++] = neighborIndex;
            dfs(neighborIndex, visited, num1, num1Index);
        }
        node = node.getSiguiente();
    }
}

private void dfs(int index, boolean[] visited, Listas component) {
    visited[index] = true;
    if (usuarios[index] != null) {
        component.insertar_fin(usuarios[index].getPrimero().getUsuario());
        NodE node = usuarios[index].getPrimero().getSiguiente();
        while (node != null) {
            int neighborIndex = getIndexFromUsuario(node.getUsuario());
            if (!visited[neighborIndex]) {
                dfs(neighborIndex, visited, component);
            }
            node = node.getSiguiente();
        }
    }
}

private Grafos transpose() {
    Grafos transposedGraph = new Grafos(max_usuarios);
    for (int n = 0; n < max_usuarios; n++) {
        if (usuarios[n] != null) {
            NodE node = usuarios[n].getPrimero();
            while (node != null) {
                transposedGraph.nuevo_seguidor(node.getUsuario(), usuarios[n].getPrimero().getUsuario());
                node = node.getSiguiente();
            }
        }
    }
    return transposedGraph;
}

private int getIndexFromUsuario(String usuario) {
    for (int n = 0; n < max_usuarios; n++) {
        if (this.usuarios[n] != null && this.usuarios[n].getPrimero()!= null && this.usuarios[n].getPrimero().getUsuario().equals(usuario)) {
            return n;
        }
    }
    return -1;
    }
}

