package com.bridgelabz.csvfilehandling.intermediateproblems;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortRecords {
    public static void main(String[] args) {
        String path = "Employees.csv";
        List<String[]> records= new ArrayList<>();

        try{
            CSVReader reader =new CSVReader(new FileReader(path));
            String[] header=reader.readNext();
            int salaryIdx=-1;
            for(int i=0;i< header.length;i++){
                if(header[i].trim().equalsIgnoreCase("salary")){
                    salaryIdx=i;
                }
            }
            String[] line;
            while((line=reader.readNext())!=null){
                records.add(line);
            }
            System.out.println("Before sorting");
            for(String[] record:records){
                System.out.println(Arrays.toString(record));
            }

            records.sort((a,b)->{
                return Integer.parseInt(b[3])-Integer.parseInt(a[3]);
            });

            System.out.println("\nAfter sorting");
            for(int i=0;i<5;i++){
                String[] temp=records.get(i);
                System.out.println(Arrays.toString(temp));
            }
        }
        catch(IOException | CsvValidationException e){
            e.printStackTrace();
        }
    }
}
