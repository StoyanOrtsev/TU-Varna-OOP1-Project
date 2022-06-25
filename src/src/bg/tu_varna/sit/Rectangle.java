package bg.tu_varna.sit;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Rectangle extends Figure {

    private double width;
    private double height;

    public Rectangle( String color, double xStart, double yStart, double width, double height) {
        super(color,xStart,yStart);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics2D g2d)
    {
        Rectangle2D r = new Rectangle2D.Double(super.getxStart(),super.getyStart(),width,height);//x,y,w,h
        //Color Constants:
        //black/blue/cyan/dark_gray/gray/green/light_gray/magenta/orange/pink/red/white/yellow
        switch (super.getColor())
        {
            case "black":g2d.setColor(Color.BLACK);break;
            case "blue":g2d.setColor(Color.BLUE);break;
            case "cyan":g2d.setColor(Color.CYAN);break;
            case "dark_gray":g2d.setColor(Color.DARK_GRAY);break;
            case "gray":g2d.setColor(Color.GRAY);break;
            case "green":g2d.setColor(Color.GREEN);break;
            case "light_gray":g2d.setColor(Color.LIGHT_GRAY);break;
            case "magenta":g2d.setColor(Color.MAGENTA);break;
            case "orange":g2d.setColor(Color.ORANGE);break;
            case "pink":g2d.setColor(Color.PINK);break;
            case "red":g2d.setColor(Color.RED);break;
            case "white":g2d.setColor(Color.WHITE);break;
            case "yellow":g2d.setColor(Color.YELLOW);break;
            default:
                System.out.println("Invalid color!"); break;
        }
        g2d.fill(r);
    }
}
