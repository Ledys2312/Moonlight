package Forms;

import Design.Buttoms;
import Design.PasswordField;
import Design.TextField;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static java.awt.Font.TRUETYPE_FONT;
import static java.awt.Font.createFont;

public class LoginUpScreen{

    private JPanel signUpPanel;
    private TextField nameField;
    private TextField surnameField;
    private TextField usernameField;
    private PasswordField passwordField;
    private Buttoms signUpButton;
    private Buttoms backButton;

    public LoginUpScreen() {

        signUpPanel = new JPanel(null);
        signUpPanel.setBackground(new Color(245,230,232));

        JLabel lblName = new JLabel("Name");
        lblName.setForeground(new Color(3, 14, 40));
        lblName.setBounds(290,160,200,20);
        this.nameField = new TextField(20);
        nameField.setBounds(290, 190, 200, 20);

        JLabel lblSurname = new JLabel("Surname");
        lblSurname.setForeground(new Color(3, 14, 40));
        lblSurname.setBounds(290,220,200,20);
        this.surnameField = new TextField(20);
        surnameField.setBounds(290, 250, 200, 20);

        JLabel lblUsername = new JLabel("Write your username");
        lblUsername.setForeground(new Color(3, 14, 40));
        lblUsername.setBounds(290,280,200,20);
        this.usernameField = new TextField(20);
        usernameField.setBounds(290, 310, 200, 20);

        JLabel lblPassword = new JLabel("Write your password");
        lblPassword.setForeground(new Color(3, 14, 40));
        lblPassword.setBounds(290,340,200,20);
        this.passwordField = new PasswordField(20);
        passwordField.setBounds(290, 370, 200, 20);

        this.signUpButton = new Buttoms("Sign Up");
        signUpButton.setBounds(390, 410, 100, 40);

        this.backButton = new Buttoms("Back");
        backButton.setBounds(280, 410, 100, 40);

        JLabel signUpLabel = new JLabel("Sign Up", SwingConstants.CENTER);
        signUpLabel.setBounds(150,80,500,60);
        signUpLabel.setForeground(new Color(122,92,134));

        try {
            File fontFile = new File("src/Fonts/Rolie Twily.otf");

            Font customFont = createFont(TRUETYPE_FONT, fontFile).deriveFont(45f);  // Tamaño 24

            signUpLabel.setFont(customFont);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            File fontFile = new File("src/Fonts/dogicapixel.ttf");
            Font costumn = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(10f);
            lblName.setFont(costumn);
            lblSurname .setFont(costumn);
            lblUsername.setFont(costumn);
            lblPassword.setFont(costumn);
            signUpButton.setFont(costumn);
            backButton.setFont(costumn);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        signUpPanel.add(lblName);
        signUpPanel.add(nameField);
        signUpPanel.add(lblSurname);
        signUpPanel.add(surnameField);
        signUpPanel.add(lblUsername);
        signUpPanel.add(usernameField);
        signUpPanel.add(lblPassword);
        signUpPanel.add(passwordField);
        signUpPanel.add(signUpButton);
        signUpPanel.add(backButton);
        signUpPanel.add(signUpLabel);

    }

    public JPanel getSignUpPanel() {
        return signUpPanel;
    }

    public void setSignUpPanel(JPanel signUpPanel) {
        this.signUpPanel = signUpPanel;
    }

    public TextField getNameField() {
        return nameField;
    }

    public void setNameField(TextField nameField) {
        this.nameField = nameField;
    }

    public TextField getSurnameField() {
        return surnameField;
    }

    public void setSurnameField(TextField surnameField) {
        this.surnameField = surnameField;
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

    public Buttoms getSignUpButton() {
        return signUpButton;
    }

    public void setSignUpButton(Buttoms signUpButton) {
        this.signUpButton = signUpButton;
    }

    public Buttoms getBackButton() {
        return backButton;
    }

    public void setBackButton(Buttoms backButton) {
        this.backButton = backButton;
    }
}