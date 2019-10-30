import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CodeGolf {

	public static void main(String[] args) throws IOException {
		
		// Inputs
		FileInputStream fIn = new FileInputStream("words.txt");
		Scanner fscan = new Scanner(fIn);
		// Array Lists
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<Integer> count = new ArrayList<Integer>();
		
		// Reading file and comparing words
		while(fscan.hasNext()) {
			// Reach next word
			String nextWord = fscan.next();
			// Check if it's in the word list
			if (words.contains(nextWord)) {
				int index = words.indexOf(nextWord);
				count.set(index, count.get(index) + 1);
			}
			else {
				words.add(nextWord); count.add(1);	
			}
		}
		// Close files
		fscan.close(); fIn.close();
		// Output
		for(int i = 0; i < words.size(); i++) {
			System.out.println(words.get(i) + " : " + count.get(i));
		}
	}

}
