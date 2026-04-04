import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
Purpose:
- draws cat + outfit
- only drawing logic here
*/

public class CatDisplayPanel extends JPanel {
    //instance variables
    JLabel catLabel;
    public Color black56 = new Color(56, 56, 56);
    public int catx = 140, caty = 130;
    private String selectedHat;
    private String selectedAccessory;
    private String selectedBackground;


    public CatDisplayPanel() {
        this.setPreferredSize(new Dimension(500, 700));
        this.setBackground(new Color(255, 248, 220));
        this.setBorder(BorderFactory.createTitledBorder("Cat Display Panel"));
    }
    public void setSelectedHat(String hat) {
        this.selectedHat = hat;
        repaint(); 
    }
    public void setSelectedAccessory(String accessory) {
        this.selectedAccessory = accessory;
        repaint();
    }

    public void setSelectedBackground(String background) {
        this.selectedBackground = background;
        repaint();
    }

    //draw Circle class
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
            g2d.setColor(this.color);
            g2d.fillOval(this.x, this.y, this.width, this.height);

            g2d.setColor(black56);
            g2d.setStroke(new BasicStroke(5));
            g2d.drawOval(this.x, this.y, this.width, this.height);

            
        }
    }

    //draw Triangle class
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
            g2d.setColor(this.color);
            g2d.fillPolygon(this.xPoints, this.yPoints, 3);

            g2d.setColor(black56);
            g2d.setStroke(new BasicStroke(5));
            g2d.drawPolygon(this.xPoints, this.yPoints, 3);
        }

    }

    //draw Rectangle class
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
            g2d.setColor(this.color);
            g2d.fillRect(this.x, this.y, this.width, this.height);

            g2d.setColor(black56);
            g2d.setStroke(new BasicStroke(5));
            g2d.drawRect(this.x, this.y, this.width, this.height);
        }
    }

    //draw Cat component
    public class Cat {
        Circle catShadow;
        int[] leftEarX = {catx + 45, catx + 35, catx + 115};
        int[] leftEarY = {caty + 50, caty - 10, caty + 45};
        Triangle leftEar;
        int[] rightEarX = {catx + 125, catx + 205, catx + 195};
        int[] rightEarY = {caty + 45, caty - 10, caty + 50};
        Triangle rightEar;
        Circle tail;
        Circle leftBackLeg;
        Circle rightBackLeg;
        Circle leftBackFoot;
        Circle leftFrontFoot;
        Circle rightBackFoot;
        Circle rightFrontFoot;
        Circle body;
        Circle head;
        Circle leftEye;
        Circle leftPupil;
        Circle rightEye;
        Circle rightPupil;
        Circle nose;

        public Cat() {
            catShadow = new Circle(catx - 30, caty + 320, 300, 50, black56);

            leftEar = new Triangle(leftEarX, leftEarY, Color.white);
            rightEar = new Triangle(rightEarX, rightEarY, Color.white);

            tail = new Circle(catx + 10, caty + 150, 40, 80, Color.white);

            leftBackLeg = new Circle(catx + 10, caty + 180, 90, 150, Color.white);
            rightBackLeg = new Circle(catx + 140, caty + 180, 90, 150, Color.white);
            leftBackFoot = new Circle(catx + 10, caty + 300, 70, 40, Color.white);
            leftFrontFoot = new Circle(catx + 40, caty + 320, 80, 40, Color.white);
            rightBackFoot = new Circle(catx + 160, caty + 300, 70, 40, Color.white);
            rightFrontFoot = new Circle(catx + 120, caty + 320, 80, 40, Color.white);

            body = new Circle(catx + 30, caty + 120, 180, 220, Color.white);
            head = new Circle(catx + 20, caty + 20, 200, 170, Color.white);

            leftEye = new Circle(catx + 55, caty + 70, 45, 60, Color.white);
            leftPupil = new Circle(catx + 72, caty + 85, 10, 30, black56);

            rightEye = new Circle(catx + 140, caty + 70, 45, 60, Color.white);
            rightPupil = new Circle(catx + 157, caty + 85, 10, 30, black56);

            nose = new Circle(catx + 105, caty + 125, 30, 20, Color.white);
        }
        public void draw(Graphics g) {
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

    //draw PartyHat component
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
    //draw Bow component
    public class Bow {
        Triangle leftTri;
        Triangle rightTri;
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

    //draw Beanie component
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

    //draw Scarf component
    public class Scarf {
        Rectangle rect; 
        public Scarf() {
            rect = new Rectangle(catx + 40, caty + 155, 160, 40, black56);
        }
        public void draw(Graphics g) {
            rect.draw(g);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        new Cat().draw(g);

        //update for Birthday
        if (selectedHat != null && selectedHat.equals("Party Hat")) {
            new PartyHat().draw(g);;
        }
        if (selectedAccessory != null && selectedAccessory.equals("Bow")) {
            new Bow().draw(g);
        }
        if (selectedBackground != null && selectedBackground.equals("Birthday")) {
            //change background
            new PartyHat().draw(g);;
        }
        
        //might be easier to create switch case sytem for accessory, hat, and background?
        
    }
    
}

