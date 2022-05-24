package bg.tu_varna.sit;

import java.awt.Shape;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Rectangle extends Shape {

    private int width;
    private int height;

    public Rectangle( String color, double xStart, double yStart, int width, int height) {
        super(color,xStart,yStart);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics2D g2d)
    {
        Rectangle2D r = new Rectangle2D.Double(super.getxStart(),super.getyStart(),width,height);//x,y,w,h
        if(super.getColor() == "black")
        g2d.setColor(Color.BLACK);
        //...if else for the other colors
        //Color Constants: Color.
        //black/blue/cyan/dark_gray/gray/green/light_gray/magenta/orange/pink/red/white/yellow - if(string)
        g2d.fill(r);
    }
}
