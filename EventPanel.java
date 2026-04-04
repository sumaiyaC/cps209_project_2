import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
Purpose:
- shows event label
*/


public class EventPanel extends JPanel{
    private JLabel eventLabel;
    public EventPanel() {
        this.setPreferredSize(new Dimension(500, 50));
        this.setBackground(new Color(255, 214, 214));
        this.setBorder(BorderFactory.createTitledBorder("Event Panel"));
        eventLabel = new JLabel("Dress your cat for: Birthday");
        this.add(eventLabel);

        
    }
    //method to set the event
    public void setEvent(String event) {
        eventLabel.setText("Dress your cat for: " + event + " !");
    }
}
