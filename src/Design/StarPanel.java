package Design;

import Objects.Star;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class StarPanel extends JPanel {

    private final ArrayList<Star> stars = new ArrayList<>();
    private final Timer timer;
    private final Image starImage;
    private final Random random = new Random();

    public StarPanel() {
        // Cargar imagen de estrella
        starImage = new ImageIcon(getClass().getResource("/Img/Star.png")).getImage(); // usa tu propia ruta

        // Timer para animar
        timer = new Timer(30, e -> {
            updateStars();
            repaint();
        });
        timer.start();
    }

    private void updateStars() {
        // Añadir nuevas estrellas
        if (random.nextInt(10) < 2) { // Probabilidad de crear
            stars.add(new Star(random.nextInt(getWidth()), 0, 2 + random.nextInt(3), starImage));
        }

        // Actualizar y eliminar estrellas fuera de la pantalla
        stars.removeIf(star -> {
            star.update();
            return star.y > getHeight();
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Star star : stars) {
            g.drawImage(star.image, star.x, star.y, 20, 20, null); // Ajusta tamaño si quieres
        }
    }
}
