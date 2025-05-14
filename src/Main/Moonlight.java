package Main;

import Forms.LoginInScreen;
import Forms.LoginScreen;
import Forms.LoginUpScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import static java.awt.Font.TRUETYPE_FONT;
import static java.awt.Font.createFont;

public class Moonlight {
    public static void main(String[] args){

        setUIFont();

        JFrame frame = new JFrame("MoonLight");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,550);
        frame.setLocationRelativeTo(null);

        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Image icon = pantalla.getImage("src/Img/Icon.png");
        frame.setIconImage(icon);

        LoginScreen loginScreen = new LoginScreen(frame);
        frame.setContentPane(loginScreen.getLoginPanel());


        loginScreen.getLoginInButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                LoginInScreen loginInScreen = new LoginInScreen();

                loginInScreen.getBackButton().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        loginInScreen.dispose();
                        GetBack.showLoginScreen();
                    }
                });

                new LoginInScreen().setVisible(true);
                frame.dispose();
            }
        });

        loginScreen.getLoginUpButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginUpScreen().setVisible(true);
                frame.dispose();
            }
        });

        frame.setVisible(true);

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