package APPS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Employee {
    String name;
    int id;
    double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + id + "\nName: " + name + "\nSalary: INR" + salary + "\n";
    }
}

public class EmployeeManagementSystem extends JFrame {

    private ArrayList<Employee> employees = new ArrayList<>();

    private JTextArea outputTextArea;

    public EmployeeManagementSystem() {
        setTitle("Employee Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Employee Management System");
        titleLabel.setBounds(80, 10, 250, 25);
        panel.add(titleLabel);

        JButton addButton = new JButton("Add Employee");
        addButton.setBounds(20, 40, 150, 25);
        panel.add(addButton);

        JButton viewButton = new JButton("View Employees");
        viewButton.setBounds(200, 40, 150, 25);
        panel.add(viewButton);

        outputTextArea = new JTextArea();
        outputTextArea.setBounds(20, 80, 330, 150);
        outputTextArea.setEditable(false);
        panel.add(outputTextArea);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEmployee();
            }
        });

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewEmployees();
            }
        });
    }

    private void addEmployee() {
        String name = JOptionPane.showInputDialog("Enter employee name:");
        String idStr = JOptionPane.showInputDialog("Enter employee ID:");
        String salaryStr = JOptionPane.showInputDialog("Enter employee salary:");

        try {
            int id = Integer.parseInt(idStr);
            double salary = Double.parseDouble(salaryStr);

            Employee employee = new Employee(name, id, salary);
            employees.add(employee);

            JOptionPane.showMessageDialog(this, "Employee added successfully!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numeric values.");
        }
    }

    private void viewEmployees() {
        if (employees.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No employees to display.");
        } else {
            StringBuilder output = new StringBuilder("Employee List:\n");
            for (Employee employee : employees) {
                output.append(employee.toString()).append("\n");
            }
            outputTextArea.setText(output.toString());
        }
    }

    public static void main(String[] args) {
        new EmployeeManagementSystem();
    }
}