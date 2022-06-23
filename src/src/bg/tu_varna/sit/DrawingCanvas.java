package bg.tu_varna.sit;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawingCanvas extends JComponent {

    private int width;
    private int height;

    private static final ArrayList<Figure> shapes = new ArrayList<>();

    private Rectangle r1;
    private Circle circle1;
    private Line l1;

    public DrawingCanvas(int w, int h)
    {
        width = w;
        height = h;
        r1 = new Rectangle("orange",50,75,100,250);//R,G,B(RGB channels) - RED|GREEN|BLUE 0-255
        shapes.add(r1);
        circle1 = new Circle("blue",200,75,100);
        shapes.add(circle1);
        l1 = new Line("red",100,250,300,75);//switch for the colors
        shapes.add(l1);
    }

    //functions: print, create, erase <n>, translate <n>/ translate, within <option>
    //within <option> = print with instanceof

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        //print arrayList
        for(Figure current : shapes)
            current.draw(g2d);
    }
}
