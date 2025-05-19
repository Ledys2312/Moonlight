package Forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameScreen {

    private JPanel gamePanel;
    private JButton backButton;
    private JLabel timerLabel;
    private Timer time;
    private int timeLeft = 20;
    private Runnable onWin;
    private Maze maze;
    private JLabel[] lifes;
    private int lifesLeft = 3;
    private JLabel scoreLabel;


    public GameScreen(Maze maze) {
        this.maze = maze;
        gamePanel = new JPanel(new BorderLayout());
        maze.setGameScreenRef(this);

        // Header
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setPreferredSize(new Dimension(800, 60));
        headerPanel.setBackground(new Color(30, 30, 30));

        // Botón "Back"
        backButton = new JButton("Back");
        backButton.setFocusPainted(false);
        backButton.setBorderPainted(false);
        backButton.setBackground(new Color(70, 70, 70));
        backButton.setForeground(Color.WHITE);
        backButton.setPreferredSize(new Dimension(100, 40));

        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftPanel.setOpaque(false);
        leftPanel.add(backButton);

        ImageIcon icon = new ImageIcon("src/Img/avatar.png");
        Image scaledImage = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        JLabel userIconLabel = new JLabel(new ImageIcon(scaledImage));

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.setOpaque(false);
        rightPanel.add(userIconLabel);

        scoreLabel = new JLabel("0 Points");
        scoreLabel.setForeground(Color.WHITE);
        rightPanel.add(scoreLabel);

        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        timerLabel = new JLabel("Time " + timeLeft + " seconds");
        centerPanel.add(timerLabel);

        JPanel lifesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lifesPanel.setOpaque(false);
        lifesPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
        lifes = new JLabel[lifesLeft];

        for (int i = 0; i < lifesLeft; i++) {
            ImageIcon heartIcon = new ImageIcon("src/Img/Vida.png");
            Image scaledHeart = heartIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            lifes[i] = new JLabel(new ImageIcon(scaledHeart));
            lifesPanel.add(lifes[i]);
        }

        centerPanel.add(lifesPanel);

        headerPanel.add(leftPanel, BorderLayout.WEST);
        headerPanel.add(rightPanel, BorderLayout.EAST);
        headerPanel.add(centerPanel, BorderLayout.CENTER);

        JPanel contentPanel = new JPanel(null);
        contentPanel.setBackground(Color.WHITE);
        contentPanel.add(maze.getMazePanel());

        JPanel mazePanel = maze.getMazePanel();
        mazePanel.setBounds(10,10,765,429);
        contentPanel.add(mazePanel);

        gamePanel.add(headerPanel, BorderLayout.NORTH);
        gamePanel.add(contentPanel, BorderLayout.CENTER);

        SwingUtilities.invokeLater(() -> mazePanel.requestFocusInWindow());

    }

    public void updateLives(int livesRemaining) {
        for (int i = 0; i < lifes.length; i++) {
            lifes[i].setVisible(i < livesRemaining);
        }
    }

    public void updateScore(int newScore) {
        scoreLabel.setText("Points: " + newScore);
    }

    public void gainLife() {
        if (lifesLeft < 3) {
            lifesLeft++;
            lifes[lifesLeft - 1].setVisible(true); // Muestra la vida restaurada
        }
    }

    public void startCountdown(Runnable onTimeout, Runnable onWin) {

        this.onWin = onWin;

        maze.setOnWin(() -> {
            stopCountdown(); // Detener el tiempo
            onWin.run();     // Ejecutar la acción de victoria
        });

        timeLeft = 20;
        timerLabel.setText("Time: " + timeLeft + "s");

        if (time != null) {
            time.stop();
        }

        time = new Timer(1000, e -> {
            timeLeft--;
            timerLabel.setText("Time: " + timeLeft + "s");

            if (timeLeft <= 0) {
                time.stop();
                onTimeout.run();
            }
        });

        time.start();
    }

    public void stopCountdown() {
        if (time != null) {
            time.stop();
        }
    }

    public JPanel getGamePanel() {
        return gamePanel;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public Runnable getOnWin() {
        return onWin;
    }
}