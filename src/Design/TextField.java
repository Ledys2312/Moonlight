package Design;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TextField extends JTextField {

    private final Color unfocusedLineColor = new Color(122, 92, 134); // violeta claro
    private final Color focusedLineColor = new Color(3, 14, 40);      // azul oscuro

    public TextField(int columns) {
        super(columns);

        // Estilo general
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0)); // transparente
        setForeground(new Color(30, 30, 30)); // color del texto
        setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, unfocusedLineColor));

        // Efecto de línea inferior que cambia al enfocar
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
