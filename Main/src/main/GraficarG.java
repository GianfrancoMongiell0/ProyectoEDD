/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.HashMap;
import java.util.Map;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

/**
 *
 * @author Asus
 */
public class GraficarG {
     Listas[] usuarios;
    int max_usuarios;
    
   public void graficar(Grafos grafo) {
   
    System.setProperty("org.graphstream.ui", "org.graphstream.ui.swing");
   
    Graph g = new SingleGraph("grafo");

    // Definir el estilo del grafo
    g.setAttribute("ui.stylesheet", "node { shape: circle; fill-color: #ADD8E6; text-color: #000000; size: 30px; }" + "edge { size: 2px; shape: line; fill-color: #D3D3D3; }");
   
    // Recorrer los nodos y agregarlos al grafo
    for (int n = 0; n < grafo.max_usuarios; n++) {
        String usuario = grafo.usuarios[n].primero.getUsuario();
        Node nodo = g.addNode(usuario);
        nodo.setAttribute("ui.label", usuario);
    }

    // Recorrer las relaciones y agregar las aristas
    for (int n = 0; n < grafo.max_usuarios; n++) {
        String usuario = grafo.usuarios[n].primero.getUsuario();
        NodE aux = grafo.usuarios[n].primero.getSiguiente();

        while (aux != null) {
            g.addEdge(usuario + "-" + aux.getUsuario(), usuario, aux.getUsuario());
            aux = aux.getSiguiente();
        }
    }
    // Mostrar el grafo en una ventana
    Viewer viewer = g.display();
    }
}