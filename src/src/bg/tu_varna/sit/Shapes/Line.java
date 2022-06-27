package bg.tu_varna.sit.Shapes;

import java.awt.*;
import java.awt.geom.*;

public class Line extends Figure {

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
    public void draw(Graphics2D g2d)
    {
        Line2D.Double line = new Line2D.Double(super.getxStart(),super.getyStart(),this.getxEnd(),this.getyEnd());
        super.setColor(g2d);
        g2d.draw(line);
    }

    @Override
    public String toString() {
        return "Line -> " + super.toString() + " " + this.getxEnd() + " " + this.getyEnd();
    }
}
