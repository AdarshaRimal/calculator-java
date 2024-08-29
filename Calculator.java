import javax.swing.*;

public class Calculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setSize(400, 400);
        frame.setLocation(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the calculator panel and add it to the frame
        CalculatorPanel panel = new CalculatorPanel();
        frame.add(panel);

        frame.setVisible(true);
    }
}
