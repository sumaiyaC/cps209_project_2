import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * ControlPanel
 * 
 * Main container panel that holds all user controls.
 * 
 * Contains:
 * - InstructionsPanel
 * - HatPanel
 * - AccessoryPanel
 * - BackgroundPanel
 * - ActionPanel
 * 
 * This panel organizes all control components vertically and acts as the
 * main interaction area for the user.
 */

public class ControlPanel extends JPanel{

    /**
     * Constructor
     * 
     * Sets up:
     * - panel size
     * - vertical layout
     * - styling
     */
    public ControlPanel() {

        // fixed size for right-side panel
        this.setPreferredSize(new Dimension(300, 600));

        // stack components vertically
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // background color
        this.setBackground(new Color(235, 210, 190));

        // border to visually group controls
        this.setBorder(BorderFactory.createTitledBorder("Control Panel"));
    }
}
