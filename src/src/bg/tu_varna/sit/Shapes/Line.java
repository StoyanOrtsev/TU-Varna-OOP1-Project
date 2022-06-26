package bg.tu_varna.sit.Shapes;

import java.awt.*;
import java.awt.geom.Line2D;

public class Line extends Figure {

    private double xEnd;
    private double yEnd;

    public Line(String color, double xStart, double yStart, double xEnd, double yEnd) {
        super(color,xStart,yStart);
        this.xEnd = xEnd;
        this.yEnd = yEnd;
    }

    @Override
    public void draw(Graphics2D g2d)
    {
        Line2D.Double line = new Line2D.Double(super.getxStart(),super.getyStart(),xEnd,yEnd);
        super.setColor(g2d);
        g2d.draw(line);
    }
}
