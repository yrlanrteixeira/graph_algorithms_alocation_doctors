package main.java.com.doctorswithoutweekends.algorithm;

/**
 * Classe main.java.com.doctorswithoutweekends.algorithm.Edge que representa uma aresta em um grafo de fluxo.
 */
public class Edge {
    int to, capacity, flow;
    public Edge reverseEdge;

    /**
     * Construtor para a classe main.java.com.doctorswithoutweekends.algorithm.Edge.
     * @param to o nó de destino da aresta
     * @param capacity a capacidade da aresta
     */
    public Edge(int to, int capacity) {
        this.to = to;
        this.capacity = capacity;
        this.flow = 0;
    }
}
