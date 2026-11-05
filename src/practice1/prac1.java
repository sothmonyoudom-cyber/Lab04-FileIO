package practice1;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;
public class prac1 {
	public static void main(String[] args) throws IOException{
		Random random = new Random();
		FileWriter writer = new FileWriter("LuckyNumber.csv");
		
		for (int i=0; i<500; i++) {
			int number = random.nextInt(100)+1;
			writer.write(number + "\n");
		}
		writer.close();
		System.out.println("Number entered successfully!");
		File file = new File("LuckyNumber.csv");
		Scanner input = new Scanner(file);
		while (input.hasNextLine()) {
			String line = input.nextLine();
			System.out.println(line);
			
		}
		input.close();
	}
	
}