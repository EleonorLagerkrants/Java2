package Java2.el222ja_assign3.count_words;

import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class IdentifyWordsMain {

	public static void main(String[] args) {
		try {
			File file = new File("C:\\Temp\\countWords.txt");
			Scanner scan = new Scanner(	new FileReader(file));
			StringBuilder word = new StringBuilder();
			PrintWriter out = new PrintWriter("C:\\Temp\\words.txt");
			String output = "";
			String str = "";
			while(scan.hasNext()) {
				str = scan.nextLine();
				for(int i=0; i<str.length(); i++) {
					char c = str.charAt(i);
					if(Character.isAlphabetic(c) || Character.isWhitespace(c) )
						word.append(c);
				}
				word.append("\r\n");
			}
			output = word.toString();
			out.println(output);
			System.out.print("words.txt changed");
			out.close();
			scan.close();
		}
		catch  (Exception e ) {
			System.out.print(e.getMessage());
		}
	}
}