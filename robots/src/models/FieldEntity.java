package models;

public class FieldEntity implements Entity{
    private int width;
    private int height;
    private float cellSide;

    public FieldEntity(int width, int height, float cellSide){
        this.width = width;
        this.height = height;
        this.cellSide = cellSide;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getCellSide() {
        return cellSide;
    }

    public int getCellCenter(int x){
        int icellSide = Math.round(cellSide);
        int target = x/icellSide;
        int cellCenter = target*icellSide + icellSide/2;
        return cellCenter;
    }

    @Override
    public void update() {}
}
