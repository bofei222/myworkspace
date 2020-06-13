package corejava.shijian.mouse;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JComponent;
/**
 * 
 * @author bofei
 *
 */
public class MouseComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;;
    
    private static final int SIDELENGTH = 10;
    private ArrayList<Rectangle2D> squares;
    private Rectangle2D current; // the square containing the mouse cursor
    
    public MouseComponent() {
        squares = new ArrayList<>();
        current = null;
        
        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());
    }
    
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        // draw all squares
        for (Rectangle2D r : squares)
            g2.draw(r);
    }
    
    public Rectangle2D find(Point2D p) {
        for (Rectangle2D r : squares) {
            if (r.contains(p)) return r;
        }
        return null;
    }
    
    public void add(Point2D p) {
        double x = p.getX();
        double y = p.getY();
        
        current = new Rectangle2D.Double(x - SIDELENGTH/2,
                y - SIDELENGTH/2, SIDELENGTH, SIDELENGTH);
        squares.add(current);
        repaint();
    }
    
    public void remove(Rectangle2D s) {
        if (s == null) return;
        if (s == current) current = null;
        squares.remove(s);
        repaint();
    }
    
    private class MouseHandler extends MouseAdapter {
        public void mousePressed(MouseEvent event) {
            // add a new suare if the cursor isn't inside
            current = find(event.getPoint());
            if (current == null) add(event.getPoint());
        }
        
        public void mouseClicked(MouseEvent event) {
            // remove 
            current = find(event.getPoint());
            if (current != null && event.getClickCount() >= 2)
                remove(current);
        }
    }
        private class MouseMotionHandler 
        implements MouseMotionListener {
            @Override
            public void mouseMoved(MouseEvent event) {
                //
                //
                if (find(event.getPoint()) == null) 
                    setCursor(Cursor.getDefaultCursor());
                else
                    setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                
            }
            @Override
            public void mouseDragged(MouseEvent event) {
                if (current != null) {
                    int x = event.getX();
                    int y = event.getY();
                    
                    // drag the current 
                    current.setFrame(x - SIDELENGTH/2, 
                            y - SIDELENGTH, SIDELENGTH, SIDELENGTH);
                    repaint();
                }
            }
           }
        public Dimension getPreferredSize() {
            return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        }
}
