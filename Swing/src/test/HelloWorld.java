package test;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HelloWorld {
    public static void main(String[] args) {
        
        
        JFrame frame = new JFrame("���Դ���");
        JPanel panel = new JPanel();
        frame.setContentPane(panel);
        JButton button = new JButton("����һ�����԰�ť");
        button.setVisible(false);
        panel.add(button);
        frame.setVisible(true);
        frame.setSize(300, 200);

    }
}
