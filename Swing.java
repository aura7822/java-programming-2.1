//code for simulating relationship between databases and java using mysql
/*
NAME : Aura Joshua
ADM :BSE-05-0180/2024
GROUP : 3
DATE : 24th july 2025
 */

/**
 * databases in java programming :
 *a simple programm that shows how data can be stored in databases in java programming
 * 
 * Author: joshua Aura
 * Date: 24 july 2025
 * Language: Java
 */
package swing;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Swing extends JFrame {

  
    private JTextField nameField, mobileField;
    private JRadioButton maleRadio, femaleRadio;
    private JComboBox<String> dayCombo, monthCombo, yearCombo;
    private JTextArea addressArea;
    private JCheckBox termsCheckbox;
    private JButton submitBtn, resetBtn;

   
    private JTable dataTable;
    private DefaultTableModel tableModel;

    private Connection conn;

    public Swing() {
        
        connectDatabase();
        createTableIfNotExists();

        
        setTitle("Registration Form");
        setSize(900, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setPreferredSize(new Dimension(400, 400));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.anchor = GridBagConstraints.WEST;

        
        

        gbc.gridx = 0; gbc.gridy = 0;
        leftPanel.add(new JLabel("Name:"), gbc);
        nameField = new JTextField(20);
        gbc.gridx = 1;
        leftPanel.add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        leftPanel.add(new JLabel("Mobile:"), gbc);
        mobileField = new JTextField(20);
        gbc.gridx = 1;
        leftPanel.add(mobileField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        leftPanel.add(new JLabel("Gender:"), gbc);
        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);
        gbc.gridx = 1;
        leftPanel.add(genderPanel, gbc);

        gbc.gridx = 0; gbc.gridy++;
        leftPanel.add(new JLabel("DOB:"), gbc);
        dayCombo = new JComboBox<>();
        for (int i=1; i<=31; i++) dayCombo.addItem(String.valueOf(i));
        monthCombo = new JComboBox<>(new String[]{
                "Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
        });
        yearCombo = new JComboBox<>();
        int currentYear = java.time.Year.now().getValue();
        for (int y = currentYear; y >= 1900; y--) yearCombo.addItem(String.valueOf(y));
        JPanel dobPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        dobPanel.add(dayCombo);
        dobPanel.add(monthCombo);
        dobPanel.add(yearCombo);
        gbc.gridx = 1;
        leftPanel.add(dobPanel, gbc);

        gbc.gridx = 0; gbc.gridy++;
        leftPanel.add(new JLabel("Address:"), gbc);
        addressArea = new JTextArea(4, 20);
        addressArea.setLineWrap(true);
        addressArea.setWrapStyleWord(true);
        JScrollPane addrScroll = new JScrollPane(addressArea);
        gbc.gridx = 1;
        leftPanel.add(addrScroll, gbc);

        gbc.gridx = 1; gbc.gridy++;
        termsCheckbox = new JCheckBox("Accept Terms And Conditions");
        leftPanel.add(termsCheckbox, gbc);

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        submitBtn = new JButton("Submit");
        resetBtn = new JButton("Reset");
        btnPanel.add(submitBtn);
        btnPanel.add(resetBtn);
        gbc.gridx = 1; gbc.gridy++;
        leftPanel.add(btnPanel, gbc);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setPreferredSize(new Dimension(480, 400));
        String[] columns = {"ID", "Name", "Gender", "DOB", "Address", "Mobile"};
        tableModel = new DefaultTableModel(columns, 0);
        dataTable = new JTable(tableModel);
        JScrollPane tableScroll = new JScrollPane(dataTable);
        rightPanel.add(tableScroll, BorderLayout.CENTER);

        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);

        loadTableData();

        submitBtn.addActionListener(e -> submitData());
        resetBtn.addActionListener(e -> resetForm());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void connectDatabase() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:registration.db");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Database connection failed: "+e.getMessage());
            System.exit(1);
        }
    }

    private void createTableIfNotExists() {
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "gender TEXT NOT NULL," +
                "dob TEXT NOT NULL," +
                "address TEXT," +
                "mobile TEXT" +
                ")";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Failed to create table: "+e.getMessage());
        }
    }

    private void loadTableData() {
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            tableModel.setRowCount(0);
            while (rs.next()) {
                Object[] row = {
                        
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getString("dob"),
                        rs.getString("address"),
                        rs.getString("mobile")
                };
                tableModel.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Failed to load data: "+e.getMessage());
        }
    }

    private void submitData() {
        if (nameField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name is required.");
            return;
        }
        if (!maleRadio.isSelected() && !femaleRadio.isSelected()) {
            JOptionPane.showMessageDialog(this, "Select a gender.");
            return;
        }
        if (!termsCheckbox.isSelected()) {
            JOptionPane.showMessageDialog(this, "You must accept terms and conditions.");
            return;
        }
        //String id = idField.getText().trim();
        String name = nameField.getText().trim();
        String mobile = mobileField.getText().trim();
        String gender = maleRadio.isSelected() ? "Male" : "Female";
        String dob = dayCombo.getSelectedItem() + "-" + monthCombo.getSelectedItem() + "-" + yearCombo.getSelectedItem();
        String address = addressArea.getText().trim();

        String sql = "INSERT INTO users(id, name, gender, dob, address, mobile) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            //pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, gender);
            pstmt.setString(4, dob);
            pstmt.setString(5, address);
            pstmt.setString(6, mobile);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data inserted successfully.");
            loadTableData();
            resetForm();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Insert failed: "+e.getMessage());
        }
    }

    private void resetForm() {
       
        nameField.setText("");
        mobileField.setText("");
        maleRadio.setSelected(false);
        femaleRadio.setSelected(false);
        dayCombo.setSelectedIndex(0);
        monthCombo.setSelectedIndex(0);
        yearCombo.setSelectedIndex(0);
        addressArea.setText("");
        termsCheckbox.setSelected(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Swing());
    }
}
