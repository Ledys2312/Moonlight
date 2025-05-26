package Forms;

import Design.Buttoms;
import Design.StarPanel;
import Objects.SessionManager;
import Objects.User;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class HomeScreen {

    private JPanel homePanel;
    private Buttoms startButton;
    private Buttoms rankingButton;
    private Buttoms exitButton;

    public HomeScreen() {

        homePanel = new JPanel(null);

        homePanel.setPreferredSize(new Dimension(800,550));
        homePanel.setBackground(new Color(3, 14, 40));

        StarPanel starPanel = new StarPanel();
        starPanel.setBounds(0,0,800,550);
        starPanel.setOpaque(false);
        homePanel.add(starPanel);
        homePanel.setComponentZOrder(starPanel,homePanel.getComponentCount()-1);

        this.startButton = new Buttoms("Start");
        startButton.setForeground(new Color(245,230,232));
        startButton.setBounds(300,200,200,40);

        this.rankingButton = new Buttoms("Ranking");
        rankingButton.setForeground(new Color(245,230,232));
        rankingButton.setBounds(300,250,200,40);

        this.exitButton = new Buttoms("Exit");
        exitButton.setForeground(new Color(245,230,232));
        exitButton.setBounds(300,300,200,40);

        homePanel.add(startButton);
        homePanel.add(rankingButton);
        homePanel.add(exitButton);

        JLabel homeLabel = new JLabel("Welcome to MoonLight", SwingConstants.CENTER);
        homeLabel.setBounds(150,100,500,80);
        homeLabel.setForeground(new Color(245,230,232));

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

    public Buttoms getStartButton() {
        return startButton;
    }

    public void setStartButton(Buttoms startButton) {
        this.startButton = startButton;
    }

    public Buttoms getRankingButton() {
        return rankingButton;
    }

    public void setRankingButton(Buttoms rankingButton) {
        this.rankingButton = rankingButton;
    }

    public Buttoms getExitButton() {
        return exitButton;
    }

    public void setExitButton(Buttoms exitButton) {
        this.exitButton = exitButton;
    }
}
