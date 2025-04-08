package com.bridgelabz.csvfilehandling.advancedproblems;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DetectDuplicates {
    public static void main(String[] args) {
        String path = "Employees.csv";
        Set<String> seenIds = new HashSet<>();
        List<String[]> duplicates = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            String[] header = reader.readNext();
            String[] line;
            while ((line = reader.readNext()) != null) {
                String id = line[0].trim();
                if (seenIds.contains(id)) {
                    duplicates.add(line);
                }
                seenIds.add(id);
            }
            for(String[] row : duplicates) {
                    System.out.println(Arrays.toString(row));
            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}

