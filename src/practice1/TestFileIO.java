package practice1;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
public class TestFileIO {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try{
			FileWriter writer = new FileWriter("File.csv");
		
		writer.write("ID,Name,Phone,Gender,Major\n");
		for (int i = 0; i < 5; i++) {
			System.out.println("Student " + (i+1));
			
			System.out.print("Enter your id: ");
			int id = input.nextInt();
			input.nextLine();
			
			System.out.println("Enter your name: ");
			String name = input.nextLine();
			
			System.out.println("Enter your phone number: ");
			int phone = input.nextInt();
			input.nextLine();
			
			System.out.println("Enter your gender (M/F): ");
			String gender = input.nextLine();
			
			System.out.println("Enter your major: ");
			String major = input.nextLine();
			
			writer.write(id + ","+ name + "," + phone + "," + gender + ","+ major+ "\n");
			System.out.println();
		}
		writer.close();
		System.out.println("Students' information is successfully entered!");
		} catch (IOException e) {
			System.out.println("An error occured while entering the data of the students!");
		}
		input.close();
	}
}