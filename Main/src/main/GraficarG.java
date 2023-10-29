
package main;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;
/**

 * Esta clase define la graficacion del grafo

 * @author: Cristian Fazio

 * @version: 26/10/23

 */
public class GraficarG {
// Campos de la clase
    Listas[] usuarios;
    int max_usuarios;

     /**

     * Método que permite hacer la graficacion del grafo

     */
    public void graficar(Grafos grafo) {
        System.setProperty("org.graphstream.ui", "org.graphstream.ui.swing");

        Graph g = new SingleGraph("grafo");


        g.setAttribute("ui.stylesheet", "node { shape: circle; fill-color: #ADD8E6; text-color: #000000; size: 30px; }"
                + "edge { size: 2px; shape: line; fill-color: #D3D3D3; }");


        for (int n = 0; n < grafo.max_usuarios; n++) {
            if (grafo.getUsuarios()[n] != null) {
                String usuario = grafo.getUsuarios()[n].getPrimero().getUsuario();
                Node nodo = g.addNode(usuario);
                nodo.setAttribute("ui.label", usuario);
            }
        }

        for (int n = 0; n < grafo.max_usuarios; n++) {
            if (grafo.getUsuarios()[n] != null) {
                String usuario = grafo.getUsuarios()[n].getPrimero().getUsuario();
                NodE aux = grafo.getUsuarios()[n].getPrimero().getSiguiente();

                while (aux != null) {
                    String targetUsuario = aux.getUsuario();
                    g.addEdge(usuario + "-" + targetUsuario, usuario, targetUsuario);
                    aux = aux.getSiguiente();
                }
            }
        }

        Listas[] components = grafo.kosaraju();

        for (Listas component : components) {
            changeEdgeColorForComponent(g, component);
        }

        Viewer viewer = g.display();
    }//Cierre del metodo

    private void changeEdgeColorForComponent(Graph g, Listas component) {
        NodE node = component.getPrimero();
        NodE nextNode = (node != null) ? node.getSiguiente() : null;

        while (nextNode != null) {
            Edge edge = g.getEdge(node.getUsuario() + "-" + nextNode.getUsuario());
            if (edge != null) {
                edge.setAttribute("ui.style", "fill-color: red;");
            }

            node = nextNode;
            nextNode = node.getSiguiente();
        }
    }
}
// Cierre de la clase GraficarG