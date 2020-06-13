package test;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HelloWorld {
    public static void main(String[] args) {
        
        
        JFrame frame = new JFrame("测试窗口");
        JPanel panel = new JPanel();
        frame.setContentPane(panel);
        JButton button = new JButton("这是一个测试按钮");
        button.setVisible(false);
        panel.add(button);
        frame.setVisible(true);
        frame.setSize(300, 200);

    }
}
