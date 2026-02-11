package com.tss.FileAssignments;

import java.io.File;
import java.io.FileReader;

public class FileOperations {
    public static void main(String[] args) {

        File myDir=new File("C:\\Users\\Smit.Patel\\Desktop\\Smit Codes\\core_java\\Assignments\\src\\com\\tss\\FileAssignments\\Parent");
        File myFile=new File("C:\\Users\\Smit.Patel\\Desktop\\Smit Codes\\core_java\\Assignments\\src\\com\\tss\\FileAssignments\\Swabhav.txt");
        fileReading(myFile);

    }
    public static void fileReading(File file){
        if(!file.exists()){
            System.out.println("File Not Found!");
            return;
        }
        if(file.isFile()){
            try{
                FileReader fr=new FileReader(file);
                int ch;
                while((ch=fr.read())!=-1){
                    System.out.print((char)ch);
                }
                fr.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (file.isDirectory()) {
            directoryReading(file);
        }

    }
    public static void directoryReading(File dir){
        String []fileNames=dir.list();

        for(String file:fileNames){
            File newFile=new File(dir,file);
            if(newFile.isFile()){
                System.out.println(file);
            } else if (newFile.isDirectory()) {
                directoryReading(newFile);
            }
        }
    }
}
