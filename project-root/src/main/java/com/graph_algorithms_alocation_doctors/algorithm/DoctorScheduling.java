package src.main.java.com.graph_algorithms_alocation_doctors.algorithm;

import src.main.java.com.graph_algorithms_alocation_doctors.algorithm.MaxFlow;

import java.util.*;

public class DoctorScheduling {
    public static String scheduleDoctors(int n, int k, int c, int[][] Dj, int[][] Si) {
        int totalVacationDays = Arrays.stream(Dj).mapToInt(arr -> arr.length).sum();
        int V = n + totalVacationDays + k + 2;
        int source = V - 2;
        int sink = V - 1;

        MaxFlow maxFlow = new MaxFlow(V);

        for (int i = 0; i < n; i++) {
            maxFlow.addEdge(source, i, c);
        }

        int dayIndex = n;

        for (int i = 0; i < n; i++) {
            for (int day : Si[i]) {
                maxFlow.addEdge(i, dayIndex + day, 1);
            }
        }

        for (int j = 0; j < k; j++) {
            int gadget = dayIndex + totalVacationDays + j;
            for (int day : Dj[j]) {
                maxFlow.addEdge(dayIndex + day, gadget, 1);
            }
            maxFlow.addEdge(gadget, sink, 1);
        }

        int requiredFlow = totalVacationDays;
        int result = maxFlow.maxFlow(source, sink);

        if (result == requiredFlow) {
            return "É possível selecionar um médico para cada dia de férias.";
        } else {
            return "Não é possível selecionar um médico para cada dia de férias.";
        }
    }
}