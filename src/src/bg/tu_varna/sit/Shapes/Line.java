package bg.tu_varna.sit.Shapes;

public class Line extends Shape {

    private int xEnd;
    private int yEnd;

    public Line(String color, int xStart, int yStart, int xEnd, int yEnd) {
        super(color,xStart,yStart);
        this.xEnd = xEnd;
        this.yEnd = yEnd;
    }

    public int getxEnd() {
        return xEnd;
    }

    public int getyEnd() {
        return yEnd;
    }

    @Override
    public String toString() {
        return "Line -> " + super.toString() + " " + xEnd + " " + yEnd;
    }
}
