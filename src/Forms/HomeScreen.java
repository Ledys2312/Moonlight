package Forms;

import Objects.SessionManager;
import Objects.User;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class HomeScreen {

    private JPanel homePanel;
    private JButton startButton;
    private JButton exitButton;
    private JButton rankingButton;

    public HomeScreen() {

        homePanel = new JPanel(null);
        startButton = new JButton("Start the Adventure");
        rankingButton = new JButton("Ranking");
        exitButton = new JButton("Exit");

        homePanel.setPreferredSize(new Dimension(800,550));

        startButton.setBounds(300,200,300,40);
        rankingButton.setBounds(300,250,200,40);
        exitButton.setBounds(300,300,200,40);

        homePanel.add(startButton);
        homePanel.add(rankingButton);
        homePanel.add(exitButton);

        JLabel homeLabel = new JLabel("Welcome to MoonLight", SwingConstants.CENTER);
        homeLabel.setBounds(150,100,500,80);

        try {
            File fontFile = new File("src/Fonts/Rolie Twily.otf");

            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(45f);

            homeLabel.setFont(customFont);
        } catch (Exception e) {
            e.printStackTrace();
        }

        homePanel.add(homeLabel);

    }

    public JPanel getHomePanel() {
        return homePanel;
    }

    public void setHomePanel(JPanel homePanel) {
        this.homePanel = homePanel;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public void setStartButton(JButton startButton) {
        this.startButton = startButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public void setExitButton(JButton exitButton) {
        this.exitButton = exitButton;
    }

    public JButton getRankingButton() {
        return rankingButton;
    }

    public void setRankingButton(JButton rankingButton) {
        this.rankingButton = rankingButton;
    }
}
