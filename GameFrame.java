import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;


/*
Purpose:
- main window (JFrame)
- arranges ALL panels
- connects everything together
- handles game logic (for now)

Contains:
- left panel (event + cat)
- control panel
- layout setup
- selection variables
- button actions
*/

public class GameFrame extends JFrame {
    // private JFrame mainFrame;
    public GameFrame() {
        this.setTitle("Make Your cat Look Snazzy!");
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //command to center JPanel on screen
        this.setLocationRelativeTo(null);

        // Main frame layout
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
        //Main frame color background
        this.getContentPane().setBackground(new Color(245, 230, 215));

        // =========================
        // LEFT SIDE PANEL
        // =========================
        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(500, 600));
        leftPanel.setOpaque(false);

        // Event panel placeholder
        EventPanel eventPanel = new EventPanel();

        // Cat display panel placeholder
        CatDisplayPanel catDisplayPanel = new CatDisplayPanel();
    
        leftPanel.setLayout(new BorderLayout(0, 15));
        leftPanel.add(eventPanel, BorderLayout.NORTH);
        leftPanel.add(catDisplayPanel, BorderLayout.CENTER);

        // =========================
        // CONTROL PANEL
        // =========================
        ControlPanel controlPanel = new ControlPanel();

        // Instructions panel placeholder
        InstructionsPanel instructionsPanel = new InstructionsPanel();

        // Hat panel placeholder
        HatPanel hatPanel = new HatPanel();

        // Accessory panel placeholder
        AccessoryPanel accessoryPanel = new AccessoryPanel();

        // Background panel placeholder
        BackgroundPanel backgroundPanel = new BackgroundPanel();

        // Action panel placeholder
        ActionPanel actionPanel = new ActionPanel();

        // Add panels to control panel
        controlPanel.add(instructionsPanel);
        controlPanel.add(Box.createVerticalStrut(15));
        controlPanel.add(hatPanel);
        controlPanel.add(Box.createVerticalStrut(15));
        controlPanel.add(accessoryPanel);
        controlPanel.add(Box.createVerticalStrut(15));
        controlPanel.add(backgroundPanel);
        controlPanel.add(Box.createVerticalStrut(15));
        controlPanel.add(actionPanel);

        // Add main sections to frame
        this.add(leftPanel);
        this.add(controlPanel);

        //default cat settings
        // String hat = hatPanel.getSelectedHat();
        // catDisplayPanel.setSelectedHat(hat);

        // String accessory = accessoryPanel.getSelectedAccessory();
        // catDisplayPanel.setSelectedAccessory(accessory);

        this.setVisible(true);

    }

}
