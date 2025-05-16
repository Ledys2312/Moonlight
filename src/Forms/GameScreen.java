package Forms;

import javax.swing.*;
import java.awt.*;

public class GameScreen {

    private JPanel gamePanel;
    private JButton backButton;

    public GameScreen(Maze maze) {
        gamePanel = new JPanel(new BorderLayout());

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

        // Imagen usuario
        ImageIcon icon = new ImageIcon("src/Img/avatar.png");
        Image scaledImage = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        JLabel userIconLabel = new JLabel(new ImageIcon(scaledImage));

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.setOpaque(false);
        rightPanel.add(userIconLabel);

        // Agregar paneles al header
        headerPanel.add(leftPanel, BorderLayout.WEST);
        headerPanel.add(rightPanel, BorderLayout.EAST);

        // Content panel
        JPanel contentPanel = new JPanel(null);
        contentPanel.setBackground(Color.WHITE);
        contentPanel.add(maze.getMazePanel()); // <-- Aquí insertamos el laberinto

        gamePanel.add(headerPanel, BorderLayout.NORTH);
        gamePanel.add(contentPanel, BorderLayout.CENTER);
    }


    public JPanel getGamePanel() {
        return gamePanel;
    }

    public JButton getBackButton() {
        return backButton;
    }
}

