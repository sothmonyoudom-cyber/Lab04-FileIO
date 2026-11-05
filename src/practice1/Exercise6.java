package practice1;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Exercise6 {

    static int total = 0;
    static int male = 0;
    static int female = 0;

    static int average90 = 0;
    static int male90 = 0;
    static int female90 = 0;

    static int math85 = 0;
    static int english85 = 0;
    static int computer85 = 0;

    static int groupA = 0;
    static int groupB = 0;
    static int groupC = 0;
    static int groupD = 0;
    static int groupE = 0;

    static int maleA = 0, femaleA = 0;
    static int maleB = 0, femaleB = 0;
    static int maleC = 0, femaleC = 0;
    static int maleD = 0, femaleD = 0;
    static int maleE = 0, femaleE = 0;

    public static void main(String[] args) {

        try {

            File file = new File("CandidatePerformanceTest.csv");

            Scanner input = new Scanner(file);

            input.nextLine();
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

                int math = Integer.parseInt(student[5].trim());
                int english = Integer.parseInt(student[6].trim());
                int computer = Integer.parseInt(student[7].trim());

                double average = Double.parseDouble(student[9].trim());

                total++;

                if (gender.equalsIgnoreCase("male")) {
                    male++;
                } else if (gender.equalsIgnoreCase("female")) {
                    female++;
                }


                if (average >= 90) {

                    average90++;

                    if (gender.equalsIgnoreCase("male")) {
                        male90++;
                    } else if (gender.equalsIgnoreCase("female")) {
                        female90++;
                    }
                }
                if (math >= 85) {
                    math85++;
                }

                if (english >= 85) {
                    english85++;
                }

                if (computer >= 85) {
                    computer85++;
                }


                if (group.equalsIgnoreCase("group A")) {

                    groupA++;

                    if (gender.equalsIgnoreCase("male")) {
                        maleA++;
                    } else {
                        femaleA++;
                    }

                } else if (group.equalsIgnoreCase("group B")) {

                    groupB++;

                    if (gender.equalsIgnoreCase("male")) {
                        maleB++;
                    } else {
                        femaleB++;
                    }

                } else if (group.equalsIgnoreCase("group C")) {

                    groupC++;

                    if (gender.equalsIgnoreCase("male")) {
                        maleC++;
                    } else {
                        femaleC++;
                    }

                } else if (group.equalsIgnoreCase("group D")) {

                    groupD++;

                    if (gender.equalsIgnoreCase("male")) {
                        maleD++;
                    } else {
                        femaleD++;
                    }

                } else if (group.equalsIgnoreCase("group E")) {

                    groupE++;

                    if (gender.equalsIgnoreCase("male")) {
                        maleE++;
                    } else {
                        femaleE++;
                    }
                }
            }
            input.close();
            question1();
            question2();
            question3();
            question4();
        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }
    static double percentage(int number, int total) {
        return (double) number / total * 100;
    }
    static void question1() {
        System.out.println("\n===== QUESTION 1 =====");
        System.out.println("Total candidates: " + total);
        System.out.printf("Male: %.2f%%%n",
                percentage(male, total));
        System.out.printf("Female: %.2f%%%n",
                percentage(female, total));
    }
    static void question2() {
        System.out.println("\n===== QUESTION 2 =====");
        System.out.println("Candidates with average >= 90: " + average90);
        System.out.printf("Male: %.2f%%%n",
                percentage(male90, average90));
        System.out.printf("Female: %.2f%%%n",
                percentage(female90, average90));
    }
    static void question3() {
        System.out.println("\n===== QUESTION 3 =====");
        System.out.println("Math >= 85: " + math85);
        System.out.println("English >= 85: " + english85);
        System.out.println("Computer >= 85: " + computer85);
    }
    static void question4() {

        System.out.println("\n===== QUESTION 4 =====");

        System.out.println("\nGroup A: " + groupA);
        System.out.printf("Male: %.2f%%%n", percentage(maleA, groupA));
        System.out.printf("Female: %.2f%%%n", percentage(femaleA, groupA));

        System.out.println("\nGroup B: " + groupB);
        System.out.printf("Male: %.2f%%%n", percentage(maleB, groupB));
        System.out.printf("Female: %.2f%%%n", percentage(femaleB, groupB));

        System.out.println("\nGroup C: " + groupC);
        System.out.printf("Male: %.2f%%%n", percentage(maleC, groupC));
        System.out.printf("Female: %.2f%%%n", percentage(femaleC, groupC));

        System.out.println("\nGroup D: " + groupD);
        System.out.printf("Male: %.2f%%%n", percentage(maleD, groupD));
        System.out.printf("Female: %.2f%%%n", percentage(femaleD, groupD));

        System.out.println("\nGroup E: " + groupE);
        System.out.printf("Male: %.2f%%%n", percentage(maleE, groupE));
        System.out.printf("Female: %.2f%%%n", percentage(femaleE, groupE));
    }
}