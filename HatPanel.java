import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * HatPanel
 * 
 * Panel that allows the user to select a hat for the cat.
 * 
 * Contains:
 * - three JRadioButtons (Party Hat, Beanie, Witch Hat)
 * - a ButtonGroup to ensure only one can be selected at a time
 * 
 * This class only manages selection state, no game logic.
 */

public class HatPanel extends JPanel{

    // instance variables

    private JRadioButton partyHatButton;   // party hat option
    private JRadioButton beanieHatButton;  // beanie option
    private JRadioButton witchHatButton;   // witch hat option

    private ButtonGroup hatGroup; // ensures only one button is selected

    /**
     * Constructor
     * 
     * Sets up:
     * - panel styling
     * - radio buttons
     * - grouping behavior
     * - layout
     */
    public HatPanel() {

        // panel styling
        this.setBackground(new Color(202, 209, 180));
        this.setBorder(BorderFactory.createTitledBorder("Choose the right hat"));

        // create radio buttons
        partyHatButton = new JRadioButton("Party Hat");
        beanieHatButton = new JRadioButton("Beanie");
        witchHatButton = new JRadioButton("Witch Hat");

        // group buttons (only one can be selected at a time)
        hatGroup = new ButtonGroup();
        hatGroup.add(partyHatButton);
        hatGroup.add(beanieHatButton);
        hatGroup.add(witchHatButton);

        // add buttons to panel
        this.add(partyHatButton);
        this.add(beanieHatButton);
        this.add(witchHatButton);

        // stack buttons vertically
        this.setLayout(new GridLayout(3,1));
    }

    /**
     * Returns the currently selected hat as a String.
     * Returns null if nothing is selected.
     */
    public String getSelectedHat() {

        if (partyHatButton.isSelected()) return "Party Hat";
        else if (beanieHatButton.isSelected()) return "Beanie Hat";
        else if (witchHatButton.isSelected()) return "Witch Hat";

        return null;
    }

    /**
     * Getters for buttons
     * Used in GameFrame to attach ActionListeners
     */
    public JRadioButton getPartyHatButton() {
        return partyHatButton;
    }

    public JRadioButton getBeanieButton() {
        return beanieHatButton;
    }

    public JRadioButton getWitchHatButton() {
        return witchHatButton;
    }

    /**
     * Clears all selections
     * Used when resetting the game state
     */
    public void clearSelection() {
        hatGroup.clearSelection();
    }
}