///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package main;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
///**
// *
// * @author Asus
// */
//public class Grafos {
//
//    Listas[] usuarios;
//    int max_usuarios;
//
//    public Grafos(int max) {
//        this.usuarios = new Listas[max];
//        this.max_usuarios = max;
//    }
//
//    Grafos() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    public Listas[] getUsuarios() {
//        return usuarios;
//    }
//
//    public void setUsuarios(Listas[] usuarios) {
//        this.usuarios = usuarios;
//    }
//
//    public int getMax() {
//        return max_usuarios;
//    }
//
//    public void setMax(int max) {
//        this.max_usuarios = max;
//    }
//
//    public void insertar_usuario(NodE nodo) {
//        boolean enc = false;
//        for (int n = 0; n < max_usuarios; n++) {
//            if (usuarios[n] == null) {
//                usuarios[n] = new Listas();
//                usuarios[n].primero = nodo;
//                enc = true;
//                break;
//            }
//        }
//        if (!enc) {
//            nuevo_grafo(nodo);
//        }
//    }
//
//    public void nuevo_grafo(NodE nodo) {
//        Listas[] nuevo = new Listas[max_usuarios + 1];
//        for (int n = 0; n < max_usuarios; n++) {
//            nuevo[n] = new Listas();
//            nuevo[n].insertar_in(this.usuarios[n].primero);
//        }
//        nuevo[max_usuarios] = new Listas();
//        nuevo[max_usuarios].insertar_in(nodo);
//        this.usuarios = nuevo;
//        this.max_usuarios++;
//    }
//
//    public void eliminar_usuarios(String dato) {
//        for (int n = 0; n < max_usuarios; n++) {
//            if (this.usuarios[n].primero != null && this.usuarios[n].primero.getUsuario().equals(dato)) {
//                this.usuarios[n].primero = null;
//            } else {
//                NodE aux = new NodE(dato);
//                this.usuarios[n].delete(aux.getUsuario());
//            }
//        }
//    }
//
//    public void eliminar_seguidor(String usuario, String seguidor) {
//        Listas us = null;
//        boolean encontrado = false;
//        for (int i = 0; i < max_usuarios; i++) {
//            if (usuarios[i].primero.getUsuario().equals(usuario)) {
//                us = usuarios[i];
//            } else if (usuarios[i].primero.getUsuario().equals(seguidor)) {
//                encontrado = true;
//            }
//            if (encontrado && us != null) {
//                break;
//            }
//        }
//        if (encontrado && us != null) {
//            us.delete(seguidor);
//        }
//    }
//
//    public void nuevo_seguidor(String dato, String seguidor) {
//        for (int n = 0; n < max_usuarios; n++) {
//
//            if (this.usuarios[n] != null && this.usuarios[n].primero.getUsuario().equals(dato)) {
//
//                NodE aux = new NodE(seguidor);
//                this.usuarios[n].insertar_fin(aux.getUsuario());
//                break;
//            }
//        }
//    }
//
//    public String imprimir_grafo() {
//        String finalString = "usuarios\n";
//        for (int n = 0; n < max_usuarios; n++) {
//            if (this.usuarios[n] != null) {
//                finalString += this.usuarios[n].getPrimero().getUsuario() + "\n";
//            }
//        }
//
//        for (int n = 0; n < max_usuarios; n++) {
//            if (this.usuarios[n] != null) {
//                NodE aux = (NodE) this.usuarios[n].getPrimero().getSiguiente();
//                while (aux != null) {
//                    finalString += this.usuarios[n].getPrimero().getUsuario() + ", " + aux.getUsuario() + "\n";
//                    aux = aux.getSiguiente();
//                }
//            }
//
//        }
//        return finalString;
//    }
//
//    public NodE[][] kosaraju() {
//        NodE[][] components;
//        int numberOfComponents = 0;
//        NodE[] stack = new NodE[max_usuarios];
//        boolean[] visited = new boolean[max_usuarios];
//
//        // Step 1: Perform depth-first search (DFS) and push nodes onto the stack
//        int stackPointer = 0;
//        for (int i = 0; i < max_usuarios; i++) {
//            if (usuarios[i] != null && !visited[i]) {
//                dfs(i, visited, stack, stackPointer);
//            }
//        }
//
//        // Step 2: Transpose the graph
//        Grafos transposedGraph = transpose();
//
//        // Step 3: Perform DFS on the transposed graph while popping from the stack
//        visited = new boolean[max_usuarios];
//        components = new NodE[max_usuarios][];
//        while (stackPointer > 0) {
//            NodE node = stack[--stackPointer];
//            int index = getIndexFromUsuario(node.getUsuario());
//            if (!visited[index]) {
//                NodE[] component = dfs(index, visited, transposedGraph);
//                components[numberOfComponents++] = component;
//            }
//        }
//
//        // Resize components array to remove unused slots
//        NodE[][] resizedComponents = new NodE[numberOfComponents][];
//        System.arraycopy(components, 0, resizedComponents, 0, numberOfComponents);
//
//        return resizedComponents;
//    }
//
//    private void dfs(int index, boolean[] visited, NodE[] stack, int stackPointer) {
//        visited[index] = true;
//        NodE node = usuarios[index].getPrimero();
//        while (node != null) {
//            int neighborIndex = getIndexFromUsuario(node.getUsuario());
//            if (!visited[neighborIndex]) {
//                stack[stackPointer++] = node;
//                dfs(neighborIndex, visited, stack, stackPointer);
//            }
//            node = node.getSiguiente();
//        }
//    }
//
//    private NodE[] dfs(int index, boolean[] visited, Grafos transposedGraph) {
//        visited[index] = true;
//        List<NodE> component = new ArrayList<>();
//        if (usuarios[index] != null) {
//            component.add(usuarios[index].getPrimero());
//            NodE node = usuarios[index].getPrimero().getSiguiente();
//            while (node != null) {
//                int neighborIndex = getIndexFromUsuario(node.getUsuario());
//                if (!visited[neighborIndex]) {
//                    component.addAll(Arrays.asList(dfs(neighborIndex, visited, transposedGraph)));
//                }
//                node = node.getSiguiente();
//            }
//        }
//        return component.toArray(new NodE[0]);
//    }
//
//    private Grafos transpose() {
//        Grafos transposedGraph = new Grafos(max_usuarios);
//        for (int i = 0; i < max_usuarios; i++) {
//            if (usuarios[i] != null) {
//                NodE node = usuarios[i].getPrimero();
//                while (node != null) {
//                    transposedGraph.nuevo_seguidor(node.getUsuario(), usuarios[i].getPrimero().getUsuario());
//                    node = node.getSiguiente();
//                }
//            }
//        }
//        return transposedGraph;
//    }
//
//    private int getIndexFromUsuario(String usuario) {
//        for (int i = 0; i < max_usuarios; i++) {
//            if (usuarios[i] != null && usuarios[i].getPrimero().getUsuario().equals(usuario)) {
//                return i;
//            }
//        }
//        return -1; // If the usuario is not found
//    }
//}

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
           //&& this.usuarios[n].primero.getUsuario().equals(dato)
            if (this.usuarios[n].primero != null ) {
                this.usuarios[n].delete(dato);
            } else {
                NodE aux = new NodE(dato);
                this.usuarios[n].delete(aux.getUsuario());
            }
        }
    }

    public void eliminar_seguidor(String usuario, String seguidor){
        Listas us = null;
        boolean encontrado = false;
        for (int i = 0; i < max_usuarios; i++) {
            if(usuarios[i].primero.getUsuario().equals(usuario)){
                us = usuarios[i];
        }else if (usuarios[i].primero.getUsuario().equals(seguidor)){
            encontrado = true;
        }
            if (encontrado && us!=null){break;}
        }
        if (encontrado && us!=null){
        us.delete(seguidor);}
    }

  
    public void nuevo_seguidor(String dato, String seguidor) {
        for (int n = 0; n < max_usuarios; n++) {
            
            if (this.usuarios[n]!= null && this.usuarios[n].primero.getUsuario().equals(dato)) {

                NodE aux = new NodE(seguidor);
                this.usuarios[n].insertar_fin(aux.getUsuario());
                break;
            }
        }
    }

    public String imprimir_grafo() {
        String finalString = "usuarios\n";
        for (int n = 0; n < max_usuarios; n++) {
            if (this.usuarios[n] != null) {
                finalString+= this.usuarios[n].getPrimero().getUsuario() + "\n";}}
        
         for (int n = 0; n < max_usuarios; n++) {
            if (this.usuarios[n] != null) {      
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
    for (int i = 0; i < max_usuarios; i++) {
        if (usuarios[i] != null) {
            NodE node = usuarios[i].getPrimero();
            while (node != null) {
                transposedGraph.nuevo_seguidor(node.getUsuario(), usuarios[i].getPrimero().getUsuario());
                node = node.getSiguiente();
            }
        }
    }
    return transposedGraph;
}

private int getIndexFromUsuario(String usuario) {
    for (int i = 0; i < max_usuarios; i++) {
        if (usuarios[i] != null && usuarios[i].getPrimero().getUsuario().equals(usuario)) {
            return i;
        }
    }
    return -1; // If the usuario is not found
}
}