package models;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private final List<Entity> entities = new ArrayList<>();

    public Model() {
        entities.add(new BacteriaEntity());
        entities.add(new FieldEntity(1000, 1000, 10));
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void update(){
        for (Entity entity : entities) {
            entity.update();
        }
    }

    public void setTargetPosition(Point point) {
        for (Entity entity : entities) {
            if ( entity instanceof BacteriaEntity bacteria) {
                bacteria.setTarget(point);
            }
        }
    }
}
