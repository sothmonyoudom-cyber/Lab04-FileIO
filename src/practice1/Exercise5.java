package practice1;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Exercise5 {
    public static void main(String[] args) {
        ArrayList<String[]> students = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        try {
            File file = new File("Ex3StudentData.csv");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] student = data.split(",");
                students.add(student);
            }
            reader.close();
            for (int i = 0; i < 3; i++) {
                System.out.println("Student " + (i + 1));
                System.out.print("Enter name: ");
                String name = input.nextLine();
                System.out.print("Enter ID: ");
                String ID = input.nextLine();
                System.out.print("Enter gender: ");
                String gender = input.nextLine();
                String[] student = {name, ID, gender};
                students.add(student);
                System.out.println();
            }
            for (int i = 0; i < students.size(); i++) {
                for (int j = i + 1; j < students.size(); j++) {
                    if (students.get(i)[0].trim().compareToIgnoreCase(
                            students.get(j)[0].trim()) > 0) {
                        String[] temp = students.get(i);
                        students.set(i, students.get(j));
                        students.set(j, temp);
                    }
                }
            }
            FileWriter writer = new FileWriter("Ex3StudentData.csv");
            for (int i = 0; i < students.size(); i++) {
                writer.write(String.join(",", students.get(i)) + "\n");
            }
            writer.close();
            System.out.println("\nStudent Information (A-Z):");
            for (int i = 0; i < students.size(); i++) {
               System.out.println(String.join(", ", students.get(i)));
            }
            System.out.println("\nStudent data saved successfully!");
        } catch (IOException e) {
            System.out.println("File not found!");
        }
        input.close();
    }
}