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
    public abstract void draw(Graphics2D g2d);

    public double getxStart() {
        return xStart;
    }

    public double getyStart() {
        return yStart;
    }

    public String getColor() {
        return color;
    }

    public void setColor(Graphics2D g2d) {
        //Color Constants: Color.
        //blue/cyan/dark_gray/gray/green/light_gray/magenta/orange/pink/red/white/yellow
        switch (this.getColor())
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
        }
    }
}
