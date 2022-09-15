package bg.tu_varna.sit.Shapes;

public class Circle extends Shape {

    private int radius;

    public Circle(String color, int xStart, int yStart, int radius) {
        super(color,xStart,yStart);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Circle -> " + super.toString() + " " + radius;
    }
}
