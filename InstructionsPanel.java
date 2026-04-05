import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * InstructionsPanel
 * 
 * Displays a short description of how to play the game.
 * 
 * Contains:
 * - a JLabel with styled (HTML) text
 * 
 * This panel is purely informational and does not handle any logic.
 */
public class InstructionsPanel extends JPanel{

    // instance variables
    JLabel instructionsLabel; // label that displays instructions text
    
    /**
     * Constructor
     * 
     * Sets up:
     * - panel styling
     * - instructions text
     */
    public InstructionsPanel() {

        // background color of panel
        this.setBackground(new Color(202, 209, 180));

        // titled border to indicate purpose of panel
        this.setBorder(BorderFactory.createTitledBorder("How to play"));

        // create label
        instructionsLabel = new JLabel();

        // set fixed size so text wraps properly
        instructionsLabel.setPreferredSize(new Dimension(240, 60));

        // use HTML to allow text wrapping and centering
        instructionsLabel.setText(
            "<html><div style='text-align: center;'>"
            + "Pick the perfect outfit for each event and hit <b>Check Outfit</b> to see how stylish your cat scored!"
            + "</div></html>"
        );

        // add label to panel
        this.add(instructionsLabel);
    }
}
