import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;



public class EventPanel extends JPanel{
    private JLabel eventLabel;
    private Color black56 = new Color(56, 56, 56);
    public EventPanel() {
        this.setPreferredSize(new Dimension(500, 60));
        this.setBackground(new Color(202, 209, 180));
        //this.setBorder(BorderFactory.createLineBorder(black56, 1));
        this.setLayout(new BorderLayout());

        eventLabel = new JLabel("Dress your cat for:");
        eventLabel.setHorizontalAlignment(SwingConstants.CENTER);
        eventLabel.setVerticalAlignment(SwingConstants.CENTER);

        this.add(eventLabel, BorderLayout.CENTER);
    }
    //method to set the event
    public void setEvent(String event) {
        eventLabel.setText("Dress your cat for " + event + "!");
    }
}
