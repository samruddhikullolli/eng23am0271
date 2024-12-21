import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculatorGUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame("BMI Calculator");
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);

        JLabel title = new JLabel("BMI Calculator", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(100, 20, 200, 30);
        panel.add(title);

        JLabel weightLabel = new JLabel("Enter Weight (kg):");
        weightLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        weightLabel.setBounds(50, 80, 150, 30);
        panel.add(weightLabel);

        JTextField weightInput = new JTextField();
        weightInput.setBounds(200, 80, 150, 30);
        panel.add(weightInput);

        JLabel heightLabel = new JLabel("Enter Height (m):");
        heightLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        heightLabel.setBounds(50, 130, 150, 30);
        panel.add(heightLabel);

        JTextField heightInput = new JTextField();
        heightInput.setBounds(200, 130, 150, 30);
        panel.add(heightInput);

        JButton calculateButton = new JButton("Calculate BMI");
        calculateButton.setBounds(120, 190, 150, 30);
        panel.add(calculateButton);

        JLabel resultLabel = new JLabel("Your BMI will be displayed here", JLabel.CENTER);
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        resultLabel.setBounds(50, 250, 300, 30);
        resultLabel.setForeground(Color.BLUE);
        panel.add(resultLabel);

        JLabel categoryLabel = new JLabel("Category:", JLabel.CENTER);
        categoryLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        categoryLabel.setBounds(50, 290, 300, 30);
        categoryLabel.setForeground(Color.DARK_GRAY);
        panel.add(categoryLabel);

        JButton resetButton = new JButton("Reset");
        resetButton.setBounds(120, 330, 150, 30);
        panel.add(resetButton);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String weightText = weightInput.getText();
                    String heightText = heightInput.getText();
                    double weight = Double.parseDouble(weightText);
                    double height = Double.parseDouble(heightText);

                    double bmi = weight / (height * height);
                    String category;

                    if (bmi < 18.5) {
                        category = "Underweight";
                    } else if (bmi >= 18.5 && bmi < 25) {
                        category = "Normal weight";
                    } else if (bmi >= 25 && bmi < 30) {
                        category = "Overweight";
                    } else {
                        category = "Obese";
                    }

                    resultLabel.setText(String.format("Your BMI is: %.2f", bmi));
                    categoryLabel.setText("Category: " + category);

                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input. Please enter numbers.");
                    categoryLabel.setText("");
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weightInput.setText("");
                heightInput.setText("");
                resultLabel.setText("Your BMI will be displayed here");
                categoryLabel.setText("Category:");
            }
        });

        JLabel noteLabel = new JLabel("Note: BMI is a general indicator.", JLabel.CENTER);
        noteLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        noteLabel.setBounds(50, 400, 300, 30);
        noteLabel.setForeground(Color.RED);
        panel.add(noteLabel);

        JLabel additionalInfoLabel = new JLabel("Consult a doctor for detailed analysis.", JLabel.CENTER);
        additionalInfoLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        additionalInfoLabel.setBounds(50, 430, 300, 30);
        additionalInfoLabel.setForeground(Color.RED);
        panel.add(additionalInfoLabel);

        JTextArea logArea = new JTextArea();
        logArea.setBounds(50, 470, 300, 80);
        logArea.setFont(new Font("Arial", Font.PLAIN, 12));
        logArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        logArea.setEditable(false);
        panel.add(logArea);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double weight = Double.parseDouble(weightInput.getText());
                    double height = Double.parseDouble(heightInput.getText());
                    double bmi = weight / (height * height);
                    String category;

                    if (bmi < 18.5) {
                        category = "Underweight";
                    } else if (bmi >= 18.5 && bmi < 25) {
                        category = "Normal weight";
                    } else if (bmi >= 25 && bmi < 30) {
                        category = "Overweight";
                    } else {
                        category = "Obese";
                    }

                    resultLabel.setText(String.format("Your BMI is: %.2f", bmi));
                    categoryLabel.setText("Category: " + category);

                    logArea.append("BMI Calculated: " + bmi + "\n");
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input. Please enter numbers.");
                    categoryLabel.setText("");
                    logArea.append("Invalid input encountered.\n");
                }
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}


