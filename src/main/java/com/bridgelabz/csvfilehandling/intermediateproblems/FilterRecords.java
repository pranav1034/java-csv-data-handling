package com.bridgelabz.csvfilehandling.intermediateproblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterRecords {
    public static void main(String[] args) {
        String path = "Students.csv";
        String line;
        int idx=-1;
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            String head = br.readLine();
            String[] headers = head.split(",");
            for(int i=0;i<headers.length;i++){
                if(headers[i].trim().equalsIgnoreCase("marks")){
                    idx=i;
                    break;
                }
            }

            while((line=br.readLine())!=null){
                String[] values = line.split(",");
                if(Integer.parseInt(values[idx].trim())>80){
                    System.out.println(line);
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}
