package bg.tu_varna.sit.Operations;

import bg.tu_varna.sit.Shapes.Circle;
import bg.tu_varna.sit.Shapes.Figure;
import bg.tu_varna.sit.Shapes.Line;
import bg.tu_varna.sit.Shapes.Rectangle;

import java.awt.*;//for the Color and Graphics classes
import java.awt.geom.AffineTransform;//for creating shapes and paths
//Ellipse2D.Double
//Line2D.Double
//Path2D.Double
//Rectangle2D.Double
//R,G,B(RGB channels) - RED|GREEN|BLUE 0-255 - Colors

import java.io.Serializable;
import java.util.*;
import javax.swing.*;

public class DrawingCanvas extends JComponent implements Serializable {

    final int panel_width = 1280;
    final int panel_height = 720;
    private final ArrayList<Figure> shapes;
    private final ArrayList<Figure> result;

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

    public DrawingCanvas()
    {
        this.setPreferredSize(new Dimension(panel_width, panel_height));

        shapes = new ArrayList<>();
        result = new ArrayList<>();

        r1 = new bg.tu_varna.sit.Shapes.Rectangle("orange",50,75,100,250);//R,G,B(RGB channels) - RED|GREEN|BLUE 0-255
        shapes.add(r1);
        circle1 = new Circle("blue",200,75,100,100);
        shapes.add(circle1);
        l1 = new Line("red",100,250,300,75);//switch for the colors
        shapes.add(l1);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform reset = g2d.getTransform();//for resetting the translation

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        //translate
        if (translateAll) {
            g2d.translate(100, 150);//newX,newY
            for (Figure current : shapes)
                current.draw(g2d);
            System.out.println("Translated all figures!\n");
            g2d.setTransform(reset);//deleting the changes from the translation

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
            for (int i = 0; i < result.size(); i++) {
                shapes.get(i).draw(g2d);
                System.out.println((i + 1) + " " + shapes.get(i));
            }
            result.clear();
        }

        //print arrayList
        if(!translateAll && shapeNumber == 0 && shapeType == null)
        for (int i = 0; i < shapes.size(); i++) {
            shapes.get(i).draw(g2d);
            System.out.println((i + 1) + " " + shapes.get(i));
        }

        setTranslateAll(false);
        setShapeNumber(0);
        setShapeType(null);
    }
    //create function
    public void createShape(String shapeType, String color, double xStart, double yStart, double thirdValue, double fourthValue)
    {
        switch (shapeType)
        {
            case "rect":
                Figure rect = new Rectangle(color,xStart,yStart,thirdValue,fourthValue);
                shapes.add(rect);
                break;
            case "line":
                Figure line = new Line(color,xStart,yStart,thirdValue,fourthValue);
                shapes.add(line);
                break;
            case "circle":
                Figure circle = new Circle(color,xStart,yStart,thirdValue,fourthValue);
                shapes.add(circle);
                break;
        }
        System.out.println("You have successfully added a new shape!");
    }
    //erase function
    public void deleteShape(int shapeIndex)
    {
        if(shapeIndex > shapes.size())
            System.out.println("There is no figure number " + shapeIndex + "!");
        else {
            shapes.remove(shapeIndex - 1);
            System.out.println("You have successfully erased the selected shape!");
        }
    }
}
