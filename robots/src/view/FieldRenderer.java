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
        float cellSide = field.getCellSide();
        int icellSide = Math.round(cellSide);
        for (int i = 1; i <= field.getWidth()/icellSide; i++) {
            g.drawLine(i * icellSide, 0, i * icellSide, field.getHeight());
            g.drawLine(0, i * icellSide, field.getWidth(), i * icellSide);
        }
    }
}
