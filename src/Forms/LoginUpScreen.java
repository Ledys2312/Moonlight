package Forms;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static java.awt.Font.TRUETYPE_FONT;
import static java.awt.Font.createFont;

public class LoginUpScreen {

    private JPanel signUpPanel;
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton signUpButton;

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

    public LoginUpScreen() {

        signUpPanel = new JPanel();
        nameField = new JTextField();
        surnameField = new JTextField();
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        signUpButton = new JButton("Sign Up");

        signUpPanel.setPreferredSize(new Dimension(800,550));
        signUpPanel.setSize(new Dimension(800,550));
        signUpPanel.setLayout(null);

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
        signUpButton.setBounds(340, 450, 100, 40);


        signUpPanel.add(lblName);
        signUpPanel.add(nameField);
        signUpPanel.add(lblSurname);
        signUpPanel.add(surnameField);
        signUpPanel.add(lblUsername);
        signUpPanel.add(usernameField);
        signUpPanel.add(lblPassword);
        signUpPanel.add(passwordField);
        signUpPanel.add(signUpButton);
    }

    public static void main(String[] args) {

        try {
            File fontFile = new File("src/Fonts/dogicapixel.ttf");

            Font customFont = createFont(TRUETYPE_FONT, fontFile).deriveFont(10f);  // Tamaño 16
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

            setUIFont(customFont);

        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Moonlight");
        LoginUpScreen loginupScreen = new LoginUpScreen();

        frame.setContentPane(loginupScreen.getSignUpPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,550);

        frame.setLocationRelativeTo(null);

        JLabel signUpLabel = new JLabel("Sign Up");

        try {
            File fontFile = new File("src/Fonts/Rolie Twily.otf");

            Font customFont = createFont(TRUETYPE_FONT, fontFile).deriveFont(35f);  // Tamaño 24

            signUpLabel.setFont(customFont);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int labelWidth = 550;
        int labelHeight = 80;
        int x = (1200 - labelWidth) / 2;
        int y = 120;

        signUpLabel.setBounds(x,y,labelWidth,labelHeight);

        loginupScreen.getSignUpPanel().setLayout(null);
        loginupScreen.getSignUpPanel().add(signUpLabel);

        frame.setVisible(true);

        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Image icon = pantalla.getImage("src/Img/Icon.png");
        frame.setIconImage(icon);
    }

    public static void setUIFont(Font font) {
        java.util.Enumeration<Object> keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof Font) {
                UIManager.put(key, font);
            }
        }
    }
}