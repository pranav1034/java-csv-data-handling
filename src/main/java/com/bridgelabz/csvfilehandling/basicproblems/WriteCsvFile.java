package com.bridgelabz.csvfilehandling.basicproblems;

import java.io.FileWriter;

public class WriteCsvFile {
    public static void main(String[] args) {
        String path = "Students2.csv";
        try{
            FileWriter writer = new FileWriter(path);
            writer.append("ID,Name,Department,Salary\n");

            writer.append("1,Pranav,Engineering,95000\n");
            writer.append("2,Alan,Marketing,88000\n");
            writer.append("3,Aman,Finance,72000\n");
            writer.append("4,Nikhil,Human Resources,65000\n");
            writer.append("5,David,Engineering,90000\n");

            writer.flush();
            writer.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
