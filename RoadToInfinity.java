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
        int origWidth = 535;
        //Initializing variables
        int height =3;

        //Drawing first triangle
        g.setColor(Color.black);
        g.fillRect(225,800,origWidth,height);

        //Calling recursive function for rest of triangles
        paintLinesRecurse(g,450 - origWidth/2,800,origWidth,height,1);
    }

    public void paintLinesRecurse(Graphics g, int prevX,int prevY,int prevWidth,int height,int count) {

        //base case
        if(count > 500) {
            return;
        }
        if(count % 2 == 1) {
            g.setColor(Color.white);
        } else {
            g.setColor(Color.black);
        }

        //create a given rectangle
        g.fillRect(prevX + 1,prevY - height,prevWidth - 2,height);

        //call recursively for next set of triangles
        paintLinesRecurse(g,prevX + 1, prevY - height,prevWidth - 2,height,count + 1);
    }
}


