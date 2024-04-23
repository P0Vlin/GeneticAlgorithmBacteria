package view;

import models.Entity;

import java.awt.*;

public interface Renderer<T extends Entity> {
    void render(T entity, Graphics2D graphics);
}
