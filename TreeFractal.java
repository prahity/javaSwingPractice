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
        int length = 225;
        int midX = 450;
        int bottomY = 750;
        double angle = -Math.PI / 2;

        //Drawing base of tree
        g.setColor(Color.white);
        g.drawLine(midX,bottomY,midX,bottomY - length);

        //Calling recursive function for rest of tree
        paintLinesRecurse(g,midX,bottomY - length,length / 1.5,angle);
    }

    public void paintLinesRecurse(Graphics g,int startX,int startY,double length,double angle) {

        //Initializing variables
        double division = 1.4;

        // Base case (stops when length is too small)
        if(length < 0.5) {
            return;
        }

        //Recursive case for left tree side
        int x =(int)( Math.cos(angle - Math.PI / 6) * length);
        int y =(int)( Math.sin(angle - Math.PI / 6) * length);
        g.drawLine(startX,startY,startX + x,startY + y);
        paintLinesRecurse(g,startX + x,startY + y,(length / division),angle - Math.PI/6);

        //Recursive case for right tree side
        x =(int)( Math.cos(angle + Math.PI / 6) * length);
        y =(int)( Math.sin(angle + Math.PI / 6) * length);
        g.drawLine(startX,startY,startX + x,startY + y);
        paintLinesRecurse(g,startX + x,startY + y,(length / division),angle + Math.PI/6);
    }
}


