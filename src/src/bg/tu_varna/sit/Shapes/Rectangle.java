package bg.tu_varna.sit.Shapes;

import java.awt.*;
import java.awt.geom.*;

public class Rectangle extends Figure {

    private double width;
    private double height;

    public Rectangle( String color, double xStart, double yStart, double width, double height) {
        super(color,xStart,yStart);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public void draw(Graphics2D g2d)
    {
        Rectangle2D.Double rectangle = new Rectangle2D.Double(super.getxStart(),super.getyStart(),this.getWidth(),this.getHeight());
        super.setColor(g2d);
        g2d.fill(rectangle);
    }

    @Override
    public String toString() {
        return "Rectangle -> " + super.toString() + " " + this.getWidth() + " " + this.getHeight();
    }
}
