package com.bridgelabz.csvfilehandling.intermediateproblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchRecord {
    public static void main(String[] args) {
        String path = "Employees.csv";
        String line;
        int nameIdx=-1;
        int departmentIdx=-1;
        int salaryIdx=-1;
        String searchName = "Pranav";

        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            String head = br.readLine();
            String[] headers = head.split(",");
            for(int i=0;i<headers.length;i++){
                if(headers[i].trim().equalsIgnoreCase("name")){
                    nameIdx=i;
                }
                else if(headers[i].trim().equalsIgnoreCase("department")){
                    departmentIdx=i;
                }
                else if(headers[i].trim().equalsIgnoreCase("salary")){
                    salaryIdx=i;
                }
            }

            while((line=br.readLine())!=null){
                String[] data=line.split(",");
                if(data[nameIdx].trim().equalsIgnoreCase(searchName)){
                    System.out.println("Name: " + data[nameIdx].trim());
                    System.out.println("Department: " + data[departmentIdx].trim());
                    System.out.println("Salary: " + data[salaryIdx].trim());
                }
            }

        }
        catch(IOException e){
            e.printStackTrace();
        }


    }
}
