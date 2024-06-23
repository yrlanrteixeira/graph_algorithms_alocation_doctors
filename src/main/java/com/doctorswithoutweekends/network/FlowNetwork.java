package main.java.com.doctorswithoutweekends.network;

import main.java.com.doctorswithoutweekends.algorithm.Edge;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe main.java.com.doctorswithoutweekends.network.FlowNetwork que representa um grafo de fluxo.
 */
public class FlowNetwork {
    public List<List<Edge>> adjList;

    /**
     * Construtor para a classe main.java.com.doctorswithoutweekends.network.FlowNetwork.
     * @param numNodes o número de nós no grafo
     */
    public FlowNetwork(int numNodes){
        adjList = new ArrayList<>(numNodes);
        for(int i = 0; i < numNodes; i++){
            adjList.add(new ArrayList<>());
        }
    }

    /**
     * Método para adicionar uma aresta ao grafo.
     * @param from o nó de origem da aresta
     * @param to o nó de destino da aresta
     * @param capacity a capacidade da aresta
     */
    public void addEdge(int from, int to, int capacity){
        Edge foward = new Edge(to, capacity);
        Edge reverse = new Edge(from, 0);
        foward.reverseEdge = reverse;
        reverse.reverseEdge = foward;
        adjList.get(from).add(foward);
        adjList.get(to).add(reverse);
    }

    /**
     * Método para obter as arestas de um nó específico.
     * @param node o nó para o qual obter as arestas
     * @return uma lista de arestas do nó
     */
    public List<Edge> getEdges(int node){
        return adjList.get(node);
    }
}
