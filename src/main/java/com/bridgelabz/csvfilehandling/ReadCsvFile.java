package com.bridgelabz.csvfilehandling;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class ReadCsvFile {
    public static void main(String[] args) {
        String path = "Students.csv";
        String line;
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            String head= br.readLine();
            System.out.println(head);
            while((line= br.readLine())!=null){
                String[] data = line.split(",");
                for(String val : data){
                    System.out.print(val+" ");
                }
                System.out.println();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}
