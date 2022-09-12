package bg.tu_varna.sit.Shapes;

import java.io.Serializable;

public abstract class Shape implements Serializable {

    private String color;
    private int xStart;
    private int yStart;

    public Shape(String color, int xStart, int yStart) {
        this.color = color;
        this.xStart = xStart;
        this.yStart = yStart;
    }

    public int getxStart() {
        return xStart;
    }

    public void setxStart(int xStart) {
        this.xStart = xStart;
    }

    public int getyStart() {
        return yStart;
    }

    public void setyStart(int yStart) {
        this.yStart = yStart;
    }

    public String getColor() {
        return color;
    }

    public void translate(int horizontal, int vertical){
        setxStart(getxStart() + horizontal);
        setyStart(getyStart() + vertical);
    }

    @Override
    public String toString() {
        return "Color: " + color + " " + xStart + " " + yStart;
    }
}
