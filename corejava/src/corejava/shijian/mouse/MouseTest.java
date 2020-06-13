package corejava.shijian.mouse;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class MouseTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
               JFrame frame = new MouseFrame();
               frame.setTitle("MouseTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
        });
    }
}
