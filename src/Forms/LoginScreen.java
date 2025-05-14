package Forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import static java.awt.Font.*;

public class LoginScreen {

    private JFrame frame;
    private JPanel loginPanel;
    private JButton loginInButton;
    private JButton loginUpButton;

    public JPanel getLoginPanel() {
        return loginPanel;
    }

    public void setLoginPanel(JPanel loginPanel) {
        this.loginPanel = loginPanel;
    }

    public JButton getLoginInButton() {
        return loginInButton;
    }

    public void setLoginInButton(JButton loginInButton) {
        this.loginInButton = loginInButton;
    }

    public JButton getLoginUpButton() {
        return loginUpButton;
    }

    public void setLoginUpButton(JButton loginUpButton) {
        this.loginUpButton = loginUpButton;
    }

    public LoginScreen(JFrame frame) {

        this.frame = frame;

        loginPanel = new JPanel();
        loginInButton = new JButton("Sign in");
        loginUpButton = new JButton("Sign Up");

        loginPanel.setPreferredSize(new Dimension(800,550));

        loginInButton.setBounds(300, 200, 200, 40);
        loginUpButton.setBounds(300, 260, 200, 40);

        // Agrega los botones al panel
        loginPanel.add(loginInButton);
        loginPanel.add(loginUpButton);

        JLabel welcomeLabel = new JLabel("Welcome to MoonLight", SwingConstants.CENTER);
        welcomeLabel.setBounds(150,100,500,80);

        try {
            File fontFile = new File("src/Fonts/Rolie Twily.otf");

            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(50f);

            welcomeLabel.setFont(customFont);
        } catch (Exception e) {
            e.printStackTrace();
        }

        loginPanel.add(welcomeLabel);
    }

}