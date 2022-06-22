package bg.tu_varna.sit;

import java.awt.*;

public abstract class Figure {

    private String color;
    private double xStart;
    private double yStart;

    public Figure(String color, double xStart, double yStart) {
        this.color = color;
        this.xStart = xStart;
        this.yStart = yStart;
    }
    public abstract void draw(Graphics2D g2d);

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
    public void setColor(String color) {
        this.color = color;
    }
}
