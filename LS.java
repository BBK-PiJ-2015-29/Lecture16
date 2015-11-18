/**
 * ls programme which shows the files int he current directory
 * Exercise 1 - Week 16
 * @author ocouls01
 */
import java.io.File; 

public class LS {
	private File current;
	
	public LS() {
		current = new File(".");
	}
	
	public static void main(String[] args) {
		LS origin = new LS();
		origin.listFiles();
	
	}
	
	
	public void listFiles() {
		String[] list = current.list();
		for(int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
	}
	
	
	
}