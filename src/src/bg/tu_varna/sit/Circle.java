package bg.tu_varna.sit;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends Figure {

    private double size;

    public Circle(String color, double xStart, double yStart, double size) {
        super(color,xStart,yStart);
        this.size = size;
    }

    @Override
    public void draw(Graphics2D g2d)
    {
        Ellipse2D.Double e = new Ellipse2D.Double(super.getxStart(),super.getyStart(),size,size);
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
        g2d.fill(e);
    }
}
