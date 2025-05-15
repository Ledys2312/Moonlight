package Main;

import Connection.LoginConnection;
import Forms.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import static java.awt.Font.TRUETYPE_FONT;
import static java.awt.Font.createFont;

public class Moonlight {

    private static JFrame frame;
    private static JPanel panelMain;
    private static CardLayout cardLayout;

    public static void main(String[] args){

        setUIFont();

        JFrame frame = new JFrame("MoonLight");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,550);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src/Img/Icon.png"));

        cardLayout = new CardLayout();
        panelMain = new JPanel(cardLayout);

        LoginScreen loginScreen = new LoginScreen();
        LoginInScreen loginInScreen = new LoginInScreen();
        LoginUpScreen loginUpScreen = new LoginUpScreen();
        HomeScreen homeScreen = new HomeScreen();
        SelectionScreen selectionScreen = new SelectionScreen();
        GameScreen gameScreen = new GameScreen();

        panelMain.add(loginScreen.getLoginPanel(), "Login");
        panelMain.add(loginInScreen.getSignInPanel(), "Sign In");
        panelMain.add(loginUpScreen.getSignUpPanel(), "Sign Up");
        panelMain.add(homeScreen.getHomePanel(), "Home");
        panelMain.add(selectionScreen.getSelectionPanel(), "Selection");

        frame.setContentPane(panelMain);
        frame.setVisible(true);

        loginScreen.getLoginInButton().addActionListener(e -> showScreen("Sign In"));
        loginScreen.getLoginUpButton().addActionListener(e -> showScreen("Sign Up"));
        loginInScreen.getBackButton().addActionListener(e -> showScreen("Login"));
        loginUpScreen.getBackButton().addActionListener(e -> showScreen("Login"));

        loginUpScreen.getSignUpButton().addActionListener(e -> {
            String name = loginUpScreen.getNameField().getText();
            String surname = loginUpScreen.getSurnameField().getText();
            String username = loginUpScreen.getUsernameField().getText();
            String password = loginUpScreen.getPasswordField().getText();

            if (name.isEmpty() || surname.isEmpty() || username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "You must enter all the fields correctly");
                return;
            }

            boolean success = LoginConnection.registerUser(name, surname, username, password);
            if (success) {
                JOptionPane.showMessageDialog(null, "Welcome " + name + " to MoonLight. ");
                showScreen("Home");
            } else {
                JOptionPane.showMessageDialog(null, "Something went wrong. ");
            }
        });

        loginInScreen.getSignInButton().addActionListener(e -> {
            String username = loginInScreen.getUsernameField().getText();
            String password = loginInScreen.getPasswordField().getText();

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "You must enter all the fields correctly");
                return;
            }

            boolean success = LoginConnection.authenticateUser(username, password);
            if (success) {
                JOptionPane.showMessageDialog(null, "Welcome again " + username + " to MoonLight. ");
                showScreen("Home");
            } else {
                JOptionPane.showMessageDialog(null, "Username or password is incorrect. Try again.");
            }
        });

        homeScreen.getStartButton().addActionListener(e -> showScreen("Selection"));
        homeScreen.getRankingButton().addActionListener(e -> showScreen("Ranking"));
        homeScreen.getExitButton().addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(null,
                    "Are you sure you wanna go?",
                    "Confirmation",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            if (confirm == JOptionPane.YES_OPTION) {
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            } else {
                frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            }
        });

        selectionScreen.getBackButton().addActionListener(e -> showScreen("Home"));

    }

    public static void showScreen(String title){
        cardLayout.show(panelMain, title);
    }

    public static void setUIFont() {

        try {
            File fontFile = new File("src/Fonts/dogicapixel.ttf");

            Font customFont = createFont(TRUETYPE_FONT, fontFile).deriveFont(16f);  // Tamaño 16
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

            java.util.Enumeration<Object> keys = UIManager.getDefaults().keys();
            while (keys.hasMoreElements()) {
                Object key = keys.nextElement();
                Object value = UIManager.get(key);
                if (value instanceof Font) {
                    UIManager.put(key, customFont);
                }
            }

        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

    }
}