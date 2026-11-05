package practice1;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
public class Exercise3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
		FileWriter writer = new FileWriter("Ex3StudentData.csv");
		
		writer.write("Name, ID, gender\n");
		for (int i = 0; i < 3; i++) {
			System.out.println("Student: " + (i + 1));
			
			System.out.println("Enter your name: ");
			String name = input.nextLine();
			System.out.println("Enter your ID: ");
			int ID = input.nextInt();
			input.nextLine();
			
			System.out.println("Enter your gender: ");
			String gender = input.nextLine();
			writer.write(name + "," + ID + "," + gender + "\n");
			System.out.println();
		
		}
		writer.close();
		System.out.println("Students' information has been entered successfully.");
		}
		catch (IOException e) {
			System.out.println("Error!");
		} 
		input.close();
	}

}
