package cs20viewcontroller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Animation extends JFrame {

    JFrame window;
    JLabel label;
    JLabel message;

    public Animation() {
        this.components();
    }

    private void components() {
        window = new JFrame();
        window.getContentPane().setBackground(new Color(255, 255, 255));
        window.setLayout(new GridBagLayout());
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        window.setBounds(0, 0, d.width, d.height);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setTitle("Animation Frame");

        window.setVisible(true);
    }

    public void playGif(int count) {
        window.getContentPane().removeAll();

        URL url;
        ImageIcon imageIcon = null;
        url = Animation.class.getResource("/money_shower.gif");
        imageIcon = new ImageIcon(url);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(d.width, d.height, Image.SCALE_DEFAULT));

        label = new JLabel(imageIcon);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.CENTER;

        label.setVisible(true);
        window.add(label, gbc);
        
        message = new JLabel();
        Font font = null;
        try {
            
            
            font = Font.createFont(Font.TRUETYPE_FONT, Animation.class.getResourceAsStream("/06TogeGothic-Bold.otf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);
            font = new Font(font.getFontName(), Font.BOLD, 150);
            message.setFont(font);
        } catch (IOException | FontFormatException e) {
            //Handle exception
        }
        
        message.setText("￥" + Integer.toString(count*3) + "0,000");
        message.setForeground(Color.red);
        message.setSize(1200, 500);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        
        label.setLayout(new GridBagLayout());
        message.setVisible(true);
        label.add(message, gbc);
        
        
        SwingUtilities.updateComponentTreeUI(this.window);
        window.repaint();
        /*Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                label.setVisible(false);
            }
        }, 8000);*/
    }

    public void hide() {
        label.setVisible(true);
    }
}
