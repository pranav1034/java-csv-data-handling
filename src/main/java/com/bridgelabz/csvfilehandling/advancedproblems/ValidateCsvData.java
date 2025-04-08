package com.bridgelabz.csvfilehandling.advancedproblems;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class ValidateCsvData {
    public static void main(String[] args) {
        String path = "EmployeeDetails.csv";

        Pattern email = Pattern.compile("^[A-Za-z0-9+.-_]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
        Pattern phone = Pattern.compile("^[0-9]{10}$");

        try{
            CSVReader reader = new CSVReader(new FileReader(path));
            String[] header = reader.readNext();
            int emailIdx = -1;
            int phoneIdx = -1;

            for (int i = 0; i < header.length; i++) {
                if (header[i].trim().equalsIgnoreCase("email")) {
                    emailIdx = i;
                }
                if (header[i].trim().equalsIgnoreCase("phone")) {
                    phoneIdx = i;
                }
            }

            String[] line;
            while ((line = reader.readNext()) != null) {
                String emailValue = line[emailIdx];
                String phoneValue = line[phoneIdx];

                if (!email.matcher(emailValue).matches()) {
                    System.out.println("Invalid email: " + emailValue);
                    System.out.println("Invalid record: "+ Arrays.toString(line));
                }
                if (!phone.matcher(phoneValue).matches()) {
                    System.out.println("Invalid phone number: " + phoneValue);
                    System.out.println("Invalid record: "+ Arrays.toString(line));
                }
            }

        }
        catch(IOException | CsvValidationException e){
            e.printStackTrace();
        }

    }
}
