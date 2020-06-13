package corejava.shijian.action;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ActionFrame extends JFrame {
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    
    public ActionFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        
        buttonPanel = new JPanel();
        
        // define actions
        Action yellowAction = new ColorAction("Yellow", 
                new ImageIcon("yellow-ball.gif"), Color.YELLOW);
        Action blueAction = new ColorAction("Blue", 
                new ImageIcon("blue-ball.gif"), Color.BLUE);
        Action redAction = new ColorAction("Red", 
                new ImageIcon("red-ball.gif"), Color.RED);
        
        // associate the names with actions
        ActionMap amap = buttonPanel.getActionMap();
        amap.put("panel.yellow", yellowAction);
        amap.put("panel.blue", blueAction);
        amap.put("panel.red", redAction);
    }
    
    public class ColorAction extends AbstractAction {
        public ColorAction(String name, Icon icon, Color c) {
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION, 
                "Set panel color to " + name.toLowerCase());
            putValue("color", c);
        }
        public void actionPerformed(ActionEvent evetn) {
            Color c = (Color)getValue("color");
            buttonPanel.setBackground(c);
        }
    }
}
