package Design;

import javax.swing.*;
import java.awt.*;

public class CustomMessage extends JDialog {

    public CustomMessage(Frame owner, String title, String message, Color bgColor, Color textColor) {
        super(owner, title, true);
        setUndecorated(true); // sin bordes
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(null);

        getContentPane().setBackground(bgColor);

        String htmlMessage = message.replaceAll("\n", "<br>");
        JLabel messageLabel = new JLabel(
                "<html><div style='text-align: center; line-height: 160%;'>" + htmlMessage + "</div></html>",
                SwingConstants.CENTER);
        messageLabel.setBounds(30, 30, 340, 60);
        messageLabel.setForeground(textColor);

        // Botón
        Buttoms Button = new Buttoms("Accept");
        Button.setBounds(120, 120, 150, 35);
        Button.setFocusPainted(false);
        Button.setForeground(new Color(3, 14, 40));
        Button.addActionListener(e -> dispose());

        add(messageLabel);
        add(Button);
    }

    public static void showMessage(Component parent, String title, String message) {
        // Colores personalizados (puedes cambiarlos o hacerlos variables)
        Color bgColor = new Color(65, 93, 67);
        Color textColor = new Color(245,230,232);

        Frame owner = JOptionPane.getFrameForComponent(parent);
        CustomMessage dialog = new CustomMessage(owner, title, message, bgColor, textColor);
        dialog.setVisible(true);
    }
}
