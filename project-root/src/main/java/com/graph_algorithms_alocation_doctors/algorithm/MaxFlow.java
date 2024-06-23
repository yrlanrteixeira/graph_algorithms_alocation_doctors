package src.main.java.com.graph_algorithms_alocation_doctors.algorithm;

import java.util.*;

public class MaxFlow {
    static final int INF = Integer.MAX_VALUE;
    int n, s, t;
    int[][] capacity;
    List<Integer>[] adj;

    public MaxFlow(int n) {
        this.n = n;
        this.capacity = new int[n][n];
        this.adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v, int cap) {
        adj[u].add(v);
        adj[v].add(u);
        capacity[u][v] = cap;
    }

    private int bfs(int[] parent) {
        Arrays.fill(parent, -1);
        parent[s] = -2;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{s, INF});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int u = curr[0];
            int flow = curr[1];

            for (int v : adj[u]) {
                if (parent[v] == -1 && capacity[u][v] > 0) {
                    parent[v] = u;
                    int new_flow = Math.min(flow, capacity[u][v]);
                    if (v == t) {
                        return new_flow;
                    }
                    q.add(new int[]{v, new_flow});
                }
            }
        }

        return 0;
    }

    public int maxFlow(int s, int t) {
        this.s = s;
        this.t = t;
        int flow = 0;
        int[] parent = new int[n];
        int new_flow;

        while ((new_flow = bfs(parent)) != 0) {
            flow += new_flow;
            int curr = t;

            while (curr != s) {
                int prev = parent[curr];
                capacity[prev][curr] -= new_flow;
                capacity[curr][prev] += new_flow;
                curr = prev;
            }
        }

        return flow;
    }
}
