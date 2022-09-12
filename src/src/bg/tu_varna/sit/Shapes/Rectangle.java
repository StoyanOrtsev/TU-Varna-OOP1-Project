package bg.tu_varna.sit.Shapes;

public class Rectangle extends Shape {

    private int width;
    private int height;

    public Rectangle( String color, int xStart, int yStart, int width, int height) {
        super(color,xStart,yStart);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Rectangle -> " + super.toString() + " " + width + " " + height;
    }
}
