package test;

import javax.swing.JFrame;

public class Swingtest {
    static final int WIDTH = 300;
    static final int HEIGHT = 200;
    public static void main(String[] args) {
        JFrame jf = new JFrame("helloSwing");
        jf.setSize(WIDTH, HEIGHT);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        
        
    }
}
