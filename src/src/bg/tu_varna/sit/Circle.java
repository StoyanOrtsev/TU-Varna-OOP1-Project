package bg.tu_varna.sit;

import java.awt.Shape;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends Shape {

    private double size;

    public Circle(String color, double xStart, double yStart, double size) {
        super(color,xStart,yStart);
        this.size = size;
    }

    @Override
    public void draw(Graphics2D g2d)
    {
        Ellipse2D.Double e = new Ellipse2D.Double(super.getxStart(),super.getyStart(),size,size);
        if(super.getColor() == "black")
            g2d.setColor(Color.BLACK);
        g2d.fill(e);
    }
}
