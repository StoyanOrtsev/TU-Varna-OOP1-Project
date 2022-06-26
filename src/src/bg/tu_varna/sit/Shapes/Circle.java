package bg.tu_varna.sit.Shapes;

import java.awt.*;
import java.awt.geom.*;

public class Circle extends Figure {

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
    public void draw(Graphics2D g2d)
    {
        Ellipse2D.Double circle = new Ellipse2D.Double(super.getxStart(),super.getyStart(),this.getWidthSize(),this.getHeightSize());
        super.setColor(g2d);
        g2d.fill(circle);
    }
}
