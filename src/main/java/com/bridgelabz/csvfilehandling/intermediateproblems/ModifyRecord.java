package com.bridgelabz.csvfilehandling.intermediateproblems;

import java.io.*;

public class ModifyRecord {
    public static void main(String[] args) {
        String path = "Employees.csv";
        String path2 = "Updated_Employees.csv";
        String line;
        int deptIdx=-1;
        int salaryIdx=-1;

        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            BufferedWriter bw = new BufferedWriter(new FileWriter(path2));
            String head =br.readLine();
            bw.write(String.join(",", head));
            bw.write("\n");
            String[] headers = head.split(",");

            for(int i=0;i<headers.length;i++){
                if(headers[i].trim().equalsIgnoreCase("department")){
                    deptIdx=i;
                }
                else if(headers[i].trim().equalsIgnoreCase("salary")){
                    salaryIdx=i;
                }
            }
            while((line = br.readLine())!=null){
                String[] data= line.split(",");
                if(data[deptIdx].trim().equalsIgnoreCase("IT")){
                    int salary = Integer.parseInt(data[salaryIdx].trim());
                    int new_Salary = (int) (salary*1.10);
                    data[salaryIdx] = String.valueOf(new_Salary);
                }
                bw.write(String.join(",",data));
                bw.write("\n");
            }
            bw.flush();
            bw.close();

        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}
