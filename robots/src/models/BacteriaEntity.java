package models;

import viewModel.FieldConfig;

import java.awt.*;
import java.lang.reflect.Field;
import java.util.Random;

public class BacteriaEntity implements Entity {
    private volatile Point bacteriaCoords = new Point(100,100);
    private volatile Point targetCoords = new Point(150,100);
    private volatile int cellCenterX = 100;
    private volatile int cellCenterY = 100;
    private FieldEntity field;
    ModelContext.Directions directions;

    public BacteriaEntity(FieldEntity field) {
        this.field = field;
    }

    public Point getBacteriaCoords(){return bacteriaCoords;}
    public Point getTargetCoords(){return targetCoords;}

    @Override
    public void update() {
        setBacteriaPosition(targetCoords);
        //
    }
     //


    public void setBacteriaPosition(Point point){
        int x = point.x;
        int y = point.y;
        cellCenterX = field.getCellCenter(x);
        cellCenterY = field.getCellCenter(y);
        bacteriaCoords.setLocation(cellCenterX,cellCenterY);
    }
    private ModelContext.Directions setRandomPosition(){
        Random random = new Random();
        ModelContext.Directions[] allDirections = ModelContext.Directions.values();
        int randomIndex = random.nextInt(allDirections.length);
        ModelContext.Directions randomDirection = allDirections[randomIndex];
        return  randomDirection;
    }
    public void setTarget(Point target) {
        targetCoords.setLocation(target);
    }
}
