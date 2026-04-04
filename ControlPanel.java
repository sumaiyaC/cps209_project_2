/*
Purpose:
- holds all right-side panels
- stacks them vertically

Contains:
- InstructionsPanel
- HatPanel
- AccessoryPanel
- BackgroundPanel
- ActionPanel

- Uses BoxLayout.Y_AXIS
 */

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class ControlPanel extends JPanel{
    public ControlPanel() {
        this.setPreferredSize(new Dimension(300, 600));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(new Color(235, 210, 190));
        this.setBorder(BorderFactory.createTitledBorder("Control Panel"));
    }
}
