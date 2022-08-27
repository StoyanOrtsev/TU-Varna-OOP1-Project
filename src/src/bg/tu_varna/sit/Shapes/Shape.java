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

    public void setxStart(double xStart) {
        this.xStart = xStart;
    }

    public double getyStart() {
        return yStart;
    }

    public void setyStart(double yStart) {
        this.yStart = yStart;
    }

    public String getColor() {
        return color;
    }

    public void translate(double newX, double newY){
        setxStart(getxStart() + newX);
        setyStart(getyStart() + newY);
    }

    @Override
    public String toString() {
        return "Color: " + color + " " + xStart + " " + yStart;
    }
}
