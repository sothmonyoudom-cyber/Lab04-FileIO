package practice1;
import java.io.FileWriter;
import java.util.Random;
import java.io.IOException;
public class legit {

	public static void main(String[] args) {
		Random random = new Random();
		try {
			FileWriter writer = new FileWriter("LuckyNumber1.csv");
			writer.write("random\n");
			for (int k =0 ; k < 500; k++) {
				int number = random.nextInt(500)+1;
				writer.write(number + "\n");
				
			}
			writer.close();
			System.out.println("Number entered successfully!");
		} catch (IOException e) {
			System.out.println("Error!");
			System.out.println(e.getMessage());
		}

	}

}
