package bg.tu_varna.sit.Shapes;

public class Line extends Shape {

    private double xEnd;
    private double yEnd;

    public Line(String color, double xStart, double yStart, double xEnd, double yEnd) {
        super(color,xStart,yStart);
        this.xEnd = xEnd;
        this.yEnd = yEnd;
    }

    public double getxEnd() {
        return xEnd;
    }

    public double getyEnd() {
        return yEnd;
    }

    @Override
    public String toString() {
        return "Line -> " + super.toString() + " " + this.getxEnd() + " " + this.getyEnd();
    }
}
