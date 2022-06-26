package bg.tu_varna.sit;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException{

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
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();


            do
            {
                String[] input = line.split(" ");
                String command = input[0];

                switch (command)
                {
                    //shape methods: print, create, erase <n>, translate <n>, within <option>
                    case "print":
                        myFrame.repaint();
                        break;
                    case "create":
                        String shapeType, color;
                        double xStart, yStart, thirdValue, fourthValue;
                        shapeType = input[1];
                        color = input[2];
                        xStart = Double.parseDouble(input[3]);
                        yStart = Double.parseDouble(input[4]);
                        thirdValue = Double.parseDouble(input[5]);
                        fourthValue = Double.parseDouble(input[6]);
                        drawingCanvas.createShape(shapeType,color,xStart,yStart,thirdValue,fourthValue);
                        break;
                    case "erase":
                        drawingCanvas.deleteShape(Integer.parseInt(input[1]));
                        break;
                    case "translate":
                        if(input[1].equals("all"))
                            drawingCanvas.setTranslateAll(true);
                        else
                            drawingCanvas.setShapeNumber(Integer.parseInt(input[1]));

                        myFrame.repaint();

                        break;
                    case "within":
                        drawingCanvas.setShapeType((String)input[1]);
                        myFrame.repaint();
                        break;
                    //file methods: open, close, exit, save, save as, help
                    case "open":
                        myFrame.remove(drawingCanvas);
                        drawingCanvas = operation.open(input[1]);
                        myFrame.add(drawingCanvas);
                        myFrame.repaint();
                        System.out.println("Successfully opened " + input[1]);
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
                        System.out.println(operation.saveAs(input[1], input[2], drawingCanvas));
                        break;
                    case "help":
                        System.out.println(
                                "\n\tShape commands:\n" +
                                        "print           show all shapes\n" +
                                        "create          create a shape\n" +
                                        "Color choices:\n" +
                                        "blue/cyan/dark_gray/gray/green/light_gray/magenta/orange/pink/red/white/yellow\\n" +
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
                    default:
                        System.out.println("Incorrect command! Try again!");
                }

                System.out.print("\nDrawing Canvas -> ");
                line = scanner.nextLine();
                Thread.sleep(0);
            }while (true);
        }
        catch (InterruptedException exception)
        {
            exception.printStackTrace();
        }
    }
}
