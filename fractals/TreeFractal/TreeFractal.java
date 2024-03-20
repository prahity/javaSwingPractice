import javax.swing.*;
import java.awt.*;


public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My Project");//creates a new tab with title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closing behavior
        frame.setSize(900, 800); //setting the size

        //Creating graphic and adding to background
        Tree tree  = new Tree();
        frame.setBackground(Color.black);
        frame.add(tree);
        frame.setVisible(true);


    }
}

class Tree extends JPanel {
    public void paintComponent(Graphics g) {

        //Initializing variables
        int length = 200;
        int midX = 450;
        int bottomY = 750;
        double angle = -Math.PI/2;
        double angleChange = Math.PI/6;

        //Drawing base of tree
        g.setColor(Color.white);
        g.drawLine(midX,bottomY,midX,bottomY - length);

        //Calling recursive function for rest of tree

        paintLinesRecurse(g,midX,bottomY - length,length / 1.5,angle,angleChange);
    }

    public void paintLinesRecurse(Graphics g,int startX,int startY,double length,double angle,double angleChange) {

        //Initializing variables
        double division = 1.4;//Math.random() / 10 + 1.3;

        // Base case (stops when length is too small)
        if(length < 0.5) {
            return;
        }

        //Recursive case for left tree side
        int x =(int)( Math.cos(angle - angleChange) * length);
        int y =(int)( Math.sin(angle - angleChange) * length);
        g.drawLine(startX,startY,startX + x,startY + y);
        paintLinesRecurse(g,startX + x,startY + y,(length / division),angle - angleChange,angleChange);

        //Recursive case for right tree side
        x =(int)( Math.cos(angle + angleChange) * length);
        y =(int)( Math.sin(angle + angleChange) * length);
        g.drawLine(startX,startY,startX + x,startY + y);
        paintLinesRecurse(g,startX + x,startY + y,(length / division),angle + angleChange,angleChange);
    }
}

