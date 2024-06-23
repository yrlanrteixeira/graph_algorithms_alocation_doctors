package src.main.java.com.graph_algorithms_alocation_doctors;

import src.main.java.com.graph_algorithms_alocation_doctors.gui.DoctorSchedulingGUI;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DoctorSchedulingGUI());
    }
}
