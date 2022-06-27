package bg.tu_varna.sit.Operations;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileEditor {

    private static String filePath;
    private String fileName;
    private boolean fileStatus; //default value = false
    //it will be used to control the file operations later on

    public FileEditor()
    {
        this.fileStatus = false;
        this.filePath = "D:\\OOPJavaProjects\\TU-Varna-OOP1-Project\\src\\src\\bg\\tu_varna\\sit\\Files\\";
    }

    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public void setFilePath(String filePath)
    {
        FileEditor.filePath = filePath;
    }

    public boolean isFileStatus() {
        return fileStatus;
    }
    public void setFileStatus(boolean fileStatus) {
        this.fileStatus = fileStatus;
    }

    public DrawingCanvas open(String file) throws IOException, ClassNotFoundException
    {
        this.setFileStatus(true);
        //if the file is opened, you can use the other methods(close/save/save as) otherwise you would not have access to them

        if(!Files.exists(Paths.get(filePath + file)))
            new FileWriter(filePath + file).close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath + file));
        DrawingCanvas drawingCanvas;
        this.setFileName(file);

        if((bufferedReader.readLine() == null)) drawingCanvas = new DrawingCanvas();
        else
        {
            FileInputStream fileInputStream = new FileInputStream(filePath + file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            drawingCanvas = (DrawingCanvas) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        }

        return drawingCanvas;

    }

    public String close() throws IOException
    {
        if(this.isFileStatus())
        {
            this.setFileStatus(false);
            //if there is opened file it will be closed which means that we cannot use the other methods again
            new FileReader(filePath + this.fileName).close();
            return "You have successfully closed the file - " + this.fileName;
        }
        return "You have to first open the file so you can close it!";
    }

    public String save(DrawingCanvas drawingCanvas) throws IOException
    {
        if(this.isFileStatus())
        {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath + this.fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(drawingCanvas);
            objectOutputStream.close();
            fileOutputStream.close();

            return "You have successfully saved the changes to file - " + this.fileName;
        }
        // we cannot save changes if a file is not opened
        return "Please open a file to use this operation!";
    }

    public String saveAs(String newFilePath, String newName, DrawingCanvas drawingCanvas) throws IOException
    {
        if(this.isFileStatus())
        {
            String currentFileNameCopy = this.getFileName(); //make copies to set original path back
            String filePathCopy = filePath;

            setFileName(newName); // set new path and file name
            setFilePath(newFilePath + "\\");
            save(drawingCanvas);                //save copy of the file at another location

            setFileName(currentFileNameCopy);//set back to original path and name
            setFilePath(filePathCopy);              //this will prevent saving files to unknown location by mistake

            return "You have successfully saved the changed to another file - " + currentFileNameCopy;
        }
        // cannot copy a file on another location of not opened
        return "Please open a file and make changes to use this operation!";
    }

}
