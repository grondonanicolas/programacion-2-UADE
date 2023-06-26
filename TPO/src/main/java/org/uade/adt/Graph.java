package org.uade.adt;

public class Graph implements IGraph {

    private static final int MAX_NODES = 15;

    private final int[][] adjacencyMatrix;
    private final IDictionary dictionary;
    private int totalNodes;
    public Graph() {
        this.adjacencyMatrix = new int[MAX_NODES][MAX_NODES];
        this.dictionary = new Dictionary(); // Asumo que el límite es mayor a MAX_NODES
        this.totalNodes = 0;
    }

    @Override
    public void addNode(int node) {
        if(this.totalNodes == 0) { // Greedy
            this.dictionary.add(node, this.totalNodes);
            this.totalNodes++;
            return;
        }

        // Esto se puede colocar dentro de un condicional this.totalNodes != 0
        ISet nodes = this.dictionary.getKeys();
        while(!nodes.isEmpty()) {
            int current = nodes.choose();
            if(current == node) {
                System.out.println("El nodo ya existe");
                return;
            }
            nodes.remove(current);
        }

        this.dictionary.add(node, this.totalNodes);
        this.totalNodes++;
    }

    @Override
    public void removeNode(int node) {
        if(this.totalNodes == 0) { // Greedy
            throw new RuntimeException("El nodo no existe");
        }

        // Esto se puede colocar dentro de un condicional this.totalNodes != 0
        int before = this.totalNodes;
        ISet nodes = this.dictionary.getKeys();
        int index = this.dictionary.getValue(node);
        int last = -1;
        while(!nodes.isEmpty()) {
            int current = nodes.choose();
            if(this.dictionary.getValue(current) == before - 1) {
                last = current;
            }
            if(current == node) {
                this.dictionary.remove(node, index);
                this.totalNodes--;
            }
            nodes.remove(current);
        }
        int after = this.totalNodes;

        if(before != after) { // Evito complejidad cúbica
            for(int i = 0; i < before; i++) {
                this.adjacencyMatrix[i][index] = this.adjacencyMatrix[i][after];
                this.adjacencyMatrix[index][i] = this.adjacencyMatrix[after][i];
            }

            this.dictionary.remove(last, this.dictionary.getValue(last));
            this.dictionary.add(last, index);
            return;
        }

        throw new RuntimeException("El nodo no existe");
    }

    @Override
    public ISet nodes() {
        return this.dictionary.getKeys();
    }

    @Override
    public void addEdge(int from, int to, int weight) {
        if(this.notIn(from) || this.notIn(to)) {
            throw new RuntimeException("No existe alguno de los nodos");
        }

        int indexFrom = this.dictionary.getValue(from);
        int indexTo = this.dictionary.getValue(to);

        if(this.adjacencyMatrix[indexFrom][indexTo] != 0) {
            throw new RuntimeException("Ya existe la arista");
        }

        this.adjacencyMatrix[indexFrom][indexTo] = weight;
    }

    private boolean notIn(int node) {
        ISet nodes = this.dictionary.getKeys();
        while(!nodes.isEmpty()) {
            int current = nodes.choose();
            if(current == node) {
                return false;
            }
            nodes.remove(current);
        }
        return true;
    }

    @Override
    public void removeEdge(int from, int to) {
        if(!edgeExists(from, to)) {
            throw new RuntimeException("No existe la arista");
        }

        int indexFrom = this.dictionary.getValue(from);
        int indexTo = this.dictionary.getValue(to);

        this.adjacencyMatrix[indexFrom][indexTo] = 0;
    }

    @Override
    public boolean edgeExists(int from, int to) {
        if(notIn(from) || notIn(to)) {
            return false;
        }

        int indexFrom = this.dictionary.getValue(from);
        int indexTo = this.dictionary.getValue(to);

        return this.adjacencyMatrix[indexFrom][indexTo] != 0;
    }

    @Override
    public int weight(int from, int to) {
        if(!edgeExists(from, to)) {
            throw new RuntimeException("No existe la arista");
        }

        int indexFrom = this.dictionary.getValue(from);
        int indexTo = this.dictionary.getValue(to);

        return this.adjacencyMatrix[indexFrom][indexTo];
    }
    @Override
    public IGenericSet getNeighbors(int node) {
        IGenericSet neighbors = new GenericSet();
        ISet nodes = this.nodes();
        while (!nodes.isEmpty()) {
            int current = nodes.choose();
            if (edgeExists(node, current)) {
                neighbors.add(current);
            }
            nodes.remove(current);
        }
        return neighbors;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        ISet nodes = this.nodes();

        while (!nodes.isEmpty()) {
            int current = nodes.choose();
            sb.append("Nodo ").append(current).append(":");
            IGenericSet<Integer> neighbors = getNeighbors(current);
            if (!neighbors.isEmpty()) {
                while (!neighbors.isEmpty()) {
                    int neighbor = neighbors.choose();
                    int weight = weight(current, neighbor);
                    sb.append(" [").append(neighbor).append(", ").append(weight).append("]");
                    neighbors.remove(neighbor);
                }
            } else {
                sb.append(" Sin vecinos");
            }
            sb.append("\n");
            nodes.remove(current);
        }

        return sb.toString();
    }

    @Override
    public boolean hasNode(int node){
        ISet nodes = this.nodes();
        int nodeCandidate = nodes.choose();
        while (!nodes.isEmpty()){
            if (nodeCandidate == node){
                return true;
            }
            nodes.remove(nodeCandidate);
            nodeCandidate = nodes.choose();

        }
        return false;
    }
    private void copyEdges(IGraph originalGraph, IGraph scc, int node) {
        IGenericSet<Integer> neighbors = originalGraph.getNeighbors(node);
        while (!neighbors.isEmpty()) {
            int neighbor = neighbors.choose();
            if (scc.hasNode(neighbor)) {
                scc.addEdge(node, neighbor, originalGraph.weight(node, neighbor));
            }
            neighbors.remove(neighbor);
        }
    }

    @Override
    public GenericSet<IGraph> stronglyConnectedComponents() {
        GenericSet<IGraph> result = new GenericSet<>();

        // Paso 1: Realizar un recorrido DFS para obtener el ordenamiento
        IStack stack = new Stack();
        boolean[] visited = new boolean[totalNodes];
        for (int i = 0; i < totalNodes; i++) {
            if (!visited[i]) {
                dfsTopologicalSort(i, visited, stack);
            }
        }

        // Paso 2: Transponer el grafo
        Graph transposedGraph = transpose();

        // Paso 3: Realizar un recorrido DFS en el grafo transpuesto siguiendo el ordenamiento
        visited = new boolean[totalNodes];
        while (!stack.isEmpty()) {
            int node = stack.getTop();
            stack.remove();
            if (!visited[node]) {
                IGraph scc = new Graph();
                transposedGraph.dfsStrongConnect(node, visited, scc);
                result.add(scc);
            }
        }

        return result;
    }

    private void dfsTopologicalSort(int node, boolean[] visited, IStack stack) {
        visited[node] = true;
        IGenericSet<Integer> neighbors = getNeighbors(node);
        while (!neighbors.isEmpty()) {
            int neighbor = neighbors.choose();
            if (!visited[neighbor]) {
                dfsTopologicalSort(neighbor, visited, stack);
            }
            neighbors.remove(neighbor);
        }
        stack.add(node);
    }

    private void dfsStrongConnect(int node, boolean[] visited, IGraph scc) {
        visited[node] = true;
        scc.addNode(node);
        IGenericSet<Integer> neighbors = getNeighbors(node);
        while (!neighbors.isEmpty()) {
            int neighbor = neighbors.choose();
            if (!visited[neighbor]) {
                dfsStrongConnect(neighbor, visited, scc);
            }
            neighbors.remove(neighbor);
        }
        copyEdges(this, scc, node);
    }

    private Graph transpose() {
        Graph transposedGraph = new Graph();
        for (int i = 0; i < totalNodes; i++) {
            transposedGraph.addNode(i);
        }
        ISet nodes = nodes();
        while (!nodes.isEmpty()) {
            int node = nodes.choose();
            IGenericSet<Integer> neighbors = getNeighbors(node);
            while (!neighbors.isEmpty()) {
                int neighbor = neighbors.choose();
                transposedGraph.addEdge(neighbor, node, weight(node, neighbor));
                neighbors.remove(neighbor);
            }
            nodes.remove(node);
        }
        return transposedGraph;
    }


}
