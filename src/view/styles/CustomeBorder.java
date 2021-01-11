package view.styles;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CustomeBorder extends AbstractBorder {
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y,
                            int width, int height) {
        super.paintBorder(c, g, x, y, width, height);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setStroke(new BasicStroke(12));
        g2d.setColor(Color.BLACK);
        g2d.drawRoundRect(x, y, width - 1, height - 1, 25, 25);
    }

    public CompoundBorder getCompoundBorder() {
        return BorderFactory.createCompoundBorder(
                new CustomeBorder(),
                new EmptyBorder(new Insets(15, 25, 15, 25)));
    }
}
