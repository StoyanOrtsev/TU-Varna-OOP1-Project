package bg.tu_varna.sit;

import bg.tu_varna.sit.Exceptions.InvalidDataException;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidDataException, IOException, ClassNotFoundException{
        //-- part of the print method
        //how to run the project to the command prompt - ~/Desktop/java-graphics $ javac *.java
        //~/Desktop/java-graphics $ javac Main /DrawingTester
        //JFrame - it can be in separated class

        JFrame myFrame = new JFrame();

        DrawingCanvas tempDC = new DrawingCanvas();
        DrawingCanvas drawingCanvas = tempDC;

        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setTitle("Drawing in Java");
        myFrame.pack();
        myFrame.setSize(1280,720);
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
        myFrame.add(drawingCanvas);

        try {
            FileEditor operation = new FileEditor();

            System.out.println("\nWelcome to the drawing canvas!\nDrawing Canvas -> ");
            Scanner input = new Scanner(System.in);
            String line = input.nextLine();


            while (true)
            {
                String[] argsArr = line.split(" ");
                String command = argsArr[0];

                switch (command)
                {
                    case "open":
                        myFrame.remove(drawingCanvas);
                        drawingCanvas = operation.open(argsArr[1]);
                        myFrame.add(drawingCanvas);
                        myFrame.repaint();
                        System.out.println("Successfully opened " + argsArr[1]);
                        break;
                    case "close":
                        System.out.println(operation.close());
                        myFrame.remove(drawingCanvas);
                        drawingCanvas = tempDC;
                        myFrame.add(drawingCanvas);
                        myFrame.repaint();
                        break;
                    case "exit":
                        System.out.println("Exiting the program!");
                        System.exit(0);
                        break;
                    case "save":
                        System.out.println(operation.save(drawingCanvas));
                        break;
                    case "saveas":
                        System.out.println(operation.saveAs(argsArr[1], argsArr[2], drawingCanvas));
                        break;
                    case "help":
                        System.out.println(
                                "\tShape commands:\n" +
                                        "print           show all shapes\n" +
                                        "create          create a shape\n" +
                                        "erase <n>       delete a shape with number <n>\n" +
                                        "translate [<n>] translate a shape with number <n> or translate all shapes if <n> is not selected\n" +
                                        "within <option> show all shapes from a specific shape type selected with <option>\n" +

                                        "\n\tFile commands:\n" +
                                        "open <file>     opens <file>\n" +
                                        "close           closes currently opened file\n" +
                                        "save            saves the currently open file\n" +
                                        "saveas <file>   saves the currently open file in <file>\n" +
                                        "help            prints this information\n" +
                                        "exit            exists the program\n\n"

                        );
                        break;
                    //case - function: print, create, erase <n>, translate <n>, within <option>
                    case "print":
                        //...
                        myFrame.repaint();
                        break;
                    case "create":
                        //...
                        double xStart,yStart,width,height,size,xEnd,yEnd;
                        String color;
                        switch (argsArr[1])
                        {
                            case "rect":
                                color = argsArr[2];
                                xStart = Double.parseDouble(argsArr[3]);
                                yStart = Double.parseDouble(argsArr[4]);
                                width = Double.parseDouble(argsArr[5]);
                                height = Double.parseDouble(argsArr[6]);
                                drawingCanvas.createRect(color, xStart, yStart, width, height);
                                break;
                            case "circle":
                                color = argsArr[2];
                                xStart = Double.parseDouble(argsArr[3]);
                                yStart = Double.parseDouble(argsArr[4]);
                                size = Double.parseDouble(argsArr[5]);
                                drawingCanvas.createCircle(color, xStart, yStart, size);
                                break;
                            case "line":
                                color = argsArr[2];
                                xStart = Double.parseDouble(argsArr[3]);
                                yStart = Double.parseDouble(argsArr[4]);
                                xEnd = Double.parseDouble(argsArr[5]);
                                yEnd = Double.parseDouble(argsArr[6]);
                                drawingCanvas.createLine(color, xStart, yStart, xEnd, yEnd);
                                break;
                        }
                        break;
                    case "erase":
                        //...
                        drawingCanvas.deleteShape(Integer.parseInt(argsArr[1]));
                        break;
                    case "translate":
                        //...
                        if(argsArr[1].equals("all"))
                            drawingCanvas.setTranslateAll(true);
                        else
                            drawingCanvas.setShapeNumber(Integer.parseInt(argsArr[1]));

                        myFrame.repaint();

                        break;
                    case "within":
                        //...
                        drawingCanvas.setShapeType((String)argsArr[1]);
                        myFrame.repaint();
                        break;
                    default:
                        System.out.println("Incorrect command! Try again!");
                }

                System.out.print("\nDrawing Canvas -> ");
                line = input.nextLine();
                Thread.sleep(0);
            }
        }
        catch (InterruptedException exception)
        {
            exception.printStackTrace();
        }
    }
}
