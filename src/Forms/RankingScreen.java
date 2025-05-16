package Forms;

import Connection.GameConnection;
import Objects.GameRanking;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.util.List;

public class RankingScreen {

    private JPanel rankingPanel;
    private JTable rankingTable;
    private JButton backButton;


    public RankingScreen() {
        rankingPanel = new JPanel(new BorderLayout());

        JLabel rankingLabel = new JLabel("Ranking", SwingConstants.CENTER);
        try {
            File fontFile = new File("src/Fonts/Rolie Twily.otf");

            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(45f);

            rankingLabel.setFont(customFont);
        } catch (Exception e) {
            e.printStackTrace();
        }

        rankingPanel.add(rankingLabel, BorderLayout.NORTH);

        String[] columnNames = {"Username", "Total Score", "Win Games", "Lost Games"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        rankingTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(rankingTable);

        rankingPanel.add(scrollPane, BorderLayout.CENTER);

        backButton = new JButton("Back");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        rankingPanel.add(buttonPanel, BorderLayout.SOUTH);

        loadRankingData(tableModel);
    }

    private void loadRankingData(DefaultTableModel tableModel) {

        List<GameRanking> rankingList = GameConnection.getRankings();

        for (GameRanking ranking : rankingList) {
            tableModel.addRow(new Object[]{
                    ranking.getUsername(),
                    ranking.getTotalScore(),
                    ranking.getWonGames(),
                    ranking.getLostGames()
            });
        }
    }

    public JPanel getRankingPanel() {
        return rankingPanel;
    }

    public void setRankingPanel(JPanel rankingPanel) {
        this.rankingPanel = rankingPanel;
    }

    public JTable getRankingTable() {
        return rankingTable;
    }

    public void setRankingTable(JTable rankingTable) {
        this.rankingTable = rankingTable;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }
}
