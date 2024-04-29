package view;

import models.FieldEntity;

import java.awt.*;

public class FieldRenderer implements Renderer<FieldEntity>{


    @Override
    public void render(FieldEntity field, Graphics2D graphics) {
        drawField(graphics, field);
    }

    private void drawField(Graphics g, FieldEntity field ) {
        g.setColor(Color.BLACK);
        g.drawLine(0, 0, 10, 10);

        int cellWidth = field.getWidth() / field.getlinescount();
        int cellHeight = field.getHeight() / field.getlinescount();
        for (int i = 1; i < field.getlinescount(); i++) {
            g.drawLine(i * cellWidth, 0, i * cellWidth, field.getHeight());
            g.drawLine(0, i * cellHeight, field.getWidth(), i * cellHeight);
        }
    }
}
