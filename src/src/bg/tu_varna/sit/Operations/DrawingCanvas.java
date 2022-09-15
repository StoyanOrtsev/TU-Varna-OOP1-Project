package bg.tu_varna.sit.Operations;

import bg.tu_varna.sit.Shapes.Circle;
import bg.tu_varna.sit.Shapes.Shape;
import bg.tu_varna.sit.Shapes.Line;
import bg.tu_varna.sit.Shapes.Rectangle;

import java.io.Serializable;
import java.util.*;
public class DrawingCanvas implements Serializable {

    private final ArrayList<Shape> shapes;

    public DrawingCanvas()
    {
        shapes = new ArrayList<>();
    }
    public void printInfo()
    {
        for (int i = 0; i < shapes.size(); i++)
            System.out.println((i + 1) + " " + shapes.get(i));
    }
    //createShape function
    public void createShape(String[] input)
    {
        int xStart = Integer.parseInt(input[3]);
        int yStart = Integer.parseInt(input[4]);
        int thirdValue = Integer.parseInt(input[5]);// width / radius / xEnd
        int fourthValue;                            // height / ---   / yEnd
        switch (input[1])
        {
            case "rect":
                fourthValue = Integer.parseInt(input[6]);
                Shape rect = new Rectangle(input[2],xStart,yStart,thirdValue,Integer.parseInt(input[6]));
                shapes.add(rect);
                break;
            case "line":
                fourthValue = Integer.parseInt(input[6]);
                Shape line = new Line(input[2],xStart,yStart,thirdValue,Integer.parseInt(input[6]));
                shapes.add(line);
                break;
            case "circle":
                Shape circle = new Circle(input[2],xStart,yStart,thirdValue);
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
        String regionShape = input[1];//rect or circle
        int regionX = Integer.parseInt(input[2]);
        int regionY = Integer.parseInt(input[3]);
        int regionThirdValue = Integer.parseInt(input[4]);  // width / radius / xEnd
        int regionFourthValue;                              // height / ---   / yEnd
        switch (input[1]) {
            case "rect":
                regionFourthValue = Integer.parseInt(input[5]);
                for(Shape current : shapes){
                    if(current.getxStart() >= regionX && current.getxStart() < (regionX + regionThirdValue) &&
                    current.getyStart() >= regionY && current.getyStart() < (regionY + regionFourthValue)) {

                        if (current instanceof Rectangle) {
                            if (((Rectangle) current).getWidth() <= (regionX + regionThirdValue - current.getxStart()) &&
                                    ((Rectangle) current).getHeight() <= (regionY + regionFourthValue - current.getyStart()))
                                System.out.println(current.toString());
                        } else if (current instanceof Circle) {
                            if (((Circle) current).getRadius() <= (current.getxStart() - regionX) &&                        //left side
                                    ((Circle) current).getRadius() <= (current.getyStart() - regionY) &&                    //top side
                                    ((Circle) current).getRadius() <= (regionX + regionThirdValue - current.getxStart()) && //right side
                                    ((Circle) current).getRadius() <= (regionY + regionFourthValue - current.getyStart()))  //bottom side
                                System.out.println(current.toString());
                        } else if(current instanceof Line){
                            if(((Line) current).getxEnd() >= regionX && ((Line) current).getxEnd() <= (regionX + regionThirdValue) &&
                                    ((Line) current).getyEnd() >= regionY && ((Line) current).getyEnd() <= (regionY + regionFourthValue))
                                System.out.println(current.toString());
                        }
                    }
                }
                break;
            case "circle":
                break;
        }
    }
}
