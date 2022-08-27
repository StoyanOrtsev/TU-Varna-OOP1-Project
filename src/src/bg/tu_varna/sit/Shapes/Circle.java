package bg.tu_varna.sit.Shapes;

public class Circle extends Shape {

    private double size;

    public Circle(String color, double xStart, double yStart, double size) {
        super(color,xStart,yStart);
        this.size = size;
    }

    public double getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Circle ->  " + super.toString() + " " + size;
    }
}
