package bg.tu_varna.sit;

import javax.swing.*;
import java.awt.*;

public abstract class Shape extends JComponent {

    private double xStart;
    private double yStart;
    private String color;//if -> color._

    public Shape(String color, double xStart, double yStart) {
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
