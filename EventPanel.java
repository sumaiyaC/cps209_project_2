import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * EventPanel
 * 
 * Displays the current event the user needs to dress the cat for.
 * 
 * Contains:
 * - a centered JLabel that updates based on the current event
 * 
 * This panel is display-only and does not handle any logic.
 */

public class EventPanel extends JPanel{

    // instance variables
    private JLabel eventLabel; // label showing current event

    /**
     * Constructor
     * 
     * Sets up:
     * - panel styling
     * - label alignment
     * - layout
     */
    public EventPanel() {

        // fixed size for top panel
        this.setPreferredSize(new Dimension(500, 60));

        // background color
        this.setBackground(new Color(202, 209, 180));

        // use BorderLayout so label fills space and can be centered properly
        this.setLayout(new BorderLayout());

        // create label
        eventLabel = new JLabel("Dress your cat for:");

        // center text horizontally and vertically
        eventLabel.setHorizontalAlignment(SwingConstants.CENTER);
        eventLabel.setVerticalAlignment(SwingConstants.CENTER);

        // add label to center of panel
        this.add(eventLabel, BorderLayout.CENTER);
    }

    /**
     * Updates the event text displayed to the user
     */
    public void setEvent(String event) {
        eventLabel.setText("Dress your cat for " + event + "!");
    }
}
