import javax.swing.*;
import java.awt.*;


public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My Project");//creates a new tab with title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closing behavior
        frame.setSize(900, 800); //setting the size

        //Creating graphic and adding to background
        Triangle triangle  = new Triangle();
        frame.setBackground(Color.black);
        frame.add(triangle);
        frame.setVisible(true);


    }
}

class Triangle extends JPanel {
    public void paintComponent(Graphics g) {

        //Initializing variables
        int side = 800;

        //Drawing first triangle
        g.setColor(Color.white);
        g.drawLine(50,700,50 + side,700);
        g.drawLine((100 + side)/2,(int)(700 - side /2 * Math.sqrt(3)),50 + side,700);
        g.drawLine(50,700,(100 + side)/2,(int)(700 - side /2 * Math.sqrt(3)));

        //Calling recursive function for rest of triangles
        paintLinesRecurse(g,50,50 + side,700, (int)(700 - side /2 * Math.sqrt(3)),0);
    }

    public void paintLinesRecurse(Graphics g, int xLeft, int xRight, int baseY, int topY,int triangleCount) {

        //base case
        if(triangleCount > 7) {
            return;
        }

        //create a given triangle
        g.drawLine((xRight + xLeft) / 2,baseY,(3* xLeft + xRight) / 4,(baseY + topY) / 2);
        g.drawLine((xRight + xLeft) / 2,baseY,(xLeft + 3 * xRight) / 4,(baseY + topY) / 2);
        g.drawLine((3* xLeft + xRight) / 4,(baseY + topY) / 2,(xLeft + 3 * xRight) / 4,(baseY + topY) / 2);

        //call recursively for next set of triangles
        paintLinesRecurse(g,(3 * xLeft + xRight)/ 4,(xLeft + 3 * xRight) / 4,(baseY + topY)/2,topY,triangleCount + 1);
        paintLinesRecurse(g, xLeft,(xLeft + xRight) / 2,baseY,(baseY + topY) / 2,triangleCount + 1);
        paintLinesRecurse(g,(xLeft + xRight)/ 2,xRight,baseY,(baseY+topY)/2,triangleCount + 1);
    }
}

