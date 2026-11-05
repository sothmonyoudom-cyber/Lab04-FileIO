package practice1;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Exercise7 {

    public static void main(String[] args) {

        ArrayList<String> groupA = new ArrayList<>();
        ArrayList<String> groupB = new ArrayList<>();
        ArrayList<String> groupC = new ArrayList<>();
        ArrayList<String> groupD = new ArrayList<>();

        int maleA = 0, femaleA = 0;
        int maleB = 0, femaleB = 0;
        int maleC = 0, femaleC = 0;
        int maleD = 0, femaleD = 0;

        try {

            File file = new File("CandidatePerformanceTest.csv");

            Scanner input = new Scanner(file);

            input.nextLine();
            input.nextLine();

            while (input.hasNextLine()) {

                String data = input.nextLine();

                if (data.trim().isEmpty()) {
                    continue;
                }

                String[] student = data.split(",");

                String gender = student[1].trim();
                String group = student[2].trim();

                if (group.equalsIgnoreCase("group A")) {

                    groupA.add(data);

                    if (gender.equalsIgnoreCase("male")) {
                        maleA++;
                    } else if (gender.equalsIgnoreCase("female")) {
                        femaleA++;
                    }
                }
                else if (group.equalsIgnoreCase("group B")) {

                    groupB.add(data);

                    if (gender.equalsIgnoreCase("male")) {
                        maleB++;
                    } else if (gender.equalsIgnoreCase("female")) {
                        femaleB++;
                    }
                }

                else if (group.equalsIgnoreCase("group C")) {

                    groupC.add(data);

                    if (gender.equalsIgnoreCase("male")) {
                        maleC++;
                    } else if (gender.equalsIgnoreCase("female")) {
                        femaleC++;
                    }
                }

                else if (group.equalsIgnoreCase("group D")) {

                    groupD.add(data);

                    if (gender.equalsIgnoreCase("male")) {
                        maleD++;
                    } else if (gender.equalsIgnoreCase("female")) {
                        femaleD++;
                    }
                }
            }

            input.close();

            writeFile("groupA.csv", groupA, maleA, femaleA);

            writeFile("groupB.csv", groupB, maleB, femaleB);

            writeFile("groupC.csv", groupC, maleC, femaleC);

            writeFile("groupD.csv", groupD, maleD, femaleD);

            System.out.println("All group files created successfully!");

        } catch (IOException e) {

            System.out.println("File not found!");

        }
    }


    static double percentage(int number, int total) {

        if (total == 0) {
            return 0;
        }

        return (double) number / total * 100;
    }

    static void writeFile(String filename, ArrayList<String> students, int male, int female) {

        try {

            FileWriter writer = new FileWriter(filename);

            writer.write("ID,gender,group,Education,test preparation course,Math,English,Computer,Total,Average\n");

            for (int i = 0; i < students.size(); i++) {

                writer.write(students.get(i) + "\n");
            }

            int total = students.size();

            writer.write("\nSummary\n");

            writer.write("Total Students," + total + "\n");

            writer.write("Male Percentage," + String.format("%.2f%%", percentage(male, total)) + "\n");

            writer.write("Female Percentage," + String.format("%.2f%%", percentage(female, total)) + "\n");

            writer.close();

            System.out.println(filename + " created successfully!");

        } catch (IOException e) {

            System.out.println("Error writing file!");
        }
    }
}