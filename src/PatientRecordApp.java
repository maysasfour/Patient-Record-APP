import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;

public class PatientRecordApp {
    private JFrame frame;
    private List<Appointment> appointments = new ArrayList<>();
    private List<Patient> patients = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();
    private JLabel patientsLabel;
    private JLabel doctorsLabel;
    private JLabel appointmentsLabel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PatientRecordApp().createAndShowGUI());
    }

    private void createAndShowGUI() {
        frame = new JFrame("Patient Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null);

        frame.setUndecorated(true);
        frame.setOpacity(0.98f);
        frame.getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245, 245, 245));

        JPanel headerPanel = new JPanel();
        JLabel titleLabel = new JLabel("Patient Management System");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        titleLabel.setForeground(new Color(40, 40, 40));
        headerPanel.setBackground(new Color(245, 245, 245));
        headerPanel.add(titleLabel);
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS));
        sidebarPanel.setBackground(new Color(45, 45, 45));
        sidebarPanel.setPreferredSize(new Dimension(250, 0));

        addSidebarButton(sidebarPanel, "Manage Patients", this::showAddPatientDialog);
        addSidebarButton(sidebarPanel, "Manage Doctors", this::showAddDoctorDialog);
        addSidebarButton(sidebarPanel, "Appointments", this::showViewAppointmentsDialog);
        addSidebarButton(sidebarPanel, "Add Visit", this::showAddVisitDialog);

        JScrollPane sidebarScroll = new JScrollPane(sidebarPanel);
        sidebarScroll.setBorder(BorderFactory.createEmptyBorder());
        mainPanel.add(sidebarScroll, BorderLayout.WEST);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(new Color(245, 245, 245));

        JPanel welcomePanel = createCardPanel();
        JLabel welcomeLabel = new JLabel("Welcome to the Patient Management System!");
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        welcomeLabel.setForeground(new Color(40, 40, 40));
        welcomePanel.add(welcomeLabel);

        // Statistics Panel with Card Style
        JPanel statsPanel = createCardPanel();
        statsPanel.setLayout(new GridLayout(1, 3, 20, 0));

        patientsLabel = new JLabel("Patients: " + patients.size());
        patientsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        statsPanel.add(patientsLabel);

        doctorsLabel = new JLabel("Doctors: " + doctors.size());
        doctorsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        statsPanel.add(doctorsLabel);

        appointmentsLabel = new JLabel("Appointments: " + appointments.size());
        appointmentsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        statsPanel.add(appointmentsLabel);

        contentPanel.add(welcomePanel);
        contentPanel.add(statsPanel);

        mainPanel.add(contentPanel, BorderLayout.CENTER);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private void refreshStatistics() {
        patientsLabel.setText("Patients: " + patients.size());
        doctorsLabel.setText("Doctors: " + doctors.size());
        appointmentsLabel.setText("Appointments: " + appointments.size());
    }

    private JPanel createCardPanel() {
        JPanel cardPanel = new JPanel();
        cardPanel.setBackground(Color.WHITE);
        cardPanel.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1, true));
        cardPanel.setLayout(new BoxLayout(cardPanel, BoxLayout.Y_AXIS));
        cardPanel.setMaximumSize(new Dimension(900, 200));
        cardPanel.setPreferredSize(new Dimension(900, 200));
        cardPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        cardPanel.setBorder(BorderFactory.createCompoundBorder(
                cardPanel.getBorder(),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        return cardPanel;
    }

    private void addSidebarButton(JPanel sidebar, String label, Runnable action) {
        JButton button = new JButton(label);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        button.setBackground(new Color(70, 130, 180));
        button.setForeground(Color.WHITE);
        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        button.setPreferredSize(new Dimension(220, 60));
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createLineBorder(new Color(100, 150, 210), 2));
        button.addActionListener(e -> action.run());

        button.setBorder(BorderFactory.createCompoundBorder(
                button.getBorder(),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        sidebar.add(button);
    }
    private void showAddPatientDialog() {
        JDialog dialog = new JDialog(frame, "Add Patient", true);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(frame);
        dialog.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(5, 2, 15, 15));
        panel.setBackground(new Color(245, 245, 245));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Address:"));
        JTextField addressField = new JTextField();
        panel.add(addressField);

        panel.add(new JLabel("Phone:"));
        JTextField phoneField = new JTextField();
        panel.add(phoneField);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            if (!nameField.getText().isEmpty() && !addressField.getText().isEmpty() && !phoneField.getText().isEmpty()) {
                patients.add(new Patient(nameField.getText(), addressField.getText(), "P" + (patients.size() + 1), phoneField.getText()));
                refreshStatistics();
                JOptionPane.showMessageDialog(dialog, "Patient added successfully!");
                dialog.dispose();
            } else {
                JOptionPane.showMessageDialog(dialog, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(new JLabel());
        panel.add(saveButton);
        dialog.add(panel);
        dialog.setVisible(true);
    }

    private void showAddDoctorDialog() {
        JDialog dialog = new JDialog(frame, "Add Doctor", true);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(frame);
        dialog.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(4, 2, 15, 15));
        panel.setBackground(new Color(245, 245, 245));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Specialty:"));
        JTextField specialtyField = new JTextField();
        panel.add(specialtyField);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            if (!nameField.getText().isEmpty() && !specialtyField.getText().isEmpty()) {
                doctors.add(new Doctor("D" + (doctors.size() + 1), nameField.getText(), specialtyField.getText()));
                refreshStatistics();
                JOptionPane.showMessageDialog(dialog, "Doctor added successfully!");
                dialog.dispose();
            } else {
                JOptionPane.showMessageDialog(dialog, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(new JLabel());
        panel.add(saveButton);
        dialog.add(panel);
        dialog.setVisible(true);
    }
    private void showAddVisitDialog() {
        JDialog dialog = new JDialog(frame, "Add Visit", true);
        dialog.setSize(350, 500);
        dialog.setLocationRelativeTo(frame);
        dialog.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 10, 10));  // Added extra row for the status
        panel.setBackground(new Color(245, 245, 245));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Select Patient:"));
        JComboBox<String> patientDropdown = new JComboBox<>();
        for (Patient patient : patients) {
            patientDropdown.addItem(patient.getID() + " - " + patient.getName());
        }
        panel.add(patientDropdown);


        panel.add(new JLabel("Select Doctor:"));
        JComboBox<String> doctorDropdown = new JComboBox<>();
        for (Doctor doctor : doctors) {
            doctorDropdown.addItem(doctor.getID() + " - " + doctor.getName());
        }
        panel.add(doctorDropdown);

        panel.add(new JLabel("Date (yyyy-MM-dd):"));
        JTextField dateField = new JTextField();
        dateField.setToolTipText("Enter appointment date in format yyyy-MM-dd");
        panel.add(dateField);

        panel.add(new JLabel("Time (HH:mm):"));
        JTextField timeField = new JTextField();
        timeField.setToolTipText("Enter time in format HH:mm");
        panel.add(timeField);

        panel.add(new JLabel("Select Status:"));
        JComboBox<String> statusDropdown = new JComboBox<>();
        statusDropdown.addItem(AppointmentStatus.SCHEDULED.name());
        statusDropdown.addItem(AppointmentStatus.COMPLETED.name());
        statusDropdown.addItem(AppointmentStatus.CANCELED.name());
        panel.add(statusDropdown);

        JButton saveButton = new JButton("Save");
        saveButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        saveButton.setForeground(Color.BLACK);
        saveButton.setFocusPainted(false);
        saveButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        saveButton.addActionListener(e -> {
            try {
                if (patientDropdown.getSelectedIndex() >= 0 && doctorDropdown.getSelectedIndex() >= 0
                        && !dateField.getText().isEmpty() && !timeField.getText().isEmpty()) {

                    Patient patient = patients.get(patientDropdown.getSelectedIndex());
                    Doctor doctor = doctors.get(doctorDropdown.getSelectedIndex());

                    LocalDate date = LocalDate.parse(dateField.getText());
                    LocalTime time = LocalTime.parse(timeField.getText());

                    AppointmentStatus status = AppointmentStatus.valueOf(statusDropdown.getSelectedItem().toString());

                    Appointment newAppointment = new Appointment(date, time, doctor, patient, status);
                    appointments.add(newAppointment);
                    refreshStatistics();

                    JOptionPane.showMessageDialog(dialog, "Visit added successfully!");
                    dialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(dialog, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, "Invalid date or time format!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(new JLabel());
        panel.add(saveButton);

        dialog.add(panel);
        dialog.setVisible(true);
    }
    private void showViewAppointmentsDialog() {
        JDialog dialog = new JDialog(frame, "View Appointments", true);
        dialog.setSize(600, 400);
        dialog.setLocationRelativeTo(frame);
        dialog.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(245, 245, 245));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        String[] columnNames = {"Date", "Time", "Doctor", "Patient", "Status"};
        Object[][] data = new Object[appointments.size()][5];

        for (int i = 0; i < appointments.size(); i++) {
            Appointment appointment = appointments.get(i);

            if (appointment.getStatus() == AppointmentStatus.CANCELED) {

                JOptionPane.showMessageDialog(dialog, "This appointment has been canceled.");
                continue;
            } else if (appointment.getStatus() == AppointmentStatus.COMPLETED) {

                JOptionPane.showMessageDialog(dialog, "This appointment is completed.");

            }

            data[i][0] = appointment.getDate();
            data[i][1] = appointment.getTime();
            data[i][2] = appointment.getDoctor().getName();
            data[i][3] = appointment.getPatient().getName();
            data[i][4] = appointment.getStatus();
        }

        JTable table = new JTable(data, columnNames);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setRowHeight(30);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane, BorderLayout.CENTER);

        JButton closeButton = new JButton("Close");
        closeButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        closeButton.addActionListener(e -> dialog.dispose());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(245, 245, 245));
        buttonPanel.add(closeButton);

        dialog.add(panel, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }
    private void showEditAppointmentDialog(Appointment appointment) {
        JDialog dialog = new JDialog(frame, "Edit Appointment", true);
        dialog.setSize(350, 400);
        dialog.setLocationRelativeTo(frame);
        dialog.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 10, 10));

        panel.add(new JLabel("Select Status:"));
        JComboBox<String> statusDropdown = new JComboBox<>();
        statusDropdown.addItem(AppointmentStatus.SCHEDULED.name());
        statusDropdown.addItem(AppointmentStatus.COMPLETED.name());
        statusDropdown.addItem(AppointmentStatus.CANCELED.name());
        panel.add(statusDropdown);

        statusDropdown.setSelectedItem(appointment.getStatus().name());

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            AppointmentStatus selectedStatus = AppointmentStatus.valueOf((String) statusDropdown.getSelectedItem());
            appointment.setStatus(selectedStatus);

            if (selectedStatus == AppointmentStatus.CANCELED) {
                JOptionPane.showMessageDialog(dialog, "This appointment has been canceled.");
            } else if (selectedStatus == AppointmentStatus.COMPLETED) {
                JOptionPane.showMessageDialog(dialog, "This appointment is completed.");
            }

            dialog.dispose();
        });

        panel.add(new JLabel());
        panel.add(saveButton);

        dialog.add(panel);
        dialog.setVisible(true);
    }
    private void cancelAppointment(Appointment appointment) {
        appointment.setStatus(AppointmentStatus.CANCELED);
        JOptionPane.showMessageDialog(frame, "The appointment has been canceled.");
    }
    public void changeStatus(Appointment appointment, AppointmentStatus newStatus) {
        if (appointment.getStatus() == AppointmentStatus.COMPLETED && newStatus != AppointmentStatus.CANCELED) {
            throw new IllegalStateException("Cannot change status from COMPLETED.");
        }
        appointment.setStatus(newStatus);
    }
}
