package org.uade.adt;

public class Graph implements IGraph {

    private static final int MAX_NODES = 15;

    private final int[][] adjacencyMatrix;
    private final IDictionary dictionary;
    private int totalNodes;

    //news
    private int time = 0;
    private int[] lowlink;
    private boolean[] onStack;
    private IStack stack;

    //end news
    public Graph() {
        this.adjacencyMatrix = new int[MAX_NODES][MAX_NODES];
        this.dictionary = new Dictionary(); // Asumo que el límite es mayor a MAX_NODES
        this.totalNodes = 0;
        //news
        this.lowlink = new int[MAX_NODES];
        this.onStack = new boolean[MAX_NODES];
        this.stack = new Stack();
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
                throw new RuntimeException("El nodo ya existe");
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
    public GenericSet<IGraph> stronglyConnectedComponents() {
        time = 0;
        GenericSet<IGraph> result = new GenericSet<>();
        for (int i = 0; i < totalNodes; i++) {
            if (lowlink[i] == 0) {
                strongconnect(i, result);
            }
        }
        return result;

    }
    private void strongconnect(int node, IGenericSet<IGraph> result) {
        lowlink[node] = ++time;
        int discovery = lowlink[node];
        stack.add(node);
        onStack[node] = true;

        IGenericSet<Integer> neighbors = getNeighbors(node);
        while (!neighbors.isEmpty()) {
            int v = neighbors.choose();
            if (lowlink[v] == 0) {
                strongconnect(v, result);
                lowlink[node] = Math.min(lowlink[node], lowlink[v]);
            } else if (onStack[v]) {
                lowlink[node] = Math.min(lowlink[node], lowlink[v]);
            }
            neighbors.remove(v);
        }

        if (lowlink[node] == discovery) {
            IGraph scc = new Graph();
            int w;
            do {
                w = stack.getTop();
                stack.remove();
                onStack[w] = false;
                scc.addNode(w);
                copyEdges(this, scc, w);
            } while (w != node);
            result.add(scc);
        }
    }

    private void copyEdges(IGraph source, IGraph target, int node) {
        IGenericSet<Integer> neighbors = source.getNeighbors(node);
        while (!neighbors.isEmpty()) {
            int neighbor = neighbors.choose();
            target.addNode(neighbor);
            target.addEdge(node, neighbor, source.weight(node, neighbor));
            neighbors.remove(neighbor);
        }
    }



}
