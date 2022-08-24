package bg.tu_varna.sit.Operations;

import bg.tu_varna.sit.Shapes.Circle;
import bg.tu_varna.sit.Shapes.Shape;
import bg.tu_varna.sit.Shapes.Line;
import bg.tu_varna.sit.Shapes.Rectangle;

import java.io.Serializable;
import java.util.*;
public class DrawingCanvas implements Serializable {

    private final ArrayList<Shape> shapes;

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

        shapes = new ArrayList<>();

        r1 = new bg.tu_varna.sit.Shapes.Rectangle("orange",50,75,100,250);
        shapes.add(r1);
        circle1 = new Circle("blue",200,75,100,100);
        shapes.add(circle1);
        l1 = new Line("red",100,250,300,75);//switch for the colors
        shapes.add(l1);
    }
    public void printInfo()
    {
        for (int i = 0; i < shapes.size(); i++)
            System.out.println((i + 1) + " " + shapes.get(i));
    }
    //create function
    public void createShape(String shapeType, String color, double xStart, double yStart, double thirdValue, double fourthValue)
    {
        switch (shapeType)
        {
            case "rect":
                Shape rect = new Rectangle(color,xStart,yStart,thirdValue,fourthValue);
                shapes.add(rect);
                break;
            case "line":
                Shape line = new Line(color,xStart,yStart,thirdValue,fourthValue);
                shapes.add(line);
                break;
            case "circle":
                Shape circle = new Circle(color,xStart,yStart,thirdValue,fourthValue);
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

    public void translate(){
        //reset value for resetting the translation
        //translate
        if (translateAll) {
//            g2d.translate(100, 150);//newX,newY
            for (Shape current : shapes)
                current.draw();
            System.out.println("Translated all figures!\n");
//            g2d.setTransform(reset);//deleting the changes from the translation

        } else {
            if (shapeNumber != 0) {
                for (Shape current : shapes)
                    if (current == shapes.get(shapeNumber - 1)) {
//                        g2d.translate(150, 100);
                        shapes.get(shapeNumber - 1).draw();
//                        g2d.setTransform(reset);
                    } else current.draw();
            }
        }
    }

    public void within(){
        //within
        if (shapeType != null) {
            switch (shapeType) {
                case "circle":
                    for (Shape current : shapes)
                        if (current instanceof Circle)
                            shapes.add(current);
                    break;
                case "rect":
                    for (Shape current : shapes)
                        if (current instanceof Rectangle)
                            shapes.add(current);
                    break;
                case "line":
                    for (Shape current : shapes)
                        if (current instanceof Line)
                            shapes.add(current);
                    break;
            }
            for (int i = 0; i < shapes.size(); i++) {
                shapes.get(i).draw();
                System.out.println((i + 1) + " " + shapes.get(i));
            }
            shapes.clear();
        }
    }
}
