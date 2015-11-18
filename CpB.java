/**
 * CpB programme that takes many file names at the command line. 
 * When this happens, the last name must be a directory 
 * (otherwise, your program should complain). If it is a directory, 
 * your program has to copy all files (i.e. the other arguments)
 * into that directory.
 *
 * Exercise 4b - Week 16
 * @author ocouls01
 */
import java.io.*;

public class CpB {
	public static void main(String[] args) {
		CpB myCP = new CpB();
		File last = new File("." + File.separator + args[args.length-1]);
				
		if (args.length < 2) {
			System.out.println("Wrong number of files input");
		} else if (!last.exists()) {
			last.mkdir();
		} else if (!last.isDirectory()){
			System.out.println("Last file is not a directory");
		} 
		for (int i = 0; i < args.length-1; i++) {
			File origin = new File("." + File.separator + args[i]);
			File dest = new File("." + File.separator + 
				args[args.length-1] + File.separator + args[i]);
			
			if (!origin.exists()) {
				System.out.println("Origin file" + args[i] + " not found");
				System.exit(0);
			} 
			boolean overwrite = true;
			if (dest.exists()) {
				boolean valid = false;
				String input = "";
				while (!valid) {
					System.out.println("Destination file already exists.");
					System.out.print("Do you want to overwrite it? Y/N");
					input = System.console().readLine();
					
					if (input.toUpperCase().equals("Y")) {
						valid = true;
						myCP.write(origin, dest);
					} else if (input.toUpperCase().equals("N")) {
						valid = true;
						String newFileName = dest.getName() + "(copy)";
						File newDest = new File(newFileName);
						try {
							newDest.createNewFile();
						} catch (FileNotFoundException ex) {
							ex.printStackTrace();
						} catch (IOException ex) {
							ex.printStackTrace();
						}
						myCP.write(origin, newDest);
					} else {
						System.out.println("Not a valid input");
					}
				}
			} else {
				try {
					dest.createNewFile();
				} catch (FileNotFoundException ex) {
					ex.printStackTrace();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				myCP.write(origin, dest);
			}	
		}	
	}
	public void write(File origin, File dest) {
		try (BufferedReader in = new BufferedReader(new FileReader(origin))) {
			try (PrintWriter out = new PrintWriter(dest)) {
				String line;
				while ((line = in.readLine()) != null) {
					out.println(line);
				}
			} catch (FileNotFoundException ex) {
				ex.printStackTrace();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} catch(FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	
}