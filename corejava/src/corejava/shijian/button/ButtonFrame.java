package corejava.shijian.button;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonFrame extends JFrame {
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    
    public ButtonFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        
        // create butons
        JButton yellowButton = new JButton("YEllow");
        JButton blueButton = new JButton("Blue");
        JButton redButton = new JButton("Red");
        
        buttonPanel = new JPanel();
        
        // add buttons to panel
        buttonPanel.add(yellowButton);
        
        // create button actions
        ColorAction yelloewAction = new ColorAction(Color.YELLOW);
        
    }
    
    private class ColorAction implements ActionListener {
        private Color backgroundColor;
        
        public ColorAction(Color c) {
            backgroundColor = c;
        }
        public void actionPerformed(ActionEvent  event) {
            buttonPanel.setBackground(backgroundColor);
        }
    }
}
