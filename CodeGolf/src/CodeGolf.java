import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CodeGolf {

	public static void main(String[] args) throws IOException {
		
		// Inputs Declarations
		FileInputStream fIn = new FileInputStream("words.txt");
		Scanner fscan = new Scanner(fIn);
		FileInputStream stpIn = new FileInputStream("stopwords.txt");
		Scanner stpscan = new Scanner(stpIn);
		
		// Array Lists Declarations
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<Integer> count = new ArrayList<Integer>();
		ArrayList<String> stpwords = new ArrayList<String>();

		// Stop Words List
		while (stpscan.hasNext()) {
			stpwords.add(stpscan.nextLine());}
		// Reading file and comparing words
		while(fscan.hasNext()) {
			// Reach next word
			String nextWord = fscan.next();
			nextWord = nextWord.replaceAll("\\p{Punct}", "").toLowerCase();
			// Check if it's in the word list
			if (words.contains(nextWord.toLowerCase())) {
				int index = words.indexOf(nextWord);
				count.set(index, count.get(index) + 1);}
			else {
				if(!stpwords.contains(nextWord.toLowerCase())) {
					words.add(nextWord.toLowerCase()); count.add(1);}}}		
		count.remove(Collections.max(count));
		// Output
		int maxindex = count.indexOf(Collections.max(count));
		System.out.println(words.get(maxindex));

		
		// Close files
		fscan.close(); fIn.close(); stpIn.close(); stpscan.close();
	}

}
