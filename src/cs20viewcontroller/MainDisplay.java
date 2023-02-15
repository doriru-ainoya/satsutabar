/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs20viewcontroller;

import cs20models.Backend;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author atsuya-o
 */
public class MainDisplay {

    JFrame window;
    JButton button;
    JTextField errField;

    public MainDisplay(Backend be) {
        this.window = new JFrame();
        this.button = new JButton();
        this.errField = new JTextField();
        this.components();
    }

    private void components() {
        this.window.setBackground(new Color(255, 255, 255));
        this.window.setLayout(new GridBagLayout());
        this.window.setBounds(0, 0, 200, 100);
        this.window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.window.setVisible(true);
        
        this.button.setText("契約完了！");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.CENTER;

        this.button.setVisible(true);
        this.window.add(this.button, gbc);
//        this.window.add(this.button);
    }
    public void printError (String s) {
        this.button.setText(s);
        this.window.add(this.errField);
        this.window.repaint();
    }
    
}
