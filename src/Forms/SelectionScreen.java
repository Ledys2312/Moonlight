package Forms;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class SelectionScreen {

    private JPanel selectionPanel;
    private JButton levelEasyButton;
    private JButton levelNormalButton;
    private JButton levelDifficultButton;
    private JButton backButton;

    public SelectionScreen() {

        selectionPanel = new JPanel(null);
        levelEasyButton = new JButton("Easy Level");
        levelNormalButton = new JButton("Normal Level");
        levelDifficultButton = new JButton("Difficult Level");
        backButton = new JButton("Go Home");

        selectionPanel.setPreferredSize(new Dimension(800,550));

        levelEasyButton.setBounds(300,200,310,40);
        levelNormalButton.setBounds(300,250,310,40);
        levelDifficultButton.setBounds(300,300,310,40);
        backButton.setBounds(300,350,310,40);

        selectionPanel.add(levelEasyButton);
        selectionPanel.add(levelNormalButton);
        selectionPanel.add(levelDifficultButton);
        selectionPanel.add(backButton);

        JLabel levelLabel = new JLabel("Choose a Level");
        levelLabel.setBounds(150,100,500,80);

        try {
            File fontFile = new File("src/Fonts/Rolie Twily.otf");

            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(45f);

            levelLabel.setFont(customFont);
        } catch (Exception e) {
            e.printStackTrace();
        }

        selectionPanel.add(levelLabel);
    }

    public JPanel getSelectionPanel() {
        return selectionPanel;
    }

    public void setSelectionPanel(JPanel selectionPanel) {
        this.selectionPanel = selectionPanel;
    }

    public JButton getLevelEasyButton() {
        return levelEasyButton;
    }

    public void setLevelEasyButton(JButton levelEasyButton) {
        this.levelEasyButton = levelEasyButton;
    }

    public JButton getLevelNormalButton() {
        return levelNormalButton;
    }

    public void setLevelNormalButton(JButton levelNormalButton) {
        this.levelNormalButton = levelNormalButton;
    }

    public JButton getLevelDifficultButton() {
        return levelDifficultButton;
    }

    public void setLevelDifficultButton(JButton levelDifficultButton) {
        this.levelDifficultButton = levelDifficultButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }
}
