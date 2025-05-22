package Design;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Buttoms extends JButton {
    private Color backgroundColor = new Color(207, 161, 121);
    private Color hoverColor = new Color(193, 145, 104);

    public Buttoms(String text) {
        super(text);
        setForeground(new Color(3, 14, 40));
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);

        // Cambia color al pasar el mouse
        addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                backgroundColor = hoverColor;
                repaint();
            }

            public void mouseExited(MouseEvent evt) {
                backgroundColor = new Color(207, 161, 121);
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibujar botón redondeado
        g2.setColor(backgroundColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);

        super.paintComponent(g);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        // No dibuja borde
    }
}
