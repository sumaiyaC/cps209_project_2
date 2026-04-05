/*
Purpose:
contains:
- Check Outfit button

You can pass the button back to GameFrame or attach listener here.
*/

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ActionPanel extends JPanel{
    //instance variables
    private JButton checkOutfitButton;
    public ActionPanel() {
        this.setBackground(new Color(202, 209, 180));
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
        this.setPreferredSize(new Dimension(0, 60));
        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        checkOutfitButton = new JButton("Check Outfit!");
        checkOutfitButton.setPreferredSize(new Dimension(250, 40));

        this.setLayout(new GridBagLayout());
        this.add(checkOutfitButton);
    }
    public JButton getCheckButton() {
        return checkOutfitButton;
    }   
}
