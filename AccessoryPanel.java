import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * AccessoryPanel
 * 
 * Panel that allows the user to select an accessory for the cat.
 * 
 * Contains:
 * - three JRadioButtons (Bow, Scarf, Cape)
 * - a ButtonGroup to ensure only one can be selected at a time
 * 
 * This class only manages selection state, no game logic.
 */

public class AccessoryPanel extends JPanel{

    // instance variables

    private JRadioButton bowButton;    // bow option
    private JRadioButton scarfButton;  // scarf option
    private JRadioButton capeButton;   // cape option

    private ButtonGroup accessoryGroup; // ensures only one button is selected
    
    /**
     * Constructor
     * 
     * Sets up:
     * - panel styling
     * - radio buttons
     * - grouping behavior
     * - layout
     */
    public AccessoryPanel() {

        // panel styling
        this.setBackground(new Color(202, 209, 180));
        this.setBorder(BorderFactory.createTitledBorder("Choose the right accessory"));

        // create radio buttons
        bowButton = new JRadioButton("Bow");
        scarfButton = new JRadioButton("Scarf");
        capeButton = new JRadioButton("Cape");

        // group buttons (only one can be selected at a time)
        accessoryGroup = new ButtonGroup();
        accessoryGroup.add(bowButton);
        accessoryGroup.add(scarfButton);
        accessoryGroup.add(capeButton);

        // add buttons to panel
        this.add(bowButton);
        this.add(scarfButton);
        this.add(capeButton);

        // stack buttons vertically
        this.setLayout(new GridLayout(3,1));
    }
    
    /**
     * Returns the currently selected accessory as a String.
     * Returns null if nothing is selected.
     */
    public String getSelectedAccessory() {

        if (bowButton.isSelected()) return "Bow";
        else if (scarfButton.isSelected()) return "Scarf";
        else if (capeButton.isSelected()) return "Cape";

        return null;
    }

    /**
     * Getters for buttons
     * Used in GameFrame to attach ActionListeners
     */
    public JRadioButton getBowButton() {
        return bowButton;
    }

    public JRadioButton getScarfButton() {
        return scarfButton;
    }

    public JRadioButton getCapeButton() {
        return capeButton;
    }

    /**
     * Clears all selections
     * Used when resetting the game state
     */
    public void clearSelection() {
        accessoryGroup.clearSelection();
    }
}