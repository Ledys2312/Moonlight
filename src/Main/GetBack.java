package Main;

import Forms.LoginScreen;

import javax.swing.*;

public class GetBack {

    public static void showLoginScreen() {
        JFrame loginFrame = new JFrame("MoonLight");
        LoginScreen loginScreen = new LoginScreen(loginFrame);

        loginFrame.setContentPane(loginScreen.getLoginPanel());
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(800, 550);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);
    }
}
