import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * ActionPanel
 * 
 * Panel that contains the main action button for the game.
 * Responsible for:
 * - displaying the "Check Outfit" button
 * - allowing the user to submit their selections
 * 
 * This panel does not handle logic itself, it just exposes the button
 * so GameFrame can attach listeners and control behavior.
 */

public class ActionPanel extends JPanel{

    // instance variables
    private JButton checkOutfitButton; // button to trigger scoring

    /**
     * Constructor
     * 
     * Sets up:
     * - panel size and layout
     * - button styling and placement
     */
    public ActionPanel() {

        // background color of panel
        this.setBackground(new Color(202, 209, 180));

        // allow panel to stretch horizontally but keep fixed height
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
        this.setPreferredSize(new Dimension(0, 60));

        // create button
        checkOutfitButton = new JButton("Check Outfit!");

        // set button size
        checkOutfitButton.setPreferredSize(new Dimension(250, 40));

        // use GridBagLayout to perfectly center button in panel
        this.setLayout(new GridBagLayout());

        // add button to panel
        this.add(checkOutfitButton);
    }

    /**
     * Getter for check button
     * 
     * Allows GameFrame to attach ActionListener
     */
    public JButton getCheckButton() {
        return checkOutfitButton;
    }   
}