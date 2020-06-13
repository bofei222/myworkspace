package test;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
 
import javax.swing.JFrame;
 
public class JComboBoxTest extends JFrame {
 
  private JComboBox comboBox;
 
  /**
   * Launch the application
   * 
   * @param args
   */
  public static void main(String args[]) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          JComboBoxTest frame = new JComboBoxTest();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
 
  /**
   * Create the frame
   */
  public JComboBoxTest() {
    super();
    getContentPane().setLayout(null);
    setBounds(100, 100, 500, 375);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
    comboBox = new JComboBox();
    comboBox.addItemListener(new ItemListener() {
      public void itemStateChanged(final ItemEvent e) {
        int index = comboBox.getSelectedIndex();
        if (index != 0) { // ==0表示选中的事第一个
          String content = comboBox.getSelectedItem().toString();
          System.out.println("index222="
              + index + ", content=" + content);
        }
      }
    });
    comboBox.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent e) {
        int index = comboBox.getSelectedIndex();
        if (index != 0) { // ==0表示选中的事第一个
          String content = comboBox.getSelectedItem().toString();
          System.out.println("index111="
              + index + ", content=" + content);
        }
      }
    });
    comboBox.setBounds(96, 131, 106, 25);
    comboBox.addItem("");
    comboBox.addItem("1111");
    comboBox.addItem("2222");
    comboBox.addItem("3333");
    getContentPane().add(comboBox);
    //
  }
 
}