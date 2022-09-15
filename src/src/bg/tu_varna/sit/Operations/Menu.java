package bg.tu_varna.sit.Operations;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public void startMenu() throws IOException, ClassNotFoundException{

        DrawingCanvas drawingCanvas = new DrawingCanvas();
        FileEditor operation = new FileEditor();

        System.out.println("Drawing in Java");
        System.out.print("Welcome to the drawing canvas!\n" +
                        "To read all the available commands - please type \"help\"!\n" +
                        "Drawing Canvas -> ");
        Scanner scanner = new Scanner(System.in);   //Setup Scanner
        String line = scanner.nextLine();           //User choice

        do                                          //Menu loop
        {
            String[] input = line.split(" ");
            String command = input[0];              //Get choice from user
            switch (command)                        //Check choice value
            {
                                                    //shape methods: print, create, erase <n>, translate <n>, within <option>
                case "print":
                    drawingCanvas.printInfo();
                    break;
                case "create":
                    drawingCanvas.createShape(input);
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
                case "help":                            //Display menu commands
                    System.out.println(
                            "\n\t\t\tMENU\n\tShape commands:\n\tShort Description\n" +
                            "\tColor choice examples:\tblue/gray/green/orange/pink/red/white/yellow and whatever color you choose\n" +
                            "1. print           show all shapes\n" +
                            "2. create          create a shape\n" +
                            "3. erase <n>       delete a shape with number <n>\n" +
                            "4. translate [<n>] translate a shape with number <n> or translate all shapes if <n> is not selected\n" +
                            "5. within <option> show all shapes from a specific shape type selected with <option>\n" +

                            "\n\tFile commands:\n" +
                            "1. open <file>     opens currently selected file\n" +
                            "2. close           closes currently opened file\n" +
                            "3. save            saves the opened file\n" +
                            "4. saveas <file>   saves the opened file in <file>\n" +
                            "5. help            prints command information\n" +
                            "6. exit            exists the program\n"
                    );
                    break;
                default:
                    System.out.println("Incorrect command! Please try again!");
            }

            System.out.print("\nDrawing Canvas -> ");
            line = scanner.nextLine();

        }while (true);
    }
}
