package Forms;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static java.awt.Font.TRUETYPE_FONT;
import static java.awt.Font.createFont;

public class LoginInScreen {

    private JPanel signInPanel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton signInButton;

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

    public LoginInScreen() {

        signInPanel = new JPanel();
        usernameField = new JTextField();
        passwordField = new JPasswordField();

        signInPanel.setPreferredSize(new Dimension(800,550));
        signInPanel.setSize(new Dimension(800,550));
        signInPanel.setLayout(null);


        JLabel lblUsername = new JLabel("Write your username");
        lblUsername.setBounds(285, 180, 200, 20);
        usernameField.setBounds(285, 210, 200, 20);

        JLabel lblPassword = new JLabel("Write your password");
        lblPassword.setBounds(285, 250, 200, 20);
        passwordField.setBounds(285, 280, 200, 20);

        signInButton = new JButton("Sign In");
        signInButton.setBounds(335, 320, 100, 40);


        signInPanel.add(lblUsername);
        signInPanel.add(usernameField);
        signInPanel.add(lblPassword);
        signInPanel.add(passwordField);
        signInPanel.add(signInButton);
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
        LoginInScreen loginInScreen = new LoginInScreen();

        frame.setContentPane(loginInScreen.getSignInPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,550);

        frame.setLocationRelativeTo(null);

        JLabel signInLabel = new JLabel("Sign In");

        try {
            File fontFile = new File("src/Fonts/Rolie Twily.otf");

            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(35f);  // Tamaño 24

            signInLabel.setFont(customFont);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int labelWidth = 550;
        int labelHeight = 80;
        int x = (1200 - labelWidth) / 2;
        int y = 100;

        signInLabel.setBounds(x,y,labelWidth,labelHeight);

        loginInScreen.getSignInPanel().setLayout(null);
        loginInScreen.getSignInPanel().add(signInLabel);

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