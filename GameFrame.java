import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * GameFrame
 * 
 * Main window of the application.
 * Handles:
 * - layout of all panels
 * - connecting UI components together
 * - game logic (event selection, scoring, reset)
 * - event listeners
 * 
 * Acts as the controller for the entire game.
 */

public class GameFrame extends JFrame {

    // instance variables
    private ActionListener updateListener; // reused listener for all radio buttons
    private String currentEvent; // current event user is dressing for

    // list of possible events
    private String[] events = {"a Birthday party", "Winter", "Halloween"};

    // random generator for event selection
    Random random = new Random();

    // panels
    private JPanel leftPanel;

    // class objects (UI components)
    private EventPanel eventPanel;
    private ControlPanel controlPanel;
    private InstructionsPanel instructionsPanel;
    private CatDisplayPanel catDisplayPanel;
    private HatPanel hatPanel;
    private AccessoryPanel accessoryPanel;
    private BackgroundPanel backgroundPanel;
    private ActionPanel actionPanel;

    /**
     * Constructor
     * 
     * Builds the full UI:
     * - sets frame properties
     * - creates and arranges panels
     * - attaches listeners
     * - initializes first event
     */
    public GameFrame() {

        // basic frame setup
        this.setTitle("Make Your cat Look Snazzy!");
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // center on screen

        // main layout for frame (side by side panels)
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));

        // background color of entire app
        this.getContentPane().setBackground(new Color(255,254,246));

        // LEFT SIDE PANEL (event + cat)
        leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(500, 600));
        leftPanel.setOpaque(false); // let background show through

        // event text at top
        eventPanel = new EventPanel();

        // drawing panel for cat + outfit
        catDisplayPanel = new CatDisplayPanel();

        // stack event (top) and cat (center)
        leftPanel.setLayout(new BorderLayout(0, 15));
        leftPanel.add(eventPanel, BorderLayout.NORTH);
        leftPanel.add(catDisplayPanel, BorderLayout.CENTER);

        // CONTROL PANEL (right side)
        controlPanel = new ControlPanel();

        // styling
        controlPanel.setBackground(new Color(174, 180, 155));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // sub panels
        instructionsPanel = new InstructionsPanel();
        hatPanel = new HatPanel();
        accessoryPanel = new AccessoryPanel();
        backgroundPanel = new BackgroundPanel();
        actionPanel = new ActionPanel();

        // add panels with spacing between them
        controlPanel.add(instructionsPanel);
        controlPanel.add(Box.createVerticalStrut(15));
        controlPanel.add(hatPanel);
        controlPanel.add(Box.createVerticalStrut(15));
        controlPanel.add(accessoryPanel);
        controlPanel.add(Box.createVerticalStrut(15));
        controlPanel.add(backgroundPanel);
        controlPanel.add(Box.createVerticalStrut(15));
        controlPanel.add(actionPanel);

        // add both main sections to frame
        this.add(leftPanel);
        this.add(controlPanel);

        // LISTENERS (radio buttons)

        // single listener reused for all selections
        updateListener = e -> {
            // update cat display whenever user selects something
            catDisplayPanel.setSelectedHat(hatPanel.getSelectedHat());
            catDisplayPanel.setSelectedAccessory(accessoryPanel.getSelectedAccessory());
            catDisplayPanel.setSelectedBackground(backgroundPanel.getSelectedBackground());

            this.requestFocus();
        };

        // attach listener to hat buttons
        hatPanel.getPartyHatButton().addActionListener(updateListener);
        hatPanel.getBeanieButton().addActionListener(updateListener);
        hatPanel.getWitchHatButton().addActionListener(updateListener);

        // attach listener to accessory buttons
        accessoryPanel.getBowButton().addActionListener(updateListener);
        accessoryPanel.getScarfButton().addActionListener(updateListener);
        accessoryPanel.getCapeButton().addActionListener(updateListener);

        // attach listener to background buttons
        backgroundPanel.getBirthdayButton().addActionListener(updateListener);
        backgroundPanel.getWinterButton().addActionListener(updateListener);
        backgroundPanel.getHalloweenButton().addActionListener(updateListener);

        // CHECK OUTFIT BUTTON

        actionPanel.getCheckButton().addActionListener(e -> {

            // calculate score based on selections
            int score = checkOutfitScore();

            // get feedback message
            String message = getScoreMessage(score);

            String[] options = {"Next Event"};

            // show popup with result
            JOptionPane.showOptionDialog(
                this,
                message + "\nScore: " + score + "/3",
                "Outfit Result",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
            );

            // move to next event and reset UI
            setRandomEvent();
            resetSelections();

            // bring focus back to frame so key listener keeps working
            requestFocusInWindow();
        });

        // initialize first event
        setRandomEvent();

        // CHECK OUTFIT BUTTON USING 'C' KEY    
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'c' || e.getKeyChar() == 'C') {
                    actionPanel.getCheckButton().doClick();
                }
            }
        });

        this.setVisible(true);

        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    /**
     * Picks a random event that is different from the current one.
     * Updates the event label.
     */
    private void setRandomEvent() {
        String newEvent;

        do {
            int index = random.nextInt(events.length); // pick random index
            newEvent = events[index];
        } while (newEvent.equals(currentEvent)); // avoid repeating same event

        currentEvent = newEvent;
        eventPanel.setEvent(currentEvent); // update UI
    }

    /**
     * Checks user selections against correct outfit for current event.
     * Returns score out of 3.
     */
    private int checkOutfitScore() {
        int score = 0;

        // get current selections
        String hat = hatPanel.getSelectedHat();
        String accessory = accessoryPanel.getSelectedAccessory();
        String background = backgroundPanel.getSelectedBackground();

        // birthday logic
        if ("a Birthday party".equals(currentEvent)) {
            if ("Party Hat".equals(hat)) score++;
            if ("Bow".equals(accessory)) score++;
            if ("Birthday".equals(background)) score++;
        }

        // winter logic
        else if ("Winter".equals(currentEvent)) {
            if ("Beanie Hat".equals(hat)) score++;
            if ("Scarf".equals(accessory)) score++;
            if ("Winter".equals(background)) score++;
        }

        // halloween logic
        else if ("Halloween".equals(currentEvent)) {
            if ("Witch Hat".equals(hat)) score++;
            if ("Cape".equals(accessory)) score++;
            if ("Halloween".equals(background)) score++;
        }

        return score;
    }

    /**
     * Returns feedback message based on score.
     */
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

    /**
     * Clears all selections and resets cat to default (no outfit).
     */
    private void resetSelections() {

        // clear radio buttons
        hatPanel.clearSelection();
        accessoryPanel.clearSelection();
        backgroundPanel.clearSelection();

        // clear drawing state
        catDisplayPanel.setSelectedHat(null);
        catDisplayPanel.setSelectedAccessory(null);
        catDisplayPanel.setSelectedBackground(null);
    }
}