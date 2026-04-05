import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
    //instance variables
    private ActionListener updateListener;
    private String currentEvent;
    private String[] events = {"a Birthday party", "Winter", "Halloween"};
    Random random = new Random();

    //panels
    private JPanel leftPanel;

    //class objects
    private EventPanel eventPanel;
    private ControlPanel controlPanel;
    private InstructionsPanel instructionsPanel;
    private CatDisplayPanel catDisplayPanel;
    private HatPanel hatPanel;
    private AccessoryPanel accessoryPanel;
    private BackgroundPanel backgroundPanel;
    private ActionPanel actionPanel;

    public GameFrame() {
        this.setTitle("Make Your cat Look Snazzy!");
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // Main frame layout
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
        this.getContentPane().setBackground(new Color(245, 230, 215));

        // LEFT SIDE PANEL
        leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(500, 600));
        leftPanel.setOpaque(false);

        // Event panel placeholder
        eventPanel = new EventPanel();

        // Cat display panel placeholder
        catDisplayPanel = new CatDisplayPanel();
    
        leftPanel.setLayout(new BorderLayout(0, 15));
        leftPanel.add(eventPanel, BorderLayout.NORTH);
        leftPanel.add(catDisplayPanel, BorderLayout.CENTER);

        // CONTROL PANEL
        controlPanel = new ControlPanel();

        // Instructions panel placeholder
        instructionsPanel = new InstructionsPanel();

        // Hat panel placeholder
        hatPanel = new HatPanel();

        // Accessory panel placeholder
        accessoryPanel = new AccessoryPanel();

        // Background panel placeholder
        backgroundPanel = new BackgroundPanel();

        // Action panel placeholder
        actionPanel = new ActionPanel();

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

        //Listener for JRadioButtons
        updateListener = e -> {
            catDisplayPanel.setSelectedHat(hatPanel.getSelectedHat());
            catDisplayPanel.setSelectedAccessory(accessoryPanel.getSelectedAccessory());
            catDisplayPanel.setSelectedBackground(backgroundPanel.getSelectedBackground());
        };

        hatPanel.getPartyHatButton().addActionListener(updateListener);
        hatPanel.getBeanieButton().addActionListener(updateListener);
        hatPanel.getWitchHatButton().addActionListener(updateListener);

        accessoryPanel.getBowButton().addActionListener(updateListener);
        accessoryPanel.getScarfButton().addActionListener(updateListener);
        accessoryPanel.getCapeButton().addActionListener(updateListener);

        backgroundPanel.getBirthdayButton().addActionListener(updateListener);
        backgroundPanel.getWinterButton().addActionListener(updateListener);
        backgroundPanel.getHalloweenButton().addActionListener(updateListener);

        actionPanel.getCheckButton().addActionListener(e -> {
            int score = checkOutfitScore();
            String message = getScoreMessage(score);

            String[] options = {"Next Event"};

            JOptionPane.showOptionDialog(this, message + "\nScore: " + score + "/3", "Outfit Result", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            setRandomEvent();
            resetSelections();
        });

        setRandomEvent();
        this.setVisible(true);

    }
    private void setRandomEvent() {
        String newEvent;
        do {
            int index = random.nextInt(events.length);
            newEvent = events[index];
        } while (newEvent.equals(currentEvent));
        currentEvent = newEvent;
        eventPanel.setEvent(currentEvent);
    }

    private int checkOutfitScore() {
        int score = 0;
        String hat = hatPanel.getSelectedHat();
        String accessory = accessoryPanel.getSelectedAccessory();
        String background = backgroundPanel.getSelectedBackground();

        if ("a Birthday party".equals(currentEvent)) {
            if ("Party Hat".equals(hat)) score++;
            if ("Bow".equals(accessory)) score++;
            if ("Birthday".equals(background)) score++;
        }
        else if ("Winter".equals(currentEvent)) {
            if ("Beanie Hat".equals(hat)) score++;
            if ("Scarf".equals(accessory)) score++;
            if ("Winter".equals(background)) score++;
        }
        else if ("Halloween".equals(currentEvent)) {
            if ("Witch Hat".equals(hat)) score++;
            if ("Cape".equals(accessory)) score++;
            if ("Halloween".equals(background)) score++;
        }

        return score;
    }

    private String getScoreMessage(int score) {
        if (score == 3) {
            return "Perfect outfit! Your cat nailed the look.";
        }
        else if (score == 2) {
            return "So close! Just one piece was off.";
        }
        else if (score == 1) {
            return "Only one piece matched the event.";
        }
        else {
            return "Nothing matched... but your cat is still adorable.";
        }
    }

    private void resetSelections() {
        hatPanel.clearSelection();
        accessoryPanel.clearSelection();
        backgroundPanel.clearSelection();

        catDisplayPanel.setSelectedHat(null);
        catDisplayPanel.setSelectedAccessory(null);
        catDisplayPanel.setSelectedBackground(null);
    }
}
