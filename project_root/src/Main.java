package src;

import src.main.com.graph_algorithms_alocation_doctors.algorithm.gui.DoctorSchedulingGUI;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DoctorSchedulingGUI());
    }
}
