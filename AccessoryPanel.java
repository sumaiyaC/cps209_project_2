/*
Purpose:
- radio buttons for hats

Contains:
- 3 JRadioButtons
- ButtonGroup

Add helper method: public String getSelectedAccessory()
*/

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class AccessoryPanel extends JPanel{
    //instance variables
    private JRadioButton bowButton;
    private JRadioButton scarfButton;
    private JRadioButton capeButton;
    private ButtonGroup accessoryGroup;
    
    public AccessoryPanel() {
        this.setBackground(new Color(230, 230, 250));
        this.setBorder(BorderFactory.createTitledBorder("Accessory Panel"));
        bowButton = new JRadioButton("Bow");
        scarfButton = new JRadioButton("Scarf");
        capeButton = new JRadioButton("Cape");

        accessoryGroup = new ButtonGroup();
        accessoryGroup.add(bowButton);
        accessoryGroup.add(scarfButton);
        accessoryGroup.add(capeButton);

        this.add(bowButton);
        this.add(scarfButton);
        this.add(capeButton);

        this.setLayout(new GridLayout(3,1));

        //default accessory
        // bowButton.setSelected(true);
    }
    
    //getSelectedAccessory() method -> returns the selected hat
    public String getSelectedAccessory() {
        if (bowButton.isSelected()) return "Bow";
        else if (scarfButton.isSelected()) return "Scarf";
        else if (capeButton.isSelected()) return "Cape";
        return null;
    }

    public JRadioButton getBowButton() {
            return bowButton;
        }

    public JRadioButton getScarfButton() {
        return scarfButton;
    }

    public JRadioButton getCapeButton() {
        return capeButton;
    }

    //method to clear selection

    public void clearSelection() {
        accessoryGroup.clearSelection();
    }
}
