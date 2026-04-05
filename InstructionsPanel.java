import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InstructionsPanel extends JPanel{
    //instance variables
    JLabel instructionsLabel;
    
    public InstructionsPanel() {
        this.setBackground(new Color(202, 209, 180));
        this.setBorder(BorderFactory.createTitledBorder("How to play"));

        instructionsLabel = new JLabel();
        instructionsLabel.setPreferredSize(new Dimension(240, 60));
        instructionsLabel.setText("<html><div style='text-align: center;'>" + "Pick the perfect outfit for each event and hit <b>Check Outfit</b> to see how stylish your cat scored!" + "</div></html>");
        this.add(instructionsLabel);

    }
}
