package Forms;

import Design.Buttoms;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class LoginScreen {

    private JPanel loginPanel;
    private Buttoms loginInButton;
    private Buttoms loginUpButton;


    public JPanel getLoginPanel() {
        return loginPanel;
    }

    public void setLoginPanel(JPanel loginPanel) {
        this.loginPanel = loginPanel;
    }

    public Buttoms getLoginInButton() {
        return loginInButton;
    }

    public void setLoginInButton(Buttoms loginInButton) {
        this.loginInButton = loginInButton;
    }

    public Buttoms getLoginUpButton() {
        return loginUpButton;
    }

    public void setLoginUpButton(Buttoms loginUpButton) {
        this.loginUpButton = loginUpButton;
    }

    public LoginScreen() {


        loginPanel = new JPanel(null);

        loginPanel.setPreferredSize(new Dimension(800,550));
        loginPanel.setBackground(new Color(245,230,232));

        JLabel corporationLabel = new JLabel("Etoile corporation");
        corporationLabel.setBounds(290,5,400,50);
        corporationLabel.setForeground(new Color(177, 147, 186));
        loginPanel.add(corporationLabel);

        JLabel background = new JLabel(new ImageIcon("src/Img/Grass.gif"));
        background.setBounds(0, 190, 400, 420);
        loginPanel.add(background);

        JLabel background1 = new JLabel(new ImageIcon("src/Img/Grass.gif"));
        background1.setBounds(400, 190, 400, 420);
        loginPanel.add(background1);

        this.loginInButton = new Buttoms("Sign in");
        loginInButton.setBounds(300, 230, 200, 40);

        this.loginUpButton = new Buttoms("Sign Up");
        loginUpButton.setBounds(300, 290, 200, 40);

        // Agrega los botones al panel
        loginPanel.add(loginInButton);
        loginPanel.add(loginUpButton);

        JLabel welcomeLabel = new JLabel("MoonLight", SwingConstants.CENTER);
        welcomeLabel.setBounds(150,100,500,120);
        welcomeLabel.setForeground(new Color(122,92,134));

        try {
            File fontFile = new File("src/Fonts/Rolie Twily.otf");

            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(80f);

            welcomeLabel.setFont(customFont);
        } catch (Exception e) {
            e.printStackTrace();
        }

        loginPanel.add(welcomeLabel);
    }
}