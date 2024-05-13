package models;
import models.Model;

import java.awt.*;

public class ModelContext {
    private Model model;
    enum Directions{
        NORTH, NORTH_EAST, EAST, SOUTH_EAST, SOUTH, SOUTH_WEST, WEST, NORTH_WEST
    }
    FieldEntity field = model.getField();
    private void Move(BacteriaEntity entity, Directions direction){
        Point coords = entity.getBacteriaCoords();
        switch(direction){
            case NORTH: coords.setLocation(coords.x,coords.y+field.getCellSide());
            entity.setBacteriaPosition(coords);

            case NORTH_EAST: coords.setLocation(coords.x+field.getCellSide(),coords.y+field.getCellSide());
            entity.setBacteriaPosition(coords);

            case EAST: coords.setLocation(coords.x+field.getCellSide(),coords.y);
            entity.setBacteriaPosition(coords);

            case SOUTH_EAST: coords.setLocation(coords.x+field.getCellSide(),coords.y-field.getCellSide());
            entity.setBacteriaPosition(coords);

            case SOUTH: coords.setLocation(coords.x,coords.y-field.getCellSide());
            entity.setBacteriaPosition(coords);

            case SOUTH_WEST: coords.setLocation(coords.x-field.getCellSide(),coords.y-field.getCellSide());
            entity.setBacteriaPosition(coords);

            case WEST: coords.setLocation(coords.x-field.getCellSide(),coords.y);
            entity.setBacteriaPosition(coords);

            case NORTH_WEST: coords.setLocation(coords.x-field.getCellSide(),coords.y+field.getCellSide());
                entity.setBacteriaPosition(coords);
        }
    }

}
