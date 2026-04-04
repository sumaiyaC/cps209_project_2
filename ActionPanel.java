/*
Purpose:
contains:
- Check Outfit button

You can pass the button back to GameFrame or attach listener here.
*/

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ActionPanel extends JPanel{
    //instance variables
    private JButton checkOutfit;

    public ActionPanel() {
        this.setBackground(new Color(240, 255, 240));
        this.setBorder(BorderFactory.createTitledBorder("Action Panel"));
        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        checkOutfit = new JButton("Check Outfit!");
        checkOutfit.setPreferredSize(new Dimension(250, 40));

        this.add(checkOutfit);
    }
}
