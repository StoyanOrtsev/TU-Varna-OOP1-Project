package bg.tu_varna.sit.Shapes;

import java.io.Serializable;

public abstract class Shape implements Serializable {

    private String color;
    private double xStart;
    private double yStart;

    public Shape(String color, double xStart, double yStart) {
        this.color = color;
        this.xStart = xStart;
        this.yStart = yStart;
    }

    public double getxStart() {
        return xStart;
    }

    public double getyStart() {
        return yStart;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Color: " + color + " " + xStart + " " + yStart;
    }
}
