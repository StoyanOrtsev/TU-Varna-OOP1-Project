package bg.tu_varna.sit.Operations;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public void startMenu() throws IOException, ClassNotFoundException{
        //command for the execution
        //java -jar D:\OOPJavaProjects\GitHub\src\src\bg\tu_varna\sit\JarFileLocation\TU-Varna-OOP1-Project.jar

        DrawingCanvas drawingCanvas = new DrawingCanvas();

        System.out.println("Drawing in Java");

        FileEditor operation = new FileEditor();

        System.out.print("\nWelcome to the drawing canvas!\nTo read all the available commands - please type \"help\"!\nDrawing Canvas -> ");
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
                    drawingCanvas.printInfo();
                    break;
                case "create":
                    drawingCanvas.createShape(input[1],input[2],input[3],input[4],input[5],input[6]);
                    break;
                case "erase":
                    drawingCanvas.deleteShape(Integer.parseInt(input[1]));
                    break;
                case "translate":
                    drawingCanvas.translate(input[1],input[2],input[3]);
                    break;
                case "within":
                    drawingCanvas.within(input);
                    break;
                //file methods: open, close, exit, save, save as, help
                case "open":
                    drawingCanvas = operation.open(input[1]);
                    System.out.println("Successfully opened " + input[1]);
                    break;
                case "close":
                    System.out.println(operation.close());
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
                                    "blue/gray/green/orange/pink/red/white/yellow\n" +
                                    "erase <n>       delete a shape with number <n>\n" +
                                    "translate [<n>] translate a shape with number <n> or translate all shapes if <n> is not selected\n" +
                                    "within <option> show all shapes from a specific shape type selected with <option>\n" +

                                    "\n\tFile commands:\n" +
                                    "open <file>     opens currently selected file\n" +
                                    "close           closes currently opened file\n" +
                                    "save            saves the opened file\n" +
                                    "saveas <file>   saves the opened file in <file>\n" +
                                    "help            prints command information\n" +
                                    "exit            exists the program\n\n"

                    );
                    break;
                default:
                    System.out.println("Incorrect command! Try again!");
            }

            System.out.print("\nDrawing Canvas -> ");
            line = scanner.nextLine();
        }while (true);
    }
}
