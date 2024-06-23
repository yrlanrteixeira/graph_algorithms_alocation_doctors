import java.util.*;

/**
 * Classe Main que executa o programa.
 */
public class Main {
    /**
     * Método principal que inicia a execução do programa.
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {
        System.out.println("##-------------------------- ATIVIDADE #3 --------------------------##");
        System.out.println("|                                                                    |");
        System.out.println("|   Essa atividade é uma implementação de um método de fluxo máximo  |");
        System.out.println("|   para resolver o problema de atribuição de dias de férias de um   |");
        System.out.println("|   hospital, garantindo que cada dia de férias seja coberto por     |");
        System.out.println("|   um médico e respeitando a disponibilidade dos médicos.           |");
        System.out.println("|                                                                    |");
        System.out.println("##------------------------------------------------------------------##\n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("-> Digite o número de médicos (Ex: 3): ");
        int numDoctors = scanner.nextInt();

        Map<Integer, Set<Integer>> doctors = new HashMap<>();
        for(int i = 1; i <= numDoctors; i++) {
            System.out.print("-> Digite o número de dias disponíveis para o médico " + i + " (Ex: 3): ");
            int numDays = scanner.nextInt();

            Set<Integer> days = new HashSet<>();
            System.out.print("-> Digite os dias disponíveis para o médico " + i + " (Ex: 1 2 3): ");
            for(int j = 0; j < numDays; j++) {
                days.add(scanner.nextInt());
            }
            doctors.put(i, days);
        }

        System.out.print("-> Digite o número de periodo de férias (Ex: 2): ");
        int numPeriods = scanner.nextInt();

        Map<Integer, Set<Integer>> vacationPeriods = new HashMap<>();
        for (int i = 1; i <= numPeriods; i++) {
            System.out.print("-> Digite o número de dias de férias do periodo " + i  + " (Ex: 2): ");
            int numDays = scanner.nextInt();
            Set<Integer> days = new HashSet<>();
            System.out.print("-> Digite os dias do periodo de férias " + i + " (Ex: 1 2): ");
            for (int j = 0; j < numDays; j++) {
                days.add(scanner.nextInt());
            }
            vacationPeriods.put(i, days);
        }

        System.out.print("-> Digite o número máximo de dias de férias que um médico pode trabalhar (Ex: 2): ");
        int c = scanner.nextInt();

        EdmondsKarp.assignDoctors(doctors, vacationPeriods, c);

        scanner.close();
    }
}