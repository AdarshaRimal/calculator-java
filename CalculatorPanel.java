import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorPanel extends JPanel {
    private JTextField display;
    private double num1 = 0;
    private String operator = "";

    public CalculatorPanel() {
        setLayout(new BorderLayout());

        // Create and add the display panel
        display = new JTextField();
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setPreferredSize(new Dimension(400, 60));
        add(display, BorderLayout.NORTH);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));

        // Button labels
        String[] buttonLabels = {
                "7", "8", "9", "+",
                "4", "5", "6", "-",
                "1", "2", "3", "*",
                "0", "C", "=", "/"
        };

        // Create buttons and add them to the panel
        for (String label : buttonLabels) {
            CalculatorButton button = new CalculatorButton(label);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            CalculatorButton button = (CalculatorButton) e.getSource();
            String buttonText = button.getText();

            switch (buttonText) {
                case "C":
                    display.setText("");
                    num1 = 0;
                    operator = "";
                    break;
                case "=":
                    double num2 = Double.parseDouble(display.getText());
                    double result = 0;
                    switch (operator) {
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "*":
                            result = num1 * num2;
                            break;
                        case "/":
                            if (num2 != 0) {
                                result = num1 / num2;
                            } else {
                                display.setText("Error");
                                return;
                            }
                            break;
                    }
                    display.setText(String.valueOf(result));
                    operator = "";
                    num1 = result;
                    break;
                default:
                    if (buttonText.equals("+") || buttonText.equals("-") || buttonText.equals("*") || buttonText.equals("/")) {
                        operator = buttonText;
                        num1 = Double.parseDouble(display.getText());
                        display.setText("");
                    } else {
                        display.setText(display.getText() + buttonText);
                    }
                    break;
            }
        }
    }
}
