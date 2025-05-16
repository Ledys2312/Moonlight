package Forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Maze {

     private JPanel mazePanel;
     private int[][] maze;
     private int playerX = 1;
     private int playerY = 1;
     private final int sizeCell = 40;
     private final int exitX = 10;
     private final int exitY = 10;


    public Maze(int[][] maze) {
        this.maze = maze;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar el laberinto
        for (int fila = 0; fila < laberinto.length; fila++) {
            for (int col = 0; col < laberinto[0].length; col++) {
                if (laberinto[fila][col] == 1) {
                    g.setColor(Color.BLACK);  // Pared
                } else {
                    g.setColor(Color.WHITE);  // Camino
                }
                g.fillRect(col * tamañoCelda, fila * tamañoCelda, tamañoCelda, tamañoCelda);
                g.setColor(Color.GRAY);
                g.drawRect(col * tamañoCelda, fila * tamañoCelda, tamañoCelda, tamañoCelda);
            }
        }

        // Dibujar salida
        g.setColor(Color.GREEN);
        g.fillRect(salidaX * tamañoCelda, salidaY * tamañoCelda, tamañoCelda, tamañoCelda);

        // Dibujar jugador
        g.setColor(Color.RED);
        g.fillOval(jugadorX * tamañoCelda + 5, jugadorY * tamañoCelda + 5,
                tamañoCelda - 10, tamañoCelda - 10);
    }

    public Maze() {

        mazePanel = new JPanel(null);
        mazePanel.setSize(765,430);
        mazePanel.setBackground(Color.RED);

        mazePanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                mazePanel.moverJugador(e.getKeyCode());
            }
        });
    }

    public void movePlayer(int Key) {
        int newX = playerX;
        int newY = playerY;

        switch (Key) {
            case KeyEvent.VK_UP:
                newY--;
                break;
            case KeyEvent.VK_DOWN:
                newY++;
                break;
            case KeyEvent.VK_LEFT:
                newX--;
                break;
            case KeyEvent.VK_RIGHT:
                newX++;
                break;
        }

        if (maze[newX][newY] == 0) {
            playerX = newX;
            playerY = newY;

            if (playerX == exitX && playerY == exitY) {
                JOptionPane.showMessageDialog(this, "¡Felicidades! Has ganado el laberinto.");
            }
        }
    }

    public JPanel getMazePanel() {
        return mazePanel;
    }

    public void setMazePanel(JPanel mazePanel) {
        this.mazePanel = mazePanel;
    }

    public int[][] getMaze() {
        return maze;
    }

    public void setMaze(int[][] maze) {
        this.maze = maze;
    }

    public int getPlayerY() {
        return playerY;
    }

    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    }

    public int getPlayerX() {
        return playerX;
    }

    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }

    public int getSizeCell() {
        return sizeCell;
    }

    public int getExitX() {
        return exitX;
    }

    public int getExitY() {
        return exitY;
    }
}

import javax.swing.*;
        import java.awt.*;
        import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;

//public class GatitoMoviendose {
//
//    private static int x = 50; // Posición inicial X del gatito
//    private static int y = 50; // Posición inicial Y del gatito
//    private static int spriteIndex = 0;  // Índice para cambiar el sprite
//    private static boolean mirandoIzquierda = false; // Para saber si el gato está mirando hacia la izquierda
//
//    public static void main(String[] args) {
//        // Crear la ventana principal
//        JFrame ventana = new JFrame("Gatito Moviéndose");
//        ventana.setSize(6500, 6500); // Tamaño de la ventana
//        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        ventana.setLayout(null);
//
//        // Crear el panel que simula los salones
//        JPanel panelSalones = new JPanel();
//        panelSalones.setBounds(0, 0, 6500, 6500);
//        panelSalones.setLayout(null);
//        ventana.add(panelSalones);
//
//        // Crear el gatito (usamos un sprite para el gato que camina)
//        JLabel gatito = new JLabel();
//
//        // Cargar las imágenes para el sprite
//        ImageIcon[] sprites = {
//                new ImageIcon("src/gato/1-removebg-preview.png"),  // Imagen de la primera fase del movimiento
//                new ImageIcon("src/gato/2-removebg-preview.png"),  // Imagen de la segunda fase
//                new ImageIcon("src/gato/3-removebg-preview.png"),
//                new ImageIcon("src/gato/4-removebg-preview.png"),
//                new ImageIcon("src/gato/5-removebg-preview.png"),
//                new ImageIcon("src/gato/6-removebg-preview.png")  // Imagen de la tercera fase
//        };
//
//        // Redimensionar las imágenes
//        for (int i = 0; i < sprites.length; i++) {
//            Image img = sprites[i].getImage();  // Convertir la imagen a un objeto Image
//            Image newImg = img.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // Redimensionar la imagen
//            sprites[i] = new ImageIcon(newImg);  // Asignar la nueva imagen redimensionada
//        }
//
//        // Configurar el sprite inicial (la primera imagen)
//        gatito.setIcon(sprites[0]);
//        gatito.setBounds(x, y, 50, 50); // Posición inicial y tamaño del gatito
//        panelSalones.add(gatito);
//
//        // Crear un temporizador para cambiar la imagen del gatito
//        Timer timer = new Timer(100, e -> {
//            // Cambiar la imagen del gato para simular que camina
//            spriteIndex = (spriteIndex + 1) % sprites.length;  // Cambiar el índice de la imagen
//            gatito.setIcon(sprites[spriteIndex]);  // Actualizar la imagen
//
//            // Si el gato está mirando a la izquierda, reflejamos la imagen
//            if (mirandoIzquierda) {
//                ImageIcon currentIcon = (ImageIcon) gatito.getIcon();
//                Image img = currentIcon.getImage();
//                Image flippedImg = flipImage(img);  // Reflejar la imagen horizontalmente
//                gatito.setIcon(new ImageIcon(flippedImg));  // Asignar la imagen reflejada
//            }
//
//            // Actualizar la posición del gatito
//            gatito.setBounds(x, y, 50, 50);
//        });
//
//        timer.start();  // Inicia el temporizador para animar al gatito
//
//        // Añadir un KeyListener para detectar las teclas presionadas
//        ventana.addKeyListener(new KeyListener() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                // No utilizamos esta función en este caso
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//                int code = e.getKeyCode(); // Obtener el código de la tecla presionada
//
//                // Mover el gatito en función de la tecla presionada
//                switch (code) {
//                    case KeyEvent.VK_UP:  // Flecha arriba
//                        y -= 10;  // Mover hacia arriba
//                        break;
//                    case KeyEvent.VK_DOWN:  // Flecha abajo
//                        y += 10;  // Mover hacia abajo
//                        break;
//                    case KeyEvent.VK_LEFT:  // Flecha izquierda
//                        x -= 10;  // Mover hacia la izquierda
//                        mirandoIzquierda = true;  // Marcar que el gato mira a la izquierda
//                        break;
//                    case KeyEvent.VK_RIGHT:  // Flecha derecha
//                        x += 10;  // Mover hacia la derecha
//                        mirandoIzquierda = false;  // Marcar que el gato mira a la derecha
//                        break;
//                }
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//                // No utilizamos esta función en este caso
//            }
//        });
//
//        ventana.setVisible(true);  // Hacer visible la ventana
//        ventana.setFocusable(true);  // Asegurarse de que la ventana pueda recibir eventos de teclado
//    }
//
//    // Método para reflejar la imagen horizontalmente usando BufferedImage y Graphics2D
//    private static Image flipImage(Image img) {
//        int width = img.getWidth(null);
//        int height = img.getHeight(null);
//
//        // Crear un BufferedImage para manipular la imagen
//        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
//        Graphics2D g2d = bufferedImage.createGraphics();
//
//        // Reflejar la imagen horizontalmente
//        AffineTransform transform = AffineTransform.getScaleInstance(-1, 1);
//        transform.translate(-width, 0);  // Mover la imagen reflejada al lugar correcto
//
//        // Aplicar la transformación de reflejo
//        g2d.drawImage(img, transform, null);
//        g2d.dispose();
//
//        return bufferedImage;  // Devolver la imagen reflejada
//    }
//}
//
//
//                /*new ImageIcon("src/gato/1-removebg-preview.png"),  // Imagen de la primera fase del movimiento
//                new ImageIcon("src/gato/2-removebg-preview.png"),  // Imagen de la segunda fase
//                new ImageIcon("src/gato/3-removebg-preview.png"),
//                new ImageIcon("src/gato/4-removebg-preview.png"),
//                new ImageIcon("src/gato/5-removebg-preview.png"),
//                new ImageIcon("src/gato/6-removebg-preview.png") */