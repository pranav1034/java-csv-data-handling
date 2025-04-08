package com.bridgelabz.csvfilehandling.advancedproblems;
import java.util.*;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MergeCsvFiles {
    public static void main(String[] args) {
        String path1 = "Details1.csv";
        String path2 = "Details2.csv";
        String outputPath = "merged_students.csv";

        Map<String, String[]> studentMap = new HashMap<>();

        try (
                CSVReader reader1 = new CSVReader(new FileReader(path1));
                CSVReader reader2 = new CSVReader(new FileReader(path2));
                CSVWriter writer = new CSVWriter(new FileWriter(outputPath))
        ) {
            String[] header1 = reader1.readNext();
            String[] header2 = reader2.readNext();

            String[] finalHeader = {"ID", "Name", "Age", "Marks", "Grade"};
            writer.writeNext(finalHeader);

            String[] line1;
            while ((line1 = reader1.readNext()) != null) {
                studentMap.put(line1[0], line1);
            }

            String[] line2;
            while ((line2 = reader2.readNext()) != null) {
                String id = line2[0];
                if (studentMap.containsKey(id)) {
                    String[] line1Data = studentMap.get(id);
                    String[] merged = new String[] {
                            id,
                            line1Data[1],
                            line1Data[2],
                            line2[1],
                            line2[2]
                    };
                    writer.writeNext(merged);
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}

