package bg.tu_varna.sit.Shapes;

public class Rectangle extends Shape {

    private double width;
    private double height;

    public Rectangle( String color, double xStart, double yStart, double width, double height) {
        super(color,xStart,yStart);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Rectangle -> " + super.toString() + " " + width + " " + height;
    }
}
