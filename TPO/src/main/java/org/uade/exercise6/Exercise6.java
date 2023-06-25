package org.uade.exercise6;
import org.uade.adt.definitions.ISet;
import org.uade.adt.dynamic.*;
import org.uade.adt.normal.*;

public class Exercise6 {

    public static void exercise6a(){
        LimitedStack pilaLimitada = new LimitedStack(5);
        pilaLimitada.add(1);
        pilaLimitada.add(2);
        pilaLimitada.add(3);
        pilaLimitada.add(4);
        pilaLimitada.add(5);

        pilaLimitada.add(6);
        pilaLimitada.add(7);
    }

    public static void exercise6b(){
        Set a1 = new Set();
        Set b2 = new Set();
        a1.add(1);
        a1.add(2);
        a1.add(3);
        a1.add(4);
        a1.add(5);

        b2.add(1);
        b2.add(2);
        b2.add(3);

        ISet test = a1.conjunto_complemento(b2);
        while (!test.isEmpty()){
            int element = test.choose();
            test.remove(element);
            System.out.println(element);
        }
    }

    public static void exercise6c(){
        DupQueue queue = new DupQueue();


        queue.add(5);
        queue.add(10);
        queue.add(15);

        int firstElement = queue.getFirst();
        queue.remove();

        boolean empty = queue.isEmpty();

        System.out.print("Elementos de la cola: ");
        while (!queue.isEmpty()) {
            int element = queue.getFirst();
            System.out.print(element + " ");
            queue.remove();
        }
    }

    public static void exercise6d(){
        CountedSet newset = new CountedSet();
        newset.add(1);
        newset.add(1);
        newset.add(1);
        newset.add(2);
        newset.add(3);
        while (!newset.isEmpty()){
            Counted a2 = newset.choose();
            System.out.println("Valor:" + a2.getValue() + " Cantidad: " + a2.getQty());
            newset.remove(a2.getValue());
        }
    }

    public static void exercise6e(){
            IProbGraph graph = new ProbGraph();

            // Add nodes to the graph
            graph.addNode(1);
            graph.addNode(2);
            graph.addNode(3);
            graph.addNode(4);

            // Add edges to the graph
            graph.addEdge(1, 2); // Add an edge from node 1 to node 2 with weight 5
            graph.addEdge(2, 3); // Add an edge from node 2 to node 3 with weight 3
            graph.addEdge(3, 4); // Add an edge from node 3 to node 4 with weight 2
            graph.addEdge(3, 1);
            // Display the graph
            displayGraph(graph);
        }

        public static void displayGraph(IProbGraph graph) {
            ISet nodes = graph.nodes();
            while (!nodes.isEmpty()) {
                int node = nodes.choose();
                System.out.println("Nodo: " + node);

                ISet total = graph.nodes();
                while (!total.isEmpty()) {
                    int adjacentNode = total.choose();
                    if (graph.edgeExists(node, adjacentNode)) {
                        double prob = graph.prob(node, adjacentNode);
                        System.out.println("Esta conectado a " + adjacentNode + " con probabilidad del " + Math.round(prob*100) + "%");
                    }
                    total.remove(adjacentNode);
                }
                System.out.println("---------------------");
                System.out.println();
                nodes.remove(node);
            }
        }


    public static void main(String[] args) {
        Exercise6 exercise6 = new Exercise6();
        exercise6e();
    }
}
