package bg.tu_varna.sit;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileEditor {

    private static String filePath;
    private String currentFileName;//maybe change to file name
    private boolean fileStatus; //default value = false
    //it will be used to grant access to the operations later on(control of the file functions)

    public FileEditor()
    {
//        this.filePath = "D:\\Sun\\Desktop\\";
        this.filePath = "D:\\OOPJavaProjects\\OOPSecondPartUni\\Homework1\\src\\ProjectTesting\\Files\\";
        this.fileStatus = false;
    }

    public void setCurrentFileName(String currentFileName)
    {
        this.currentFileName = currentFileName;
    }

    public void setFilePath(String filePath)
    {
        FileEditor.filePath = filePath;
    }

    public DrawingCanvas open(String fileName) throws IOException, ClassNotFoundException
    {
        this.fileStatus = true; // there is opened file, so now it can be closed, saved, saved as ...

        if(!Files.exists(Paths.get(filePath + fileName)))
        {
            new FileWriter(filePath + fileName).close();
        }

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath + fileName));
        DrawingCanvas drawingCanvas;
        this.currentFileName = fileName;

        if(!(bufferedReader.readLine() == null))
        {
            FileInputStream fileInputStream = new FileInputStream(filePath + fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            drawingCanvas = (DrawingCanvas) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        }
        else
        {
            drawingCanvas = new DrawingCanvas();
        }

        return drawingCanvas;

    }

    public String close() throws IOException
    {
        if(!this.fileStatus) //we cannot close a file if it is not already opened
        {
            return "No opened file!!!";
        }

        this.fileStatus = false; //if there is opened file it will be closed which means that we cannot use the other methods again
        new FileReader(filePath + this.currentFileName).close();
        return "You have successfully close the file - " + this.currentFileName;
    }

    public String save(DrawingCanvas drawingCanvas) throws IOException
    {
        if(!this.fileStatus) // we cannot save changes if a file is not opened
        {
            return "Please open a file to use this operation!";
        }

        FileOutputStream fileOutputStream = new FileOutputStream(filePath + this.currentFileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(drawingCanvas);
        objectOutputStream.close();
        fileOutputStream.close();

        return "You have successfully saved the file - " + this.currentFileName;
    }

    public String saveAs(String newFilePath, String fileName, DrawingCanvas drawingCanvas) throws IOException
    {
        if(!this.fileStatus) // cannot copy a file on another location of not opened
        {
            return "Please open a file and make changes to use this operation!";
        }

        String currentFileNameCopy = this.currentFileName; //make copies to set original path back
        String filePathCopy = filePath;

        setCurrentFileName(fileName); // set new path and file name
        setFilePath(newFilePath + "\\");
        save(drawingCanvas);                //save copy of the file at another location

        setCurrentFileName(currentFileNameCopy);//set back to original path and name
        setFilePath(filePathCopy);              //this will prevent saving files to unknown location by mistake

        return "You have successfully saved another file - " + currentFileNameCopy;
    }

}
