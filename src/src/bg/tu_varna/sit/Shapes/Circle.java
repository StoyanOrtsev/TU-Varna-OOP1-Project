package bg.tu_varna.sit.Shapes;

public class Circle extends Shape {

    private int size;

    public Circle(String color, int xStart, int yStart, int size) {
        super(color,xStart,yStart);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Circle ->  " + super.toString() + " " + size;
    }
}
