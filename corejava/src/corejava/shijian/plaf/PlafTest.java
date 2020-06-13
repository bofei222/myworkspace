package corejava.shijian.plaf;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class PlafTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new PlafFrame();
                frame.setTitle("PlafTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

