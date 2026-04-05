import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * CatDisplayPanel
 * 
 * Responsible for all drawing in the game.
 * 
 * Handles:
 * - drawing the cat
 * - drawing selected outfit items (hat, accessory)
 * - drawing background images
 * 
 * This class is purely visual. No game logic here.
 * It just reflects the current state passed from GameFrame.
 */

public class CatDisplayPanel extends JPanel {

    // instance variables

    private Color black56 = new Color(56, 56, 56); // main outline color

    // base position for cat (used to calculate all shapes)
    private int catx = 140, caty = 130;

    // current selections (set from GameFrame)
    private String selectedHat;
    private String selectedAccessory;
    private String selectedBackground;

    // background images
    private Image birthdayBg;
    private Image winterBg;
    private Image halloweenBg;


    /**
     * Constructor
     * 
     * Sets up:
     * - panel size and background
     * - loads background images
     */
    public CatDisplayPanel() {

        this.setPreferredSize(new Dimension(500, 700));
        this.setBackground(new Color(246, 245, 235));

        // load images from resources
        birthdayBg = new ImageIcon(getClass().getResource("birthday.png")).getImage();
        winterBg = new ImageIcon(getClass().getResource("winter.png")).getImage();
        halloweenBg = new ImageIcon(getClass().getResource("halloween.png")).getImage();
    }

    /**
     * Set selected hat and redraw
     */
    public void setSelectedHat(String hat) {
        this.selectedHat = hat;
        repaint(); 
    }

    /**
     * Set selected accessory and redraw
     */
    public void setSelectedAccessory(String accessory) {
        this.selectedAccessory = accessory;
        repaint();
    }

    /**
     * Set selected background and redraw
     */
    public void setSelectedBackground(String background) {
        this.selectedBackground = background;
        repaint();
    }

    // =========================
    // BASIC SHAPES
    // =========================

    /**
     * Circle helper class
     * Used to draw filled + outlined ovals
     */
    public class Circle {

        int width, height, x, y;
        Color color;

        public Circle(int x, int y, int width, int height, Color color) {
            this.width = width;
            this.height = height;
            this.x = x;
            this.y = y;
            this.color = color;
        }

        public void draw(Graphics g) {

            Graphics2D g2d = (Graphics2D) g;

            // fill shape
            g2d.setColor(this.color);
            g2d.fillOval(this.x, this.y, this.width, this.height);

            // outline
            g2d.setColor(black56);
            g2d.setStroke(new BasicStroke(5));
            g2d.drawOval(this.x, this.y, this.width, this.height);
        }
    }

    /**
     * Triangle helper class
     */
    public class Triangle {

        int[] xPoints, yPoints;
        Color color;

        public Triangle(int[] xPoints, int[] yPoints, Color color) {
            this.xPoints = xPoints;
            this.yPoints = yPoints;
            this.color = color;
        }

        public void draw(Graphics g) {

            Graphics2D g2d = (Graphics2D) g;

            // fill
            g2d.setColor(this.color);
            g2d.fillPolygon(this.xPoints, this.yPoints, 3);

            // outline
            g2d.setColor(black56);
            g2d.setStroke(new BasicStroke(5));
            g2d.drawPolygon(this.xPoints, this.yPoints, 3);
        }
    }

    /**
     * Rectangle helper class
     */
    public class Rectangle {

        int x, y, width, height;
        Color color;

        public Rectangle(int x, int y, int width, int height, Color color) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.color = color;
        }

        public void draw(Graphics g) {

            Graphics2D g2d = (Graphics2D) g;

            // fill
            g2d.setColor(this.color);
            g2d.fillRect(this.x, this.y, this.width, this.height);

            // outline
            g2d.setColor(black56);
            g2d.setStroke(new BasicStroke(5));
            g2d.drawRect(this.x, this.y, this.width, this.height);
        }
    }

    // =========================
    // CAT
    // =========================

    /**
     * Cat class
     * 
     * Builds the entire cat using shapes.
     * All coordinates are based on catx, caty.
     */
    public class Cat {

        // instance varaiables consists of many shape components that make up the cat
        Circle catShadow;

        int[] leftEarX = {catx + 45, catx + 35, catx + 115};
        int[] leftEarY = {caty + 50, caty - 10, caty + 45};
        Triangle leftEar;

        int[] rightEarX = {catx + 125, catx + 205, catx + 195};
        int[] rightEarY = {caty + 45, caty - 10, caty + 50};
        Triangle rightEar;

        Circle tail;

        Circle leftBackLeg, rightBackLeg;
        Circle leftBackFoot, leftFrontFoot;
        Circle rightBackFoot, rightFrontFoot;

        Circle body, head;

        Circle leftEye, leftPupil;
        Circle rightEye, rightPupil;

        Circle nose;

        public Cat() {

            // shadow
            catShadow = new Circle(catx - 30, caty + 320, 300, 50, black56);

            // ears
            leftEar = new Triangle(leftEarX, leftEarY, Color.white);
            rightEar = new Triangle(rightEarX, rightEarY, Color.white);

            // tail
            tail = new Circle(catx + 10, caty + 150, 40, 80, Color.white);

            // legs + feet
            leftBackLeg = new Circle(catx + 10, caty + 180, 90, 150, Color.white);
            rightBackLeg = new Circle(catx + 140, caty + 180, 90, 150, Color.white);
            leftBackFoot = new Circle(catx + 10, caty + 300, 70, 40, Color.white);
            leftFrontFoot = new Circle(catx + 40, caty + 320, 80, 40, Color.white);
            rightBackFoot = new Circle(catx + 160, caty + 300, 70, 40, Color.white);
            rightFrontFoot = new Circle(catx + 120, caty + 320, 80, 40, Color.white);

            // body + head
            body = new Circle(catx + 30, caty + 120, 180, 220, Color.white);
            head = new Circle(catx + 20, caty + 20, 200, 170, Color.white);

            // eyes
            leftEye = new Circle(catx + 55, caty + 70, 45, 60, Color.white);
            leftPupil = new Circle(catx + 72, caty + 85, 10, 30, black56);

            rightEye = new Circle(catx + 140, caty + 70, 45, 60, Color.white);
            rightPupil = new Circle(catx + 157, caty + 85, 10, 30, black56);

            // nose
            nose = new Circle(catx + 105, caty + 125, 30, 20, Color.white);
        }

        public void draw(Graphics g) {

            // draw in order (back → front)
            catShadow.draw(g);
            leftEar.draw(g);
            rightEar.draw(g);
            tail.draw(g);

            leftBackLeg.draw(g);
            rightBackLeg.draw(g);

            leftBackFoot.draw(g);
            leftFrontFoot.draw(g);
            rightBackFoot.draw(g);
            rightFrontFoot.draw(g);

            body.draw(g);
            head.draw(g);

            leftEye.draw(g);
            leftPupil.draw(g);

            rightEye.draw(g);
            rightPupil.draw(g);

            nose.draw(g);
        }
    }

    // =========================
    // ACCESSORIES / ITEMS
    // =========================

    /**
     * Party Hat
     */
    public class PartyHat {
        Triangle partyHatBody;
        Circle partyHatCircle;

        public PartyHat() {
            int[] partyHatXpoints = {catx + 75, catx + 120, catx + 165};
            int[] partyHatYpoints = {caty + 40, caty - 40, caty + 40};

            partyHatBody = new Triangle(partyHatXpoints, partyHatYpoints, black56);
            partyHatCircle = new Circle(catx + 105, caty - 55, 30, 30, black56);
        }

        public void draw(Graphics g) {
            partyHatBody.draw(g);
            partyHatCircle.draw(g);
        }
    }

    /**
     * Bow
     */
    public class Bow {
        Triangle leftTri, rightTri;
        Circle centreCircle;

        public Bow() {

            centreCircle = new Circle(catx + 105, caty + 175, 30, 30, black56);

            int[] leftX = {catx + 105, catx + 70, catx + 70};
            int[] leftY = {caty + 190, caty + 170, caty + 210};
            leftTri = new Triangle(leftX, leftY, black56);

            int[] rightX = {catx + 135, catx + 170, catx + 170};
            int[] rightY = {caty + 190, caty + 170, caty + 210};
            rightTri = new Triangle(rightX, rightY, black56);
        }

        public void draw(Graphics g) {
            leftTri.draw(g);
            rightTri.draw(g);
            centreCircle.draw(g);
        }
    }

    /**
     * Beanie
     */
    public class Beanie {
        Rectangle rect; 
        Circle circle;

        public Beanie() {
            rect = new Rectangle(catx + 20, caty + 20, 200, 40, black56);
            circle = new Circle(catx + 30, caty - 70, 180, 120, black56);
        }

        public void draw(Graphics g) {
            rect.draw(g);
            circle.draw(g);
        }
    }

    /**
     * Scarf
     */
    public class Scarf {
        Rectangle rect; 

        public Scarf() {
            rect = new Rectangle(catx + 40, caty + 155, 160, 40, black56);
        }

        public void draw(Graphics g) {
            rect.draw(g);
        }
    }

    /**
     * Witch Hat
     */
    public class WitchHat {
        Rectangle rect;
        int[] triPointX = {catx + 120, catx + 40, catx + 200};
        int[] triPointY = {caty - 100, caty + 50, caty + 50};
        Triangle tri;

        public WitchHat() {
            rect = new Rectangle(catx , caty + 50, 240, 5, black56);
            tri = new Triangle(triPointX, triPointY, black56);
        }

        public void draw(Graphics g) {
            rect.draw(g);
            tri.draw(g);
        }
    }

    /**
     * Cape (drawn behind cat)
     */
    public class Cape {
        int[] triPointX = {catx + 120, catx - 90, catx + 320};
        int[] triPointY = {caty + 40, caty + 320, caty + 320};
        Triangle tri;

        public Cape() {
            tri = new Triangle(triPointX, triPointY, black56);
        }

        public void draw(Graphics g) {
            tri.draw(g);
        }
    }

    /**
     * Main drawing method
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 1. background
        if (selectedBackground != null) {
            switch (selectedBackground) {
                case "Birthday":
                    g.drawImage(birthdayBg, 0, 0, getWidth(), getHeight(), this);
                    break;
                case "Winter":
                    g.drawImage(winterBg, 0, 0, getWidth(), getHeight(), this);
                    break;
                case "Halloween":
                    g.drawImage(halloweenBg, 0, 0, getWidth(), getHeight(), this);
                    break;
            }
        }

        // 2. back layer (cape behind cat)
        if (selectedAccessory != null && selectedAccessory.equals("Cape")) {
            new Cape().draw(g);
        }

        // 3. cat
        new Cat().draw(g);

        // 4. front accessories
        if (selectedAccessory != null) {
            switch (selectedAccessory) {
                case "Bow":
                    new Bow().draw(g);
                    break;
                case "Scarf":
                    new Scarf().draw(g);
                    break;
            }
        }

        // 5. hat
        if (selectedHat != null) {
            switch (selectedHat) {
                case "Party Hat":
                    new PartyHat().draw(g);
                    break;
                case "Beanie Hat":
                    new Beanie().draw(g);
                    break;
                case "Witch Hat":
                    new WitchHat().draw(g);
                    break;
            }
        }
    }
}
