package practice1;
import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class Exercise2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		ArrayList<Integer> numbers = new ArrayList<>();
		try {
			System.out.print("Enter the number of files: ");
			int number = input.nextInt();
			File folder = new File("Ex2LuckyNumber"); 
			folder.mkdir();
			for (int i = 0; i < number ; i++) {
				FileWriter writer = new FileWriter("Ex2LuckyNumber/file" + (i+1) + ".csv");
				writer.write("random\n");
				for (int k = 0; k < 10; k++) {
					int number1 = random.nextInt(100)+1;
					writer.write(number1 + "\n");
				}
				writer.close();
			}
			System.out.print("File created successfully!");
			
			for (int i = 0; i < number; i++) { 
				File file = new File("Ex2LuckyNumber/file" + (i + 1) + ".csv" );
				Scanner reader = new Scanner(file);
				reader.nextLine();
				while (reader.hasNextInt()) {
					numbers.add(reader.nextInt());
				}
				reader.close();
			}
			int max = numbers.get(0);
			int min = numbers.get(0);

			for (int value : numbers) {

			    if (value > max) {
			        max = value;
			    }

			    if (value < min) {
			        min = value;
			    }
			}

			System.out.println("Maximum: " + max);
			System.out.println("Minimum: " + min);
			
		} catch (IOException e) {
			System.out.println("Error!");
			System.out.println(e.getMessage());
		}

	}

}