import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class HatPanel extends JPanel{
    //instance variables
    private JRadioButton partyHatButton;
    private JRadioButton beanieHatButton;
    private JRadioButton witchHatButton;
    private ButtonGroup hatGroup;

    public HatPanel() {
        this.setBackground(new Color(255, 228, 225));
        this.setBorder(BorderFactory.createTitledBorder("Hat Panel"));

        partyHatButton = new JRadioButton("Party Hat");
        beanieHatButton = new JRadioButton("Beanie");
        witchHatButton = new JRadioButton("Witch Hat");

        hatGroup = new ButtonGroup();
        hatGroup.add(partyHatButton);
        hatGroup.add(beanieHatButton);
        hatGroup.add(witchHatButton);

        this.add(partyHatButton);
        this.add(beanieHatButton);
        this.add(witchHatButton);

        this.setLayout(new GridLayout(3,1));

        //default hat
        partyHatButton.setSelected(true);
    }

    //getSelectedHat() method -> returns the selected hat
    public String getSelectedHat() {
        if (partyHatButton.isSelected()) return "Party Hat";
        else if (beanieHatButton.isSelected()) return "Beanie Hat";
        else if (witchHatButton.isSelected()) return "Witch Hat";
        return "";
    }
}
