/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.sorter;

import com.sun.glass.ui.CommonDialogs;
import java.awt.Desktop;
import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Hashtable;
import java.util.Scanner;
import java.nio.*;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
/**
 *
 * @author SRoche
 */
public class FileSorter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String OutputPath= "C:\\Users\\Sroche\\desktop\\optestfile"; //create a location to save from
        String InPath="C:\\Users\\Sroche\\desktop\\testfile\\";
        File Folder = new File(InPath);//open the folder using the path on the hard drive
        showFiles(Folder.listFiles());//show the files you are using in the folder
        String [] FileInDir = Folder.list();//store the file names in a list
        String FileOwner = null;//name the owner
        //System.out.println(FileInDir.length+"hi");
        String FileName = "";//name the files
        for (int i=0;i<FileInDir.length;i++) {
            //loop through the folder files
            System.out.println(FileInDir[i]);
            Scanner InputVar = new Scanner(System.in);
            
            System.out.println("Are you based in Dublin or Croatia? ");
            String Location = InputVar.next();
            switch (Location) {
                case "Dublin":
                    FileOwner = "D" + FileInDir[i].substring(0, 3); //Assigns the fileowner with the office naming convention for dublin
                    break;
                case "Croatia":
                    FileOwner = "C" + FileInDir[i].substring(0, 3); //Assigns the fileowner with the office naming convention for Croatia
                    break;
                default:
                    System.out.println("error");
            }
            System.out.println(FileOwner);
            moveFile(InPath, OutputPath);
        }
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    public static void showFiles(File[] files) {
        for (File file :files) {
            if (file.isDirectory()) {
                System.out.println("Directory: " + file.getAbsolutePath());
                showFiles(file.listFiles()); // Calls same method again
            }else{
                System.out.println("File:"+file.getAbsolutePath());
            }
            
        }  
    }
    
    
    
    
  public static boolean moveFile(String sourcePath, String targetPath) {

    boolean fileMoved = true;

    try {

        Files.move(Paths.get(sourcePath), Paths.get(targetPath), StandardCopyOption.REPLACE_EXISTING);

    } catch (Exception e) {

        fileMoved = false;
        e.printStackTrace();
    }

    return fileMoved;
}  
    
    
    
    
    
    
    public static boolean FileMove(String FileSource,String TargetOutput){
        File newFile = new File(FileSource);
        return newFile.renameTo(new File(TargetOutput));
    }
}
