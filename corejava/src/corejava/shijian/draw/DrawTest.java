package corejava.shijian.draw;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class DrawTest {

}

class DrawComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 400;
    
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        
        // draw a rectangle
        double leftX = 100;
        double topY = 100;
        double width = 200;
        double height = 150;
        
        
    }
}
