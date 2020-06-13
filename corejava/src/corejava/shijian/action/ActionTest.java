package corejava.shijian.action;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class ActionTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new ActionFrame();
                frame.setTitle("ActionTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}