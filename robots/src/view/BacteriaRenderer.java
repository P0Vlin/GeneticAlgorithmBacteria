package view;

import models.BacteriaEntity;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class BacteriaRenderer implements Renderer<BacteriaEntity> {
    @Override
    public void render(BacteriaEntity bacteria, Graphics2D graphics) {
        drawBacteria(graphics, bacteria);
    }

    private static int round(double value)
    {
        return (int)(value + 0.5);
    }

    private static void drawOval(Graphics g, int centerX, int centerY, int diam1, int diam2) //?view
    {
        g.drawOval(centerX - diam1 / 2, centerY - diam2 / 2, diam1, diam2);
    }
    private static void fillOval(Graphics g, int centerX, int centerY, int diam1, int diam2) //?view
    {
        g.fillOval(centerX - diam1 / 2, centerY - diam2 / 2, diam1, diam2);
    }
    private void drawBacteria(Graphics2D g, BacteriaEntity bacteria) //view
    {
        int robotCenterX = round(bacteria.getBacteriaPositionX());
        int robotCenterY = round(bacteria.getBacteriaPositionY());
        AffineTransform t = AffineTransform.getRotateInstance(bacteria.getBacteriaDirection(), robotCenterX, robotCenterY);
        g.setTransform(t);
        g.setColor(Color.MAGENTA);
        fillOval(g, robotCenterX, robotCenterY, 30, 10);
        g.setColor(Color.BLACK);
        drawOval(g, robotCenterX, robotCenterY, 30, 10);
        g.setColor(Color.WHITE);
        fillOval(g, robotCenterX  + 10, robotCenterY, 5, 5);
        g.setColor(Color.BLACK);
        drawOval(g, robotCenterX  + 10, robotCenterY, 5, 5);
    }
}
