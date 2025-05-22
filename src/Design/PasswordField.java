package Design;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import static com.sun.java.accessibility.util.AWTEventMonitor.addFocusListener;
import static javax.swing.text.StyleConstants.setBackground;
import static javax.swing.text.StyleConstants.setForeground;

public class PasswordField extends JPasswordField {

    private final Color unfocusedLineColor = new Color(122, 92, 134); // violeta claro
    private final Color focusedLineColor = new Color(3, 14, 40);      // azul oscuro

    public PasswordField(int columns) {
        super(columns);

        // Estilo visual
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0)); // fondo transparente
        setForeground(new Color(30, 30, 30)); // color del texto
        setEchoChar('•'); // opcional: cambia cómo se ven los caracteres
        setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, unfocusedLineColor));

        // Cambia la línea inferior al enfocar
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, focusedLineColor));
            }

            @Override
            public void focusLost(FocusEvent e) {
                setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, unfocusedLineColor));
            }
        });
    }
}