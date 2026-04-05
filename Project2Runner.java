public class Project2Runner {
    
    /*
     ******** Project Description ********
     * 
     * This program is a simple Swing-based dress-up game where the user styles a cat based on a randomly selected event. 
     * The user chooses a hat, accessory, and background using radio buttons, then submits their outfit to be scored. 
     * The program checks the selections against the correct combination for the event and returns a score with feedback.
     * 
     * The UI is structured using multiple panels to support a clean layout and object-oriented design.
     * The cat along with its items (hat, accessory, etc.) is drawn using custom 2D graphics. 
     * 
     * The game loop consists of selecting an event, building an outfit, checking the result, and moving to the next event.
     * 
     ******** Swing Requirement ********
     * 
     * The program uses multiple Swing components including JButton, JRadioButton, and JLabel. 
     * The JButton is defined in ActionPanel.java (on line 22). JRadioButtons are defined in HatPanel.java, AccessoryPanel.java, 
     * and BackgroundPanel.java (under instance variables comment), and JLabel is used in EventPanel.java (on line 22). 
     * These components allow user interaction and display dynamic content, 
     * satisfying the requirement of using at least three unique Swing components.
     * 
     ******** 2D Graphics Requirement ********
     * 
     * The program uses a custom JPanel for drawing in CatDisplayPanel.java (starting at the class definition). 
     * This panel overrides paintComponent(Graphics g) to draw the cat and its selected items using Java 2D graphics (Graphics2D). 
     * Shapes like circles, triangles, and rectangles are used to construct the cat and accessories, fulfilling the requirement for custom drawing on a JPanel.
     * 
     ******** Event Listener Requirement ********
     *
     * The program uses ActionListeners to handle user interactions. 
     * An ActionListener is attached to the "Check Outfit" button in GameFrame.java (on line 150), 
     * which triggers scoring and event progression. Additional ActionListeners are attached to JRadioButtons in the 
     * control panels (HatPanel, AccessoryPanel, BackgroundPanel, after line 124 in GameFrame.java) to update the displayed outfit 
     * dynamically when selections change. A KeyListener is also added in GameFrame.java at line 184, to allow the user to press the “C” key to trigger the "Check Outfit" button, 
     * improving usability and providing an additional way to interact with the program. These listeners ensure the UI responds to user input 
     * and satisfy the event handling requirement.
     */

public static void main(String[] args) {
    new GameFrame();
}
}
