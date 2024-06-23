/**
 * Classe Edge que representa uma aresta em um grafo de fluxo.
 */
public class Edge {
    int to, capacity, flow;
    Edge reverseEdge;

    /**
     * Construtor para a classe Edge.
     * @param to o nó de destino da aresta
     * @param capacity a capacidade da aresta
     */
    Edge(int to, int capacity) {
        this.to = to;
        this.capacity = capacity;
        this.flow = 0;
    }
}
