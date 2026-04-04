import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InstructionsPanel extends JPanel{
    //instance variables
    JLabel instructionsLabel;
    
    public InstructionsPanel() {
        this.setBackground(new Color(255, 240, 220));
        this.setBorder(BorderFactory.createTitledBorder("Instructions Panel"));

        instructionsLabel = new JLabel("Pick the right outfit for the event");
        this.add(instructionsLabel);

    }
}
