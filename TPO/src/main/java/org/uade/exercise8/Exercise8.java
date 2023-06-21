package org.uade.exercise8;
import org.uade.adt.Graph;
import org.uade.adt.IGraph;
import org.uade.adt.GenericSet;

public class Exercise8 {
    public void testGraph() {
        IGraph graph = new Graph();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        //Agrego conexiones
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 3, 1);

        System.out.println(graph.toString());

        GenericSet<IGraph> stronglyConnectedComponents = graph.stronglyConnectedComponents();
        System.out.println("Componentes fuertemente conexos:");

        while (!stronglyConnectedComponents.isEmpty()) {
            IGraph component = stronglyConnectedComponents.choose();
            System.out.println(component.toString());
            stronglyConnectedComponents.remove(component);
        }
    }
}
