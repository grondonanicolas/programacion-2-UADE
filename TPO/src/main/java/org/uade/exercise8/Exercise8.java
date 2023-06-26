package org.uade.exercise8;
import org.uade.adt.Graph;
import org.uade.adt.IGraph;
import org.uade.adt.GenericSet;

public class Exercise8 {
    public void testGraph() {
        IGraph graph = new Graph();
        graph.addNode(0);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);
        graph.addNode(6);
        graph.addNode(7);
        graph.addNode(8);
        graph.addNode(9);

        //Agrego conexiones
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 0, 1);
        graph.addEdge(3, 4, 1);
        graph.addEdge(4, 5, 1);
        graph.addEdge(5, 6, 1);
        graph.addEdge(6, 4, 1);
        graph.addEdge(6, 7, 1);
        graph.addEdge(7, 8, 1);
        graph.addEdge(8, 9, 1);
        graph.addEdge(9, 7, 1);

        System.out.println(graph);

        GenericSet<IGraph> stronglyConnectedComponents = graph.stronglyConnectedComponents();
        System.out.println("Componentes fuertemente conexos:");

        while (!stronglyConnectedComponents.isEmpty()) {
            System.out.println("Subgrafo fuertemente conexo:");

            IGraph component = stronglyConnectedComponents.choose();
            System.out.println(component.toString());
            stronglyConnectedComponents.remove(component);
        }
    }
}
