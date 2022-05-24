package bg.tu_varna.sit;

import java.awt.Shape;
import java.awt.*;
import java.awt.geom.Line2D;

public class Line extends Shape {

    private int xEnd;
    private int yEnd;

    public Line(String color, double xStart, double yStart, int xEnd, int yEnd) {
        super(color,xStart,yStart);
        this.xEnd = xEnd;
        this.yEnd = yEnd;
    }

    @Override
    public void draw(Graphics2D g2d)
    {
        Line2D.Double line = new Line2D.Double(super.getxStart(),super.getyStart(),xEnd,yEnd);
        if(super.getColor() == "black")
            g2d.setColor(Color.BLACK);
        g2d.draw(line);
    }
}
