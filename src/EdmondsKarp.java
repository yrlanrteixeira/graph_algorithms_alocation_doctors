import java.util.*;

/**
 * Classe EdmondsKarp que implementa o algoritmo de Edmonds-Karp para encontrar o fluxo máximo em um grafo de fluxo.
 */
public class EdmondsKarp {
    /**
     * Método para realizar uma busca em largura no grafo de fluxo.
     * @param graph o grafo de fluxo
     * @param source o nó de origem
     * @param sink o nó de destino
     * @param parent o array de pais dos nós
     * @return o fluxo máximo encontrado
     */
    int bfs(FlowNetwork graph, int source, int sink, int[] parent) {
        Arrays.fill(parent, -1);
        parent[source] = source;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{source, Integer.MAX_VALUE});

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int node = current[0];
            int flow = current[1];

            for(Edge edge : graph.getEdges(node)){
                if(parent[edge.to] == -1 && edge.capacity > edge.flow){
                    parent[edge.to] = node;
                    int newFlow = Math.min(flow, edge.capacity - edge.flow);
                    if(edge.to == sink){
                        return newFlow;
                    }
                    queue.add(new int[]{edge.to, newFlow});
                }

            }
        }
        return 0;
    }

    /**
     * Método para encontrar o fluxo máximo em um grafo de fluxo.
     * @param graph o grafo de fluxo
     * @param source o nó de origem
     * @param sink o nó de destino
     * @return o fluxo máximo encontrado
     */
    int maxFlow(FlowNetwork graph, int source, int sink){
        int flow = 0;
        int[] parent = new int[graph.adjList.size()];
        int newFlow;

        while((newFlow = bfs(graph, source, sink, parent)) != 0){
            flow += newFlow;
            int current = sink;

            while(current != source){
                int prev = parent[current];
                for(Edge edge : graph.getEdges(prev)){
                    if(edge.to == current){
                        edge.flow += newFlow;
                        edge.reverseEdge.flow -= newFlow;
                        break;
                    }
                }
                current = prev;
            }
        }
        return flow;
    }

    /**
     * Método estático para atribuir médicos a dias de férias.
     * @param doctors um mapa de médicos para seus dias disponíveis
     * @param vacationPeriods um mapa de períodos de férias para seus dias
     * @param c o número máximo de dias de férias que um médico pode trabalhar
     */
    static void assignDoctors(Map<Integer, Set<Integer>> doctors, Map<Integer, Set<Integer>> vacationPeriods, int c) {
        int source = 0;
        int numDoctors = doctors.size();
        int numDays = vacationPeriods.values().stream().mapToInt(Set::size).sum();
        int sink = numDoctors + numDays + vacationPeriods.size() + 1;

        FlowNetwork graph = new FlowNetwork(sink + 1);
        Map<Integer, Integer> doctorToNode = new HashMap<>();
        Map<Integer, Integer> dayToNode = new HashMap<>();
        Map<Integer, Integer> periodToNode = new HashMap<>();

        int doctorIdx = 1;
        for (Integer doctor : doctors.keySet()) {
            doctorToNode.put(doctor, doctorIdx++);
        }

        int dayIdx = numDoctors + 1;
        for (Set<Integer> days : vacationPeriods.values()) {
            for (Integer day : days) {
                dayToNode.put(day, dayIdx++);
            }
        }

        int periodIdx = numDoctors + numDays + 1;
        for (Integer period : vacationPeriods.keySet()) {
            periodToNode.put(period, periodIdx++);
        }

        for (Map.Entry<Integer, Set<Integer>> entry : doctors.entrySet()) {
            int doctorNode = doctorToNode.get(entry.getKey());
            graph.addEdge(source, doctorNode, c);

            for (Integer day : entry.getValue()) {
                for (Map.Entry<Integer, Set<Integer>> periodEntry : vacationPeriods.entrySet()) {
                    if (periodEntry.getValue().contains(day)) {
                        int periodNode = periodToNode.get(periodEntry.getKey());
                        graph.addEdge(doctorNode, periodNode, 1);
                        graph.addEdge(periodNode, dayToNode.get(day), 1);
                    }
                }
            }
        }

        for (int dayNode : dayToNode.values()) {
            graph.addEdge(dayNode, sink, 1);
        }

        EdmondsKarp edmondsKarp = new EdmondsKarp();
        int maxFlow = edmondsKarp.maxFlow(graph, source, sink);

        if (maxFlow == numDays) {
            System.out.println("É possível realizar a seguinte atribuição de médicos:");
            Map<Integer, Map<Integer, Integer>> doctorDayPeriodAssignment = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : doctorToNode.entrySet()) {
                int doctorNode = entry.getValue();
                for (Edge edge : graph.getEdges(doctorNode)) {
                    if (edge.flow > 0) {
                        for (Edge dayEdge : graph.getEdges(edge.to)) {
                            if (dayEdge.flow > 0) {
                                int day = dayToNode.entrySet().stream()
                                        .filter(e -> e.getValue().equals(dayEdge.to))
                                        .map(Map.Entry::getKey)
                                        .findFirst()
                                        .orElse(-1);
                                int period = periodToNode.entrySet().stream()
                                        .filter(e -> e.getValue().equals(edge.to))
                                        .map(Map.Entry::getKey)
                                        .findFirst()
                                        .orElse(-1);
                                if (day != -1 && period != -1) {
                                    doctorDayPeriodAssignment.computeIfAbsent(entry.getKey(), k -> new HashMap<>()).put(day, period);
                                }
                            }
                        }
                    }
                }
            }

            for (Map.Entry<Integer, Map<Integer, Integer>> entry : doctorDayPeriodAssignment.entrySet()) {
                for (Map.Entry<Integer, Integer> dayPeriodEntry : entry.getValue().entrySet()) {
                    System.out.println("Médico " + entry.getKey() + " ao dia " + dayPeriodEntry.getKey() + " (Período " + dayPeriodEntry.getValue() + ")");
                }
            }
        } else {
            System.out.println("Não é possível realizar nenhuma atribuição de médicos");
        }
    }
}
