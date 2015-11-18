/**
 * cat programme that takes a name from the user at the command line. 
 * if a file with that name exists, the programme shows its contents on screen.
 * If it does not, the programme must say so.
 *
 * Exercise 3 - Week 16
 * @author ocouls01
 */
import java.io.*;

public class Cat {
	public static void main(String[] args) {
		
		for (int i = 0; i < args.length; i++) {
			File myFile = new File("." + File.separator + args[i]);
			if (myFile.exists()) {
			
			try (BufferedReader in = new BufferedReader(new FileReader(myFile))) {
				String line;
				System.out.println("Name: " + args[i]);
				while ((line = in.readLine()) != null) {
					System.out.println(line);
				}
			} catch (FileNotFoundException ex) {
				ex.printStackTrace();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			System.out.println();
		} else {
			System.out.println("File not found.");
		}
		}
		
		
		
		
		
	}
}
