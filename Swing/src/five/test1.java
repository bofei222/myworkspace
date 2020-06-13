package five;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class test1 {
    static final int WIDTH = 300;
    static final int HEIGTH = 200;
    public static void main(String[] args) {
        JFrame jf = new JFrame("测试程序");
        jf.setSize(WIDTH, HEIGTH);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        JPanel contentPane = new JPanel();
        jf.setContentPane(contentPane);
        JButton b1 = new JButton("生活");
        JButton b2 = new JButton("工作");
        JButton b3 = new JButton("睡觉");
        JButton b4 = new JButton("购物");
        JButton b5 = new JButton("饮食");
        BorderLayout lay = new BorderLayout();
        jf.setLayout(lay);
        contentPane.add(b1,"North");
        contentPane.add(b2,"South");
        contentPane.add(b3,"East");
        contentPane.add(b4,"West");
        contentPane.add(b5,"Center");
    }
}
