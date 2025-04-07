package com.bridgelabz.csvfilehandling.basicproblems;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class CountRows {
    public static void main(String[] args) {
        String path = "Students.csv";
        String line;
        int count=0;
        try{
            BufferedReader br=new BufferedReader(new FileReader(path));
            String head= br.readLine();
            while((line=br.readLine())!=null){
                count++;
            }
            System.out.println(count);
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}

