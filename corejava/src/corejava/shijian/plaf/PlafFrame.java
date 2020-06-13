package corejava.shijian.plaf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class PlafFrame extends JFrame {
    private JPanel buttonPanel;
    public PlafFrame() {
        buttonPanel = new JPanel();
        UIManager.LookAndFeelInfo[] infos = 
                UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo info : infos) 
            makeButton(info.getName(), info.getClassName());
       
        add(buttonPanel);
        pack();
    }
    void makeButton(String name, final String plafName) {
        // add button to panel
        JButton button = new JButton(name);
        buttonPanel.add(button);
        
        //set button action
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    UIManager.setLookAndFeel(plafName);
                    SwingUtilities.updateComponentTreeUI(PlafFrame.this);
                    pack();
                } catch (Exception e) {
                }
            }
        });
    }
}
