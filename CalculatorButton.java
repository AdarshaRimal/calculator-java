import javax.swing.*;
import java.awt.*;

public class CalculatorButton extends JButton {
    public CalculatorButton(String label) {
        super(label);
        setPreferredSize(new Dimension(60, 60));
        setFont(new Font("Arial", Font.PLAIN, 20));
    }
}
