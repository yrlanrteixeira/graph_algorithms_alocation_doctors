package main.java.com.doctorswithoutweekends;

import main.java.com.doctorswithoutweekends.algorithm.EdmondsKarp;

import java.util.*;

/**
 * Classe main.java.com.doctorswithoutweekends.Main que executa o programa.
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

        int numDoctors = getPositiveInt(scanner, "-> Digite o número de médicos (Ex: 3): ");

        Map<Integer, Set<Integer>> doctors = new HashMap<>();
        for (int i = 1; i <= numDoctors; i++) {
            int numDays = getPositiveInt(scanner, "-> Digite o número de dias disponíveis para o médico " + i + " (Ex: 3): ");

            Set<Integer> days = new HashSet<>();
            boolean validInput = false;
            while (!validInput) {
                System.out.print("-> Digite os dias disponíveis para o médico " + i + " (Ex: 1 2 3): ");
                String[] dayStrings = scanner.nextLine().split(" ");
                if (dayStrings.length == numDays) {
                    try {
                        for (String dayString : dayStrings) {
                            days.add(Integer.parseInt(dayString));
                        }
                        if (days.size() == numDays) {
                            validInput = true;
                        } else {
                            System.out.println("Os dias fornecidos são duplicados. Por favor, insira dias únicos.");
                            days.clear();
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida. Por favor, insira números inteiros.");
                        days.clear();
                    }
                } else {
                    System.out.println("Número de dias fornecidos não corresponde ao número esperado. Por favor, insira exatamente " + numDays + " dias.");
                }
            }
            doctors.put(i, days);
        }

        int numPeriods = getPositiveInt(scanner, "-> Digite o número de periodos de férias (Ex: 2): ");

        Map<Integer, Set<Integer>> vacationPeriods = new HashMap<>();
        for (int i = 1; i <= numPeriods; i++) {
            int numDays = getPositiveInt(scanner, "-> Digite o número de dias de férias do periodo " + i + " (Ex: 2): ");

            Set<Integer> days = new HashSet<>();
            boolean validInput = false;
            while (!validInput) {
                System.out.print("-> Digite os dias do periodo de férias " + i + " (Ex: 1 2): ");
                String[] dayStrings = scanner.nextLine().split(" ");
                if (dayStrings.length == numDays) {
                    try {
                        for (String dayString : dayStrings) {
                            days.add(Integer.parseInt(dayString));
                        }
                        if (days.size() == numDays) {
                            validInput = true;
                        } else {
                            System.out.println("Os dias fornecidos são duplicados. Por favor, insira dias únicos.");
                            days.clear();
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida. Por favor, insira números inteiros.");
                        days.clear();
                    }
                } else {
                    System.out.println("Número de dias fornecidos não corresponde ao número esperado. Por favor, insira exatamente " + numDays + " dias.");
                }
            }
            vacationPeriods.put(i, days);
        }

        int c = getPositiveInt(scanner, "-> Digite o número máximo de dias de férias que um médico pode trabalhar (Ex: 2): ");

        EdmondsKarp.assignDoctors(doctors, vacationPeriods, c);

        scanner.close();
    }

    /**
     * Método para obter um número inteiro positivo do usuário.
     * @param scanner o objeto Scanner para ler a entrada do usuário
     * @param message a mensagem para exibir ao usuário
     * @return um número inteiro positivo
     */
    private static int getPositiveInt(Scanner scanner, String message) {
        return getPositiveInt(scanner, message, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Método para obter um número inteiro positivo do usuário dentro de um intervalo.
     * @param scanner o objeto Scanner para ler a entrada do usuário
     * @param message a mensagem para exibir ao usuário
     * @param min o valor mínimo permitido (inclusivo)
     * @param max o valor máximo permitido (inclusivo)
     * @return um número inteiro positivo dentro do intervalo especificado
     */
    private static int getPositiveInt(Scanner scanner, String message, int min, int max) {
        int number;
        while (true) {
            System.out.print(message);
            try {
                number = scanner.nextInt();
                scanner.nextLine(); // Clear the buffer
                if (number > 0 && number >= min && number <= max) {
                    break;
                } else {
                    System.out.println("Por favor, insira um número positivo dentro do intervalo permitido (" + min + "-" + max + ").");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.next(); // Limpar a entrada inválida
            }
        }
        return number;
    }
}
