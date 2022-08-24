package bg.tu_varna.sit.Shapes;

public class Circle extends Shape {

    private double widthSize;
    private double heightSize;

    public Circle(String color, double xStart, double yStart, double widthSize, double heightSize) {
        super(color,xStart,yStart);
        this.widthSize = widthSize;
        this.heightSize = heightSize;
    }

    public double getWidthSize() {
        return widthSize;
    }

    public double getHeightSize() {
        return heightSize;
    }

    @Override
    public String toString() {
        return "Circle ->  " + super.toString() + " " + this.getWidthSize() + " " + this.getHeightSize();
    }
}
