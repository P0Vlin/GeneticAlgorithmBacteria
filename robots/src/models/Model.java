package models;

import viewModel.FieldConfig;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private final List<Entity> entities = new ArrayList<>();
    private FieldConfig config = new FieldConfig();
    private FieldEntity field = config.cloneField();

    public Model() {
        entities.add(new BacteriaEntity(field));
        entities.add(field);
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
        if (point.x >= field.getWidth() || point.y >= field.getHeight()) {
            return;
        }
        for (Entity entity : entities) {
            if (entity instanceof BacteriaEntity bacteria) {
                bacteria.setTarget(point);
            }
        }
    }

    //TO DO Нужно сделать метод, который будет проверять, есть ли в клетке entity или нет
    // будет использовать в будущем в методе setRandomPosition(BacteriaEntity) как одна из двух проверок
    // там будет 2 проверки, не вышли ли мы за поле и есть ли entity в клетке
   /* public Entity checkCell(int x, int y){
        if (x < field.getWidth() || y < field.getHeight()) {

        }
        else{
            return null;
        }

    }

    */

    public FieldEntity getField(){
        return field;
    }
}
