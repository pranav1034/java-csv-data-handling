package com.bridgelabz.csvfilehandling.advancedproblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Student {
    private int id;
    private String name;
    private int age;
    private int marks;

    public Student(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student { " +
                "ID=" + id +
                ", Name='" + name +
                ", Age=" + age +
                ", Marks=" + marks +
                " }";
    }
}

public class CsvIntoJava {
    public static void main(String[] args) {
        String path = "Students.csv";
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                int age = Integer.parseInt(data[2].trim());
                int marks = Integer.parseInt(data[3].trim());

                Student student = new Student(id, name, age, marks);
                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Student s : students) {
            System.out.println(s);
        }
    }
}
