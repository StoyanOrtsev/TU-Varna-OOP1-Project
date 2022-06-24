package bg.tu_varna.sit;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //-- part of the print method
        //how to run the project to the command prompt - ~/Desktop/java-graphics $ javac *.java
        //~/Desktop/java-graphics $ javac Main /DrawingTester
        //JFrame - it can be in separated class
        int w = 1280;
        int h = 720;
        JFrame f = new JFrame();

        DrawingCanvas drawingCanvas = new DrawingCanvas(w,h);

        f.setSize(w,h);
        f.setTitle("Drawing in Java");

        f.add(drawingCanvas);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        //--

//                try {
//                    //prints all from add(dc)
//
//                    //pause for 5 seconds
//
//                    TimeUnit.SECONDS.sleep(3);
//                    drawingCanvas.setShapeNumber(1);
//                    drawingCanvas.print();
//
//                    TimeUnit.SECONDS.sleep(3);
//                    drawingCanvas.setTranslateAll(true);
//                    drawingCanvas.print();
//
//                    TimeUnit.SECONDS.sleep(3);
//                    drawingCanvas.setShapeType("rect");
//                    drawingCanvas.print();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

    }
}
