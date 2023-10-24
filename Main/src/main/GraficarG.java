/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import static org.apache.commons.math3.stat.inference.TestUtils.g;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

/**
 *
 * @author Asus
 */
public class GraficarG {
    
    public void graficar(Grafos grafo){
        Graph g = new SingleGraph("grafo");
        
//        g.setAttribute("ui.stylesheet", "node { shape: circle; fill-color: #ADD8E6; text-color: #000000; size: 30px; } edge { size: 2px; shape: line; fill-color: #D3D3D3; }");
        
        for (int n = 0; n < grafo.max_usuarios; n++) {
            String user = grafo.usuarios[n].primero.getUsuario();
            Node usuarios = g.addNode(user);
            usuarios.setAttribute("ui.label", usuarios);}
         for (int n = 0; n <grafo. max_usuarios; n++) {
             String usuario = grafo.usuarios[n].primero.getUsuario();
             NodE aux = grafo.usuarios[n].primero.getSiguiente();
             while(aux != null){
                    g.addEdge(usuario + "-" + aux.getUsuario(), grafo.usuarios[n].primero.getUsuario(),aux.getUsuario());
                 aux = aux.getSiguiente();{{
                     System.setProperty("org.graphstream.ui", "org.graphstream.ui.swing");
         Viewer viewer  = g.display();
                     }   
                }
            }
        }
    }
}
