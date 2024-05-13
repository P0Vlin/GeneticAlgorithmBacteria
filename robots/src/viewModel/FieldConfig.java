package viewModel;

import models.FieldEntity;

public class FieldConfig {
    private int width;
    private int height;
    private float cellSide;

    public FieldConfig(){
        this.width = 1000;
        this.height = 1000;
        this.cellSide = 100;
    }

    public FieldConfig(int width, int height, float cellSide){
        this.width = width;
        this.height = height;
        this.cellSide = cellSide;
    }

    public void setWidth(int width){
        this.width = width;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public void setCellSide(int linescount){
        this.cellSide = cellSide;
    }
    public FieldEntity cloneField(){
        return new FieldEntity(width, height, cellSide);
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public float getCellSide(){
        return cellSide;
    }
}