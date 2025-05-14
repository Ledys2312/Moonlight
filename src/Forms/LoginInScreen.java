package Forms;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static java.awt.Font.TRUETYPE_FONT;
import static java.awt.Font.createFont;

public class LoginInScreen extends JFrame {

    private JPanel signInPanel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton signInButton;
    private JButton backButton;

    public JPanel getSignInPanel() {
        return signInPanel;
    }

    public void setSignInPanel(JPanel signInPanel) {
        this.signInPanel = signInPanel;
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public void setUsernameField(JTextField usernameField) {
        this.usernameField = usernameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public JButton getSignInButton() {
        return signInButton;
    }

    public void setSignInButton(JButton signInButton) {
        this.signInButton = signInButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    public LoginInScreen() {

        setTitle("MoonLight");
        setSize(800,550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        signInPanel = new JPanel(null);
        usernameField = new JTextField();
        passwordField = new JPasswordField();

        JLabel lblUsername = new JLabel("Write your username");
        lblUsername.setBounds(285, 180, 200, 20);
        usernameField.setBounds(285, 210, 200, 20);

        JLabel lblPassword = new JLabel("Write your password");
        lblPassword.setBounds(285, 250, 200, 20);
        passwordField.setBounds(285, 280, 200, 20);

        signInButton = new JButton("Sign In");
        signInButton.setBounds(390, 320, 100, 40);

        backButton = new JButton("Back");
        backButton.setBounds(280, 320, 100, 40);


        JLabel signInLabel = new JLabel("Sign In", SwingConstants.CENTER);
        signInLabel.setBounds(150, 80, 500, 60);
        try {
            File fontFile = new File("src/Fonts/Rolie Twily.otf");

            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(35f);

            signInLabel.setFont(customFont);
        } catch (Exception e) {
            e.printStackTrace();
        }

        File fontFile = new File("src/Fonts/dogicapixel.ttf");
        Font costumn = null;
        try {
            costumn = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(10f);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        lblUsername.setFont(costumn);
        lblPassword.setFont(costumn);
        signInButton.setFont(costumn);
        backButton.setFont(costumn);

        signInPanel.add(lblUsername);
        signInPanel.add(usernameField);
        signInPanel.add(lblPassword);
        signInPanel.add(passwordField);
        signInPanel.add(signInButton);
        signInPanel.add(backButton);
        signInPanel.add(signInLabel);

        setContentPane(signInPanel);

    }
}