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

    public DrawingCanvas()
    {

        shapes = new ArrayList<>();
        result = new ArrayList<>();//

        r1 = new bg.tu_varna.sit.Shapes.Rectangle("orange",50,75,100,250);
        shapes.add(r1);
        circle1 = new Circle("blue",200,75,100);
        shapes.add(circle1);
        l1 = new Line("red",100,250,300,75);
        shapes.add(l1);
    }
    public void printInfo()
    {
        for (int i = 0; i < shapes.size(); i++)
            System.out.println((i + 1) + " " + shapes.get(i));
    }
    //createShape function
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
                Shape circle = new Circle(color,xStart,yStart,thirdValue);
                shapes.add(circle);
                break;
        }
        System.out.println("You have successfully added a new shape!");
    }
    //erase function - deleting a shape depending on their position
    public void deleteShape(int shapeIndex)
    {
        if(shapeIndex > shapes.size())
            System.out.println("There is no figure number " + shapeIndex + "!");
        else {
            shapes.remove(shapeIndex - 1);
            System.out.println("You have successfully erased the selected shape!");
        }
    }

    //translate function - manipulating the staring coordinates of a specific shape
    public void translate(boolean translateAll, int shapeNumber, double newX, double newY){
        //reset value for resetting the translation
        if (!translateAll) {
            if (shapeNumber != 0) {
                for (Shape current : shapes)
                    if (current == shapes.get(shapeNumber - 1)) {
                        current.translate(newX,newY);
                        System.out.println(shapes.get(shapeNumber - 1).toString());
                        current.translate(-newX,-newY);
                    } else System.out.println(current.toString());
            }
        }
        else
        {
            this.translateAll(newX, newY);
        }
    }
    //translateAll function - manipulating the staring coordinates of all shapes
    public void translateAll(double newX, double newY) {
        for (Shape current : shapes) {
            current.translate(newX, newY);
        System.out.println(current.toString());
        current.translate(-newX, -newY); //deleting the changes from the translation
        }
        System.out.println("Translated all figures!\n");
    }

    private final ArrayList<Shape> result;
    //!!!
    //within function - showing only the shapes from a specific type selected by the user
    public void within(String shapeType){
        if (shapeType != null) {
            switch (shapeType) {
                case "circle":
                    for (Shape current : shapes)
                        if (current instanceof Circle)
                            result.add(current);
                    break;
                case "rect":
                    for (Shape current : shapes)
                        if (current instanceof Rectangle)
                            result.add(current);
                    break;
                case "line":
                    for (Shape current : shapes)
                        if (current instanceof Line)
                            result.add(current);
                    break;
            }
            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i).toString());
                System.out.println((i + 1) + " " + result.get(i));
            }
            result.clear();
        }
    }
}
