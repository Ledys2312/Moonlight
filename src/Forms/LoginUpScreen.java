package Forms;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.awt.Font.TRUETYPE_FONT;
import static java.awt.Font.createFont;

public class LoginUpScreen extends JFrame {

    private JPanel signUpPanel;
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton signUpButton;
    private JButton backButton;

    public JPanel getSignUpPanel() {
        return signUpPanel;
    }

    public void setSignUpPanel(JPanel signUpPanel) {
        this.signUpPanel = signUpPanel;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    public JTextField getSurnameField() {
        return surnameField;
    }

    public void setSurnameField(JTextField surnameField) {
        this.surnameField = surnameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public void setUsernameField(JTextField usernameField) {
        this.usernameField = usernameField;
    }

    public JButton getSignUpButton() {
        return signUpButton;
    }

    public void setSignUpButton(JButton signUpButton) {
        this.signUpButton = signUpButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    public LoginUpScreen() {

        setTitle("MoonLight");
        setSize(800,550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        signUpPanel = new JPanel(null);
        nameField = new JTextField();
        surnameField = new JTextField();
        usernameField = new JTextField();
        passwordField = new JPasswordField();


        JLabel lblName = new JLabel("Name");
        lblName.setBounds(290,200,200,20);
        nameField.setBounds(290, 230, 200, 20);
        JLabel lblSurname = new JLabel("Surname");
        lblSurname.setBounds(290,260,200,20);
        surnameField.setBounds(290, 290, 200, 20);
        JLabel lblUsername = new JLabel("Write your username");
        lblUsername.setBounds(290,320,200,20);
        usernameField.setBounds(290, 350, 200, 20);
        JLabel lblPassword = new JLabel("Write your password");
        lblPassword.setBounds(290,380,200,20);
        passwordField.setBounds(290, 410, 200, 20);
        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(390, 450, 100, 40);
        backButton = new JButton("Back");
        backButton.setBounds(280, 450, 100, 40);

        JLabel signUpLabel = new JLabel("Sign Up", SwingConstants.CENTER);
        signUpLabel.setBounds(150,80,500,60);

        try {
            File fontFile = new File("src/Fonts/Rolie Twily.otf");

            Font customFont = createFont(TRUETYPE_FONT, fontFile).deriveFont(35f);  // Tamaño 24

            signUpLabel.setFont(customFont);
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

        lblName.setFont(costumn);
        lblSurname .setFont(costumn);
        lblUsername.setFont(costumn);
        lblPassword.setFont(costumn);
        signUpButton.setFont(costumn);
        backButton.setFont(costumn);

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

        setContentPane(signUpPanel);

        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Image icon = pantalla.getImage("src/Img/Icon.png");
        setIconImage(icon);
    }


}