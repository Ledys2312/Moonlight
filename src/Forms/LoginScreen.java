package Forms;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static java.awt.Font.*;

public class LoginScreen {

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

    public LoginScreen() {

        loginPanel = new JPanel();
        loginInButton = new JButton("Sign in");
        loginUpButton = new JButton("Sign Up");

        loginPanel.setPreferredSize(new Dimension(800,550));
        loginPanel.setSize(new Dimension(800,550));
        loginPanel.setLayout(null);

        loginInButton.setBounds(300, 200, 200, 40);
        loginUpButton.setBounds(300, 260, 200, 40);

        // Agrega los botones al panel
        loginPanel.add(loginInButton);
        loginPanel.add(loginUpButton);

    }

    public static void main(String[] args) {

        try {
            File fontFile = new File("src/Fonts/dogicapixel.ttf");

            Font customFont = createFont(TRUETYPE_FONT, fontFile).deriveFont(16f);  // Tamaño 16
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

            setUIFont(customFont);

        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Moonlight");
        LoginScreen loginScreen = new LoginScreen();

        frame.setContentPane(loginScreen.getLoginPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,550);

        frame.setLocationRelativeTo(null);

        JLabel welcomeLabel = new JLabel("Welcome to Moonlight", SwingConstants.CENTER);

        try {
            File fontFile = new File("src/Fonts/Rolie Twily.otf");

            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(50f);  // Tamaño 24

            welcomeLabel.setFont(customFont);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int labelWidth = 500;
        int labelHeight = 80;
        int x = (800 - labelWidth) / 2;
        int y = 100;
        welcomeLabel.setBounds(x, y, labelWidth, labelHeight);

        loginScreen.getLoginPanel().setLayout(null);
        loginScreen.getLoginPanel().add(welcomeLabel);

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