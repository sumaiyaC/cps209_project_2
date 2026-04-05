/*
Purpose:
- radio buttons for hats

Contains:
- 3 JRadioButtons
- ButtonGroup

Add helper method: public String getSelectedBackground()
*/

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class BackgroundPanel extends JPanel{
    //instance variables
    private JRadioButton birthdayBgButton;
    private JRadioButton winterBgButton;
    private JRadioButton halloweenBgButton;
    private ButtonGroup backgroundGroup;

    public BackgroundPanel() {
        this.setBackground(new Color(224, 255, 255));
        this.setBorder(BorderFactory.createTitledBorder("Background Panel"));
        birthdayBgButton = new JRadioButton("Birthday");
        winterBgButton = new JRadioButton("Winter");
        halloweenBgButton = new JRadioButton("Halloween");

        backgroundGroup = new ButtonGroup();
        backgroundGroup.add(birthdayBgButton);
        backgroundGroup.add(winterBgButton);
        backgroundGroup.add(halloweenBgButton);

        this.add(birthdayBgButton);
        this.add(winterBgButton);
        this.add(halloweenBgButton);

        this.setLayout(new GridLayout(3,1));

        //default background
        // winterBgButton.setSelected(true);
    }
    
    //getSelectedAccessory() method -> returns the selected hat
    public String getSelectedBackground() {
        if (birthdayBgButton.isSelected()) return "Birthday";
        else if (winterBgButton.isSelected()) return "Winter";
        else if (halloweenBgButton.isSelected()) return "Halloween";
        return null;
    }

    public JRadioButton getBirthdayButton() {
            return birthdayBgButton;
        }

    public JRadioButton getWinterButton() {
        return winterBgButton;
    }

    public JRadioButton getHalloweenButton() {
        return halloweenBgButton;
    }

    //method to clear selection
    public void clearSelection() {
        backgroundGroup.clearSelection();
    }
}
