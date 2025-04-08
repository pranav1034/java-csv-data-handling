package com.bridgelabz.csvfilehandling.advancedproblems;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadLargeFile {
    public static void main(String[] args) {
        String filePath = "largesamplefile.csv";
        int chunkSize = 100;
        int totalCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine();

            String line;
            List<String> chunk = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                chunk.add(line);
                if (chunk.size() == chunkSize) {
                    totalCount += chunk.size();
                    System.out.println("Processed records: " + totalCount);
                    chunk.clear();
                }
            }

            if (!chunk.isEmpty()) {
                totalCount += chunk.size();
                System.out.println("Processed records: " + totalCount);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
