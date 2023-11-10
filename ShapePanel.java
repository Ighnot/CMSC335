import com.intellij.ui.JBColor;

import javax.swing.*;
import java.awt.*;

public class ShapePanel extends JPanel {
    private Shape shape;
    private Color color;

    public ShapePanel(Shape shape) {
        this.shape = shape;
        this.color = getRandomColor();
        setPreferredSize(new Dimension(500, 500));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        // g2d.fill(Shape);
    }

    private Color getRandomColor() {
        return new JBColor(
                new Color((int) (Math.random() * 256),
                        (int) (Math.random() * 256),
                        (int) (Math.random() * 256)),
                JBColor.BLACK  // Default color in case JBColor is not available
        );
    }
}