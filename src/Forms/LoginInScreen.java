package Forms;

import Design.Buttoms;
import Design.CatAnimation;
import Design.PasswordField;
import Design.TextField;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LoginInScreen {

    private JPanel signInPanel;
    private TextField usernameField;
    private PasswordField passwordField;
    private Buttoms signInButton;
    private Buttoms backButton;


    public LoginInScreen() {

        signInPanel = new JPanel(null);
        signInPanel.setBackground(new Color(245,230,232));

        JLabel lblUsername = new JLabel("Write your username");
        lblUsername.setForeground(new Color(3, 14, 40));
        lblUsername.setBounds(285, 180, 200, 20);
        this.usernameField = new TextField(20);
        usernameField.setBounds(285, 210, 200, 20);

        JLabel lblPassword = new JLabel("Write your password");
        lblPassword.setForeground(new Color(3, 14, 40));
        lblPassword.setBounds(285, 250, 200, 20);
        this.passwordField = new PasswordField(20);
        passwordField.setBounds(285, 280, 200, 20);

        this.signInButton = new Buttoms("Sign In");
        signInButton.setBounds(390, 320, 100, 40);

        this.backButton = new Buttoms("Back");
        backButton.setBounds(280, 320, 100, 40);


        JLabel signInLabel = new JLabel("Sign In", SwingConstants.CENTER);
        signInLabel.setBounds(130, 100, 500, 60);
        signInLabel.setForeground(new Color(122,92,134));
        try {
            File fontFile = new File("src/Fonts/Rolie Twily.otf");

            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(45f);

            signInLabel.setFont(customFont);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            File fontFile = new File("src/Fonts/dogicapixel.ttf");
            Font costumn = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(10f);
            lblUsername.setFont(costumn);
            lblPassword.setFont(costumn);
            signInButton.setFont(costumn);
            backButton.setFont(costumn);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        new CatAnimation(signInPanel, 0, 310, 200, 200);

        signInPanel.add(lblUsername);
        signInPanel.add(usernameField);
        signInPanel.add(lblPassword);
        signInPanel.add(passwordField);
        signInPanel.add(signInButton);
        signInPanel.add(backButton);
        signInPanel.add(signInLabel);

    }

    public JPanel getSignInPanel() {
        return signInPanel;
    }

    public void setSignInPanel(JPanel signInPanel) {
        this.signInPanel = signInPanel;
    }

    public TextField getUsernameField() {
        return usernameField;
    }

    public void setUsernameField(TextField usernameField) {
        this.usernameField = usernameField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(PasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public Buttoms getSignInButton() {
        return signInButton;
    }

    public void setSignInButton(Buttoms signInButton) {
        this.signInButton = signInButton;
    }

    public Buttoms getBackButton() {
        return backButton;
    }

    public void setBackButton(Buttoms backButton) {
        this.backButton = backButton;
    }
}