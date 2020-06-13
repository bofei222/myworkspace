package corejava.shijian.mouse;

import javax.swing.JFrame;

public class MouseFrame extends JFrame {
    public MouseFrame() {
        add(new MouseComponent());
        pack();
    }
}
