import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * BackgroundPanel
 * 
 * Panel that allows the user to select a background for the event.
 * 
 * Contains:
 * - three JRadioButtons (Birthday, Winter, Halloween)
 * - a ButtonGroup to ensure only one can be selected at a time
 * 
 * This class only handles UI state (selection), no game logic.
 */

public class BackgroundPanel extends JPanel {

    // instance variables

    private JRadioButton birthdayBgButton;   // birthday background option
    private JRadioButton winterBgButton;     // winter background option
    private JRadioButton halloweenBgButton;  // halloween background option

    private ButtonGroup backgroundGroup; // ensures only one button is selected

    /**
     * Constructor
     * 
     * Sets up:
     * - panel styling
     * - radio buttons
     * - grouping behavior
     * - layout
     */
    public BackgroundPanel() {

        // panel styling
        this.setBackground(new Color(202, 209, 180));
        this.setBorder(BorderFactory.createTitledBorder("Choose the right background"));

        // create radio buttons
        birthdayBgButton = new JRadioButton("Birthday");
        winterBgButton = new JRadioButton("Winter");
        halloweenBgButton = new JRadioButton("Halloween");

        // group buttons (only one can be selected at a time)
        backgroundGroup = new ButtonGroup();
        backgroundGroup.add(birthdayBgButton);
        backgroundGroup.add(winterBgButton);
        backgroundGroup.add(halloweenBgButton);

        // add buttons to panel
        this.add(birthdayBgButton);
        this.add(winterBgButton);
        this.add(halloweenBgButton);

        // stack buttons vertically
        this.setLayout(new GridLayout(3,1));

    }
    
    /**
     * Returns the currently selected background as a String.
     * Returns null if nothing is selected.
     */
    public String getSelectedBackground() {

        if (birthdayBgButton.isSelected()) return "Birthday";
        else if (winterBgButton.isSelected()) return "Winter";
        else if (halloweenBgButton.isSelected()) return "Halloween";

        return null;
    }

    /**
     * Getters for buttons
     * Used in GameFrame to attach ActionListeners
     */
    public JRadioButton getBirthdayButton() {
        return birthdayBgButton;
    }

    public JRadioButton getWinterButton() {
        return winterBgButton;
    }

    public JRadioButton getHalloweenButton() {
        return halloweenBgButton;
    }

    /**
     * Clears all selections
     * Used when resetting the game state
     */
    public void clearSelection() {
        backgroundGroup.clearSelection();
    }
}
