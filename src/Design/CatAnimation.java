package Design;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CatAnimation {

    private JLabel catLabel;
    private Timer frameTimer;
    private Timer moveTimer;
    private List<ImageIcon> frames;
    private int frameIndex = 0;
    private int xPos = 0;
    private int speed = 2;
    private JLabel shadow;

    public CatAnimation(JPanel panel, int startX, int y, int width, int height) {
        // Cargar frames del gato
        frames = loadFrames("Img/Cat/", "Gato", 3);
        if (frames.isEmpty()) {
            System.err.println("❌ No se pudieron cargar los sprites del gato.");
            return;
        }

        // Agregar piso como imagen
        addFloor(panel);

        // Crear JLabel del gato
        catLabel = new JLabel(frames.get(0));
        xPos = startX;
        catLabel.setBounds(xPos, y, width, height);
        panel.add(catLabel);
        panel.setComponentZOrder(catLabel, 0); // Asegura que esté al frente
        panel.revalidate();
        panel.repaint();

        // Timer para cambiar frames
        frameTimer = new Timer(100, e -> {
            frameIndex = (frameIndex + 1) % frames.size();
            catLabel.setIcon(frames.get(frameIndex));
        });
        frameTimer.start();

        // Timer para mover el gato
        moveTimer = new Timer(20, e -> {
            xPos += speed;
            if (xPos > panel.getWidth()) {
                xPos = -catLabel.getWidth(); // sale y vuelve por la izquierda
            }
            catLabel.setLocation(xPos, y);
        });
        moveTimer.start();
    }

    private void addFloor(JPanel panel) {
        JLabel floorLabel = new JLabel();
        java.net.URL floorURL = getClass().getClassLoader().getResource("Img/Floor.png");
        if (floorURL != null) {
            ImageIcon floorIcon = new ImageIcon(floorURL);
            Image scaled = floorIcon.getImage().getScaledInstance(800, 50, Image.SCALE_SMOOTH);
            floorLabel.setIcon(new ImageIcon(scaled));
            floorLabel.setBounds(0, 453, 800, 70); // parte inferior del frame
            panel.add(floorLabel);
            panel.setComponentZOrder(floorLabel, 0); // debajo del gato
        } else {
            System.err.println("No se encontró la imagen del piso: Img/floor.png");
        }
    }

    private List<ImageIcon> loadFrames(String folderPath, String baseName, int count) {
        List<ImageIcon> icons = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            String path = folderPath + baseName + i + ".png";
            java.net.URL imgURL = getClass().getClassLoader().getResource(path);
            if (imgURL != null) {
                ImageIcon rawIcon = new ImageIcon(imgURL);
                Image scaledImage = rawIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                icons.add(new ImageIcon(scaledImage));
            } else {
                System.err.println("No se encontró: " + path);
            }
        }
        return icons;
    }
}
