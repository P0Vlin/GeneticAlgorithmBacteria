package view;

import models.BacteriaEntity;
import models.Entity;
import models.FieldEntity;
import models.Model;

import java.awt.*;
import java.util.Map;

public class View {
    private final Model model;
    private final Map<Class<?>, Renderer<? extends Entity>> renderersByType = Map.of(
            BacteriaEntity.class, new BacteriaRenderer(),
            FieldEntity.class, new FieldRenderer()
            );

    public View(Model model) {
        this.model = model;
    }

    public void paint(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        for (Entity entity : model.getEntities()) {
            Renderer<Entity> renderer = (Renderer<Entity>)renderersByType.get(entity.getClass());
            renderer.render(entity, graphics2D);
        }
    }
}