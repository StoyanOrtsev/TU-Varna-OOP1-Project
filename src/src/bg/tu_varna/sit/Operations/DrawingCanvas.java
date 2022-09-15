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

        r1 = new Rectangle("orange",50,75,100,250);
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
    public void createShape(String shapeType, String color, String xS, String yS, String thirdV, String fourthV)
    {
        int xStart = Integer.parseInt(xS);
        int yStart = Integer.parseInt(yS);
        int thirdValue = Integer.parseInt(thirdV);
        int fourthValue = Integer.parseInt(fourthV);
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
            System.out.println("There is no existing figure number " + shapeIndex + "!");
        else {
            shapes.remove(shapeIndex - 1);
            System.out.println("You have successfully erased the selected shape!");
        }
    }

    //translate function - manipulating the starting coordinates
    public void translate(String shapeN, String hor, String ver){

        int horizontal = Integer.parseInt(hor);
        int vertical = Integer.parseInt(ver);
        if (!shapeN.equals("all")){
             int shapeNumber = Integer.parseInt(shapeN);
                for (Shape current : shapes)
                    if (current == shapes.get(shapeNumber - 1)) {
                        current.translate(horizontal,vertical);
                        System.out.println(shapes.get(shapeNumber - 1).toString());
                    } else System.out.println(current.toString());

        }
        else
        {
            //translate all
            for (Shape current : shapes) {
                current.translate(horizontal, vertical);
                System.out.println(current.toString());
            }
            System.out.println("Translated all figures!\n");
        }
    }

    //within function
    public void within(String[] input){
    }
}
