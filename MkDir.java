/**
 * mkdir programme which creates a new directory
 * Exercise 2 - Week 16
 * @author ocouls01
 */
import java.io.File; 

public class MkDir{
	
	public static void main(String[] args) {
		MkDir origin = new MkDir();
		
		origin.makeDirectories(args);
			
		
	}
	
	public void makeDirectories(String[] args) {
		for (int i = 0; i < args.length; i++) {
			File newFile = new File("." + File.separator + args[i]);
			newFile.mkdir();
		}
	}
}