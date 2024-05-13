package view;

import models.BacteriaEntity;
import models.FieldEntity;
import models.Model;
import viewModel.FieldConfig;

import java.awt.*;

public class BacteriaRenderer implements Renderer<BacteriaEntity> {
    private Model model = new Model();
    private FieldEntity field = model.getField();
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

    private static void fillRect(Graphics g, int centerX, int centerY, int width,int height){
        int x = centerX - width/2;
        int y = centerY - height /2;
        g.fillRect(x,y,width,height);
    }
    private static void drawRect(Graphics g, int centerX, int centerY, int width,int height){
        int x = centerX - width/2;
        int y = centerY - height /2;
        g.drawRect(x,y,width,height);
    }
    private void drawBacteria(Graphics2D g, BacteriaEntity bacteria) //view
    {
        int robotCenterX = round(bacteria.getBacteriaCoords().x);
        int robotCenterY = round(bacteria.getBacteriaCoords().y);
        //AffineTransform t = AffineTransform.getRotateInstance(bacteria.getBacteriaDirection(), robotCenterX, robotCenterY);
        //g.setTransform(t);
        int cellSide = Math.round(field.getCellSide());
        g.setColor(Color.BLUE);
        fillRect(g, robotCenterX, robotCenterY, cellSide, cellSide);
        g.setColor(Color.BLACK);
        drawRect(g, robotCenterX, robotCenterY, cellSide, cellSide);
    }
}
