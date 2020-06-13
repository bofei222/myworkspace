package corejava.shijian.button;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class ButtonTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
           @Override
           public void run() {
               JFrame frame = new ButtonFrame();
               frame.setTitle("ButtonTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
           }
        });
    }
}