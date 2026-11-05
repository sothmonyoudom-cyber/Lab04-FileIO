package practice1;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

public class Exercise4 {

    public static void main(String[] args) {

        ArrayList<String> students = new ArrayList<>();

        try {
        	File file = new File("Ex3StudentData.csv");
            Scanner input = new Scanner(file);

            while (input.hasNextLine()) {
                String data = input.nextLine();
                students.add(data);
            }

            input.close();

            System.out.println("Student Information:");

            for (String student : students) {
                System.out.println(student);
            }

        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }
}