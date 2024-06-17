package main.java.com.graph_algorithms_alocation_doctors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class DoctorSchedulingGUI {
    private JFrame frame;
    private JTextField numDoctorsField;
    private JTextField numPeriodsField;
    private JTextField maxDaysField;
    private List<JTextField> periodDaysFields;
    private List<JTextField> doctorAvailabilityFields;
    private JTextArea outputArea;
    private JPanel periodsPanel;
    private JPanel doctorsPanel;
    private JTabbedPane tabbedPane;

    public DoctorSchedulingGUI() {
        frame = new JFrame("Doctor Scheduling");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        tabbedPane = new JTabbedPane();

        // Painel de entrada de dados principais
        JPanel mainInputPanel = new JPanel();
        mainInputPanel.setLayout(new GridLayout(4, 2));

        mainInputPanel.add(new JLabel("Número de Médicos:"));
        numDoctorsField = new JTextField();
        mainInputPanel.add(numDoctorsField);

        mainInputPanel.add(new JLabel("Número de Períodos de Férias:"));
        numPeriodsField = new JTextField();
        mainInputPanel.add(numPeriodsField);

        mainInputPanel.add(new JLabel("Máximo de Dias de Férias por Médico:"));
        maxDaysField = new JTextField();
        mainInputPanel.add(maxDaysField);

        JButton addPeriodButton = new JButton("Adicionar Períodos de Férias");
        addPeriodButton.addActionListener(e -> addPeriodsFields());
        mainInputPanel.add(addPeriodButton);

        JButton addDoctorButton = new JButton("Adicionar Disponibilidade dos Médicos");
        addDoctorButton.addActionListener(e -> addDoctorsFields());
        mainInputPanel.add(addDoctorButton);

        tabbedPane.addTab("Entrada Principal", mainInputPanel);

        // Painel de períodos de férias
        periodsPanel = new JPanel();
        periodsPanel.setLayout(new GridLayout(0, 1));
        tabbedPane.addTab("Períodos de Férias", new JScrollPane(periodsPanel));

        // Painel de disponibilidade dos médicos
        doctorsPanel = new JPanel();
        doctorsPanel.setLayout(new GridLayout(0, 1));
        tabbedPane.addTab("Disponibilidade dos Médicos", new JScrollPane(doctorsPanel));

        frame.add(tabbedPane, BorderLayout.CENTER);

        outputArea = new JTextArea();
        outputArea.setBorder(BorderFactory.createTitledBorder("Output"));
        outputArea.setEditable(false);
        frame.add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        JButton processButton = new JButton("Processar");
        processButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processInput();
            }
        });
        frame.add(processButton, BorderLayout.EAST);

        frame.setVisible(true);
    }

    private void addPeriodsFields() {
        int numPeriods = Integer.parseInt(numPeriodsField.getText());
        periodDaysFields = new ArrayList<>();
        periodsPanel.removeAll();

        for (int i = 0; i < numPeriods; i++) {
            JTextField periodField = new JTextField();
            periodsPanel.add(new JLabel("Dias do Período de Férias " + (i + 1) + ": (Ex: 1 2 3)"));
            periodsPanel.add(periodField);
            periodDaysFields.add(periodField);
        }

        periodsPanel.revalidate();
        periodsPanel.repaint();
    }

    private void addDoctorsFields() {
        int numDoctors = Integer.parseInt(numDoctorsField.getText());
        doctorAvailabilityFields = new ArrayList<>();
        doctorsPanel.removeAll();

        for (int i = 0; i < numDoctors; i++) {
            JTextField doctorField = new JTextField();
            doctorsPanel.add(new JLabel("Dias Disponíveis do Médico " + (i + 1) + ": (Ex: 1 2 4)"));
            doctorsPanel.add(doctorField);
            doctorAvailabilityFields.add(doctorField);
        }

        doctorsPanel.revalidate();
        doctorsPanel.repaint();
    }

    private void processInput() {
        try {
            int n = Integer.parseInt(numDoctorsField.getText());
            int k = Integer.parseInt(numPeriodsField.getText());
            int c = Integer.parseInt(maxDaysField.getText());

            int[][] Dj = new int[k][];
            for (int j = 0; j < k; j++) {
                String[] daysStr = periodDaysFields.get(j).getText().split(" ");
                Dj[j] = new int[daysStr.length];
                for (int d = 0; d < daysStr.length; d++) {
                    Dj[j][d] = Integer.parseInt(daysStr[d]);
                }
            }

            int[][] Si = new int[n][];
            for (int i = 0; i < n; i++) {
                String[] daysStr = doctorAvailabilityFields.get(i).getText().split(" ");
                Si[i] = new int[daysStr.length];
                for (int d = 0; d < daysStr.length; d++) {
                    Si[i][d] = Integer.parseInt(daysStr[d]);
                }
            }

            String result = DoctorScheduling.scheduleDoctors(n, k, c, Dj, Si);
            outputArea.setText(result);

        } catch (Exception e) {
            outputArea.setText("Erro ao processar a entrada: " + e.getMessage());
        }
    }
}
