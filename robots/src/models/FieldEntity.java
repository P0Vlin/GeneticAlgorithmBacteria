package models;

public class FieldEntity implements Entity{
    private int width;
    private int height;
    private int linescount;

    public FieldEntity(int width, int height, int linescount){
        this.width = width;
        this.height = height;
        this.linescount = linescount;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getlinescount() {
        return linescount;
    }

    @Override
    public void update() {}
}
