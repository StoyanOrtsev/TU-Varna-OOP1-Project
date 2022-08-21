package bg.tu_varna.sit.Shapes;

import java.awt.*;
import java.io.Serializable;

public abstract class Figure implements Serializable {

    private String color;
    private double xStart;
    private double yStart;

    public Figure(String color, double xStart, double yStart) {
        this.color = color;
        this.xStart = xStart;
        this.yStart = yStart;
    }
    public abstract void draw();

    public double getxStart() {
        return xStart;
    }

    public double getyStart() {
        return yStart;
    }

    public String getColor() {
        return color;
    }

    //blue/cyan/dark_gray/gray/green/light_gray/magenta/orange/pink/red/white/yellow - colour examples
    public void setColor(String color)
    {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Color: " + this.getColor() + " " + this.getxStart() + " " + this.getyStart();
    }
}
