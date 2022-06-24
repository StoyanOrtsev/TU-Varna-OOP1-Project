package bg.tu_varna.sit;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

public class DrawingCanvas extends JComponent {

    private int width;
    private int height;
    private final java.util.List<Figure> shapes;
    private final List<Figure> result;

    private Rectangle r1;
    private Circle circle1;
    private Line l1;


    private String shapeType;//withing
    private int shapeNumber;//translate
    private boolean translateAll;//translate

    public String getShapeType() {
        return shapeType;
    }
    public int getShapeNumber() {
        return shapeNumber;
    }
    public boolean isTranslateAll() {
        return translateAll;
    }

    public void setShapeType(String shapeType) {
        this.shapeType = shapeType;
    }

    public void setShapeNumber(int shapeNumber) {
        this.shapeNumber = shapeNumber;
    }

    public void setTranslateAll(boolean translateAll) {
        this.translateAll = translateAll;
    }

    public DrawingCanvas(int w, int h)
    {
        width = w;
        height = h;

        shapes = new ArrayList<>();
        result = new ArrayList<>();

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
        //background
        Rectangle background = new Rectangle("black", 0, 0, width, height);
        background.draw(g2d);
        AffineTransform reset = g2d.getTransform();//for resetting the translation

        //translate
        if (translateAll == true) {
            g2d.translate(100, 150);//newX,newY
            for (Figure current : shapes)
                current.draw(g2d);
            g2d.setTransform(reset);//-deleting the changes from the translation

        } else {
            if (shapeNumber != 0) {
                for (Figure current : shapes)
                    if (current == shapes.get(shapeNumber - 1)) {
                        g2d.translate(150, 100);
                        shapes.get(shapeNumber - 1).draw(g2d);
                        g2d.setTransform(reset);
                    } else current.draw(g2d);
            }
        }

        //within
        if (shapeType != null) {
            switch (shapeType) {
                case "circle":
                    for (Figure current : shapes)
                        if (current instanceof Circle)
                            result.add(current);

                    break;
                case "rect":
                    for (Figure current : shapes)
                        if (current instanceof Rectangle)
                            result.add(current);
                    break;
                case "line":
                    for (Figure current : shapes)
                        if (current instanceof Line)
                            result.add(current);
                    break;
            }
            for (Figure current : result)
                current.draw(g2d);
            result.clear();
        }

        //print arrayList
        if(translateAll == false && shapeNumber == 0 && shapeType == null)
            for(Figure current : shapes)
                current.draw(g2d);

        setTranslateAll(false);
        setShapeNumber(0);
        setShapeType(null);
    }
}
