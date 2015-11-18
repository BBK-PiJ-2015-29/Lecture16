/**
 * Temperature average programme that reads a file from disk 
 * in comma-separated format (CSV). Every line must contain a list of
 * numbers separated by commas.
 * The program must output the average for every line plus the average 
 * for the whole file.
 *
 * Exercise 4b - Week 16
 * @author ocouls01
 */
import java.io.*;
import java.util.List;
import java.util.ArrayList;
public class TempAve{
	public static void main(String[] args) {
		File temps = null;
		try {
			temps = new File("." + File.separator + args[0]);
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("No file specified in arguments");
		}
		
		try (BufferedReader in = new BufferedReader(new FileReader(temps))) {
			String line;
			List<String> aves = new ArrayList<String>();
			int wholeTotal = 0;
			int count = 0;
			int countNums = 0;
			while ((line = in.readLine()) != null) {
				String[] splitNums = line.split(", ");
				int lineTotal = 0;
				for (int i = 0; i < splitNums.length; i++) {
					lineTotal += Integer.parseInt(splitNums[i]);
				}
				wholeTotal += lineTotal;
				
				int lineAve = lineTotal / splitNums.length;
				String lineOut = "Line " + (count + 1) + ": " + lineAve;
				aves.add(lineOut); 
				count++;
				countNums += splitNums.length;
			}
			System.out.println(count + " " + wholeTotal);
			int wholeAve = wholeTotal / countNums;
			for (int i = 0; i < aves.size(); i++) {
				System.out.println(aves.get(i));
			}
			System.out.println("Total Average: " + wholeAve);
			
		} catch (FileNotFoundException ex){
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
		
	}
 }