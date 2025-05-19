package Forms;

import javax.swing.*;
import java.awt.*;

public class InstrucctionsWindow extends JFrame {

    public InstrucctionsWindow(Runnable onComplete) {
        setTitle("Instructions");
        setSize(500, 300);
        setLocationRelativeTo(null); // Centrar ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(contentPanel);

        JLabel titleLabel = new JLabel("Instructions");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        contentPanel.add(titleLabel);

        contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JTextArea instructions = new JTextArea(
                "- If you don't finish the maze in time, you lose a life.\n" + "\n" +
                        "- There are 7 star types. Stars 1–6 give points; star 7 gives a life.\n" + "\n" +
                        "- If you lose all lives, you restart from level one.\n" + "\n" +
                        "- Your progress, points, losses, and global ranking are saved.\n"
        );
        instructions.setEditable(false);
        instructions.setFocusable(false);
        instructions.setBackground(contentPanel.getBackground());
        instructions.setLineWrap(true);
        instructions.setWrapStyleWord(true);
        contentPanel.add(instructions);

        contentPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel readyLabel = new JLabel("Are you ready?");
        readyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(readyLabel);

        // Temporizador para cerrar ventana y ejecutar callback
        Timer timer = new Timer(5000, e -> {
            dispose();       // Cierra esta ventana
            onComplete.run(); // Ejecuta lo que sigue (ir al juego)
        });
        timer.setRepeats(false);
        timer.start();

        setVisible(true);
    }
}

